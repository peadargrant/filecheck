
package checker;

import assignments.Assignment;
import java.io.File;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class Checker {
    
    private CheckReport report;

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
        
        
        
    }
    
}
