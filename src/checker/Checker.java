
package checker;

import assignments.Assignment;
import assignments.Check;
import assignments.Content;
import java.io.File;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class Checker {
    
    private CheckReport report;
    private HashMap<Check,CheckImplementation> checkImplementations;

    /**
     * Get the value of report
     *
     * @return the value of report
     */
    public CheckReport getReport() {
        return report;
    }

    /**
     * Set the value of report
     *
     * @param report new value of report
     */
    public void setReport(CheckReport report) {
        this.report = report;
    }

    
    public Checker()
    {
        this.report = null;
        this.checkImplementations = new HashMap<>(); 
    }
    
    /**
     * Checks if the archive has the name specified.
     * 
     * @param inputFile
     * @param assignment
     */
    private void checkArchiveName(File inputFile, Assignment assignment)
    {
        CheckResult checkResult = new CheckResult(); 
        checkResult.setPath(assignment.getArchivename());
        checkResult.setDescription("archive name matches");
        checkResult.setResultText(inputFile.getName());
        
        // Pass if names match, otherwise fail.
        if ( inputFile.getName().equals(assignment.getArchivename()) )
        {
            checkResult.setOutcome(Outcome.PASS);
        }
        else
        {
            checkResult.setOutcome(Outcome.FAIL);
        } 
        
        // Put it in the report
        this.report.post(checkResult);
    }
    
    /**
     * Checks if the JAR/ZIP file has an entry at the path given by the content
     * 
     * @param jarFile
     * @param content
     * @return the JarEntry
     */
    private JarEntry getJarEntryForPath(JarFile jarFile, Content content)
    {
        CheckResult existenceResult = new CheckResult(); 
        existenceResult.setPath(content.getPath());
        existenceResult.setDescription("file exists");
        JarEntry jarEntry = jarFile.getJarEntry(content.getPath());
        if ( null==jarEntry )
        {
            existenceResult.setResultText("does not exist");
            existenceResult.setOutcome(Outcome.FAIL);
        }
        else
        {
            existenceResult.setResultText("exists");
            existenceResult.setOutcome(Outcome.PASS);
        }
        this.report.post(existenceResult);
        
        return jarEntry;
    }
    
    /**
     * Runs all checks specified in the Assignment for the file.
     * 
     * @param inputFile input JAR/ZIP file
     * @param assignment assignment tree
     */
    public void runChecks(File inputFile, Assignment assignment) throws Exception
    {
        // Clear the report if it exists
        if ( null == this.report )
        {
            throw new Exception("Null report destination"); 
        }
        
        // Clear the report
        report.clear();
        
        // Check if the file has the right name
        this.checkArchiveName(inputFile, assignment);
        
        // JAR file
        JarFile jarFile = new JarFile(inputFile); 
        
        // Loop over all files
        for ( Content content : assignment.getContent() )
        {
            // Check that file exists
            JarEntry jarEntry = this.getJarEntryForPath(jarFile, content);
            
            // Run each check for the file
            for ( Check check : content.getCheck() )
            {   
                CheckResult checkResult = new CheckResult(); 
                checkResult.setPath(content.getPath());
                
                
                try {
                    CheckImplementation checkImplementation = this.getImplementationForCheck(check);  
                    
                    checkResult.setDescription(checkImplementation.getDescription());
                    
                    if ( jarEntry == null )
                    {
                        checkResult.setResultText("(nonexistent file)");
                        checkResult.setOutcome(Outcome.SKIPPED);
                    }
                    else
                    {
                        checkImplementation.runCheck( jarFile.getInputStream( jarEntry ), checkResult );
                    }
                    
                }
                catch ( ClassNotFoundException e )
                {

                    checkResult.setDescription("(not found)");
                    checkResult.setResultText("(not found)");
                    checkResult.setOutcome(Outcome.CHECK_FAILURE);
                }
                catch ( IllegalAccessException | InstantiationException e  )
                {
                    checkResult.setDescription("(setup failure)");
                    checkResult.setResultText("(setup failure)");
                    checkResult.setOutcome(Outcome.CHECK_FAILURE);   
                }
                finally
                {
                    this.report.post(checkResult); 
                }
                
            }
        }
        
    }
    
    /**
     * Return the implementation of a given check, and instantiate if needed.
     * @param check
     * @return
     * @throws Exception 
     */
    private CheckImplementation getImplementationForCheck(Check check) throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        if ( !checkImplementations.containsKey(check) )
        {
            CheckImplementation checkImplementation = (CheckImplementation) Class.forName("checks." + check.getProcedure()).newInstance();
            checkImplementation.applyParameters( check.getParameter() );
            checkImplementations.put(check, checkImplementation);
        }
        
        return checkImplementations.get(check);
    }
    
}