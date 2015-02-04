/* 
 * Copyright (C) 2014 Peadar Grant
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.peadargrant.filecheck.core.checker;

import com.peadargrant.filecheck.core.assignments.Assignment;
import com.peadargrant.filecheck.core.assignments.Check;
import com.peadargrant.filecheck.core.assignments.Content;
import com.peadargrant.filecheck.core.assignments.Pattern;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class Checker {

    private CheckReport report;
    private HashMap<Check, CheckImplementation> checkImplementations;

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

    public Checker() {
        this.report = null;
        this.checkImplementations = new HashMap<>();
    }

    /**
     * Checks if the archive has the name specified.
     *
     * @param inputFile
     * @param assignment
     */
    private void checkArchiveName(File inputFile, Assignment assignment) {
        if (null == assignment.getArchivename()) {
            return;
        }

        CheckResult checkResult = new CheckResult();
        checkResult.setPath(assignment.getArchivename());
        checkResult.setDescription("archive name matches");
        checkResult.setResultText(inputFile.getName());

        // Pass if names match, otherwise fail.
        if (inputFile.getName().equals(assignment.getArchivename())) {
            checkResult.setOutcome(Outcome.PASS);
        } else {
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
    private JarEntry getJarEntryForPath(JarFile jarFile, Content content) {
        CheckResult existenceResult = new CheckResult();
        existenceResult.setPath(content.getPath());
        existenceResult.setDescription("file exists");
        JarEntry jarEntry = jarFile.getJarEntry(content.getPath());
        if (null == jarEntry) {
            existenceResult.setResultText("does not exist");
            if (content.isAdvisory()) {
                existenceResult.setOutcome(Outcome.ADVISORY);
            } else {
                existenceResult.setOutcome(Outcome.FAIL);
            }
        } else {
            existenceResult.setResultText("exists");
            existenceResult.setOutcome(Outcome.PASS);
        }
        if ( !content.isCustom() ) {
            this.report.post(existenceResult);
        }
            
        return jarEntry;
    }

    /**
     * Runs all checks specified in the Assignment for the file.
     *
     * @param inputFile input JAR/ZIP file
     * @param assignment assignment tree
     */
    public void runChecks(File inputFile, Assignment assignment) throws Exception {
        // Clear the report if it exists
        if (null == this.report) {
            throw new Exception("Null report destination");
        }

        // Clear the report
        report.clear();

        // Set report title
        report.setAssignmentName(assignment.getTitle());

        // Check if the file has the right name
        this.checkArchiveName(inputFile, assignment);

        // JAR file
        JarFile jarFile = new JarFile(inputFile);

        // Add in the pattern matched files for checking
        // adapted from:
        // http://stackoverflow.com/questions/9802785/find-all-resource-with-specific-extension-from-jar-programmatically
        ArrayList<Content> autoContent = new ArrayList<>();
        for (Content content : assignment.getContent()) {
            autoContent.add(content);
        }
        for (Enumeration<JarEntry> em = jarFile.entries(); em.hasMoreElements();) {
            String filePath = em.nextElement().toString();
            for (Pattern pattern : assignment.getPattern()) {
                
                if (filePath.startsWith("__MACOSX")) {
                    continue;
                }
                
                if (filePath.endsWith(pattern.getMatch())) {
                    Content content = new Content();
                    content.setPath(filePath);
                    content.setAdvisory(false);
                    content.setCustom(true);
                    for (Check check : pattern.getCheck()) {
                        content.getCheck().add(check);
                    }
                    autoContent.add(content);
                }
            }

        }

        // Loop over all files
        for (Content content : autoContent) {
            
            // Check that file exists
            JarEntry jarEntry = this.getJarEntryForPath(jarFile, content);

            // Run each check for the file
            for (Check check : content.getCheck()) {
                CheckResult checkResult = new CheckResult();
                checkResult.setPath(content.getPath());

                try {
                    CheckImplementation checkImplementation = this.getImplementationForCheck(check);

                    checkResult.setDescription(checkImplementation.toString());

                    if (jarEntry == null) {
                        checkResult.setResultText("(nonexistent file)");
                        checkResult.setOutcome(Outcome.SKIPPED);
                    } else {
                        checkImplementation.runCheck(jarFile.getInputStream(jarEntry), checkResult);
                    }

                } catch (ClassNotFoundException e) {

                    checkResult.setDescription("(not found)");
                    checkResult.setResultText("(not found)");
                    checkResult.setOutcome(Outcome.CHECK_FAILURE);
                } catch (IllegalAccessException | InstantiationException e) {
                    checkResult.setDescription("(setup failure)");
                    checkResult.setResultText("(setup failure)");
                    checkResult.setOutcome(Outcome.CHECK_FAILURE);
                } catch (Exception e) {
                    e.printStackTrace();
                    checkResult.setDescription("(i/o exception occurred)");
                    checkResult.setOutcome(Outcome.CHECK_FAILURE);
                } finally {
                    if (checkResult.getOutcome().causesFailure() && check.isAdvisory()) {
                        checkResult.setOutcome(Outcome.ADVISORY);
                    }
                    this.report.post(checkResult);
                }

            }
        }

    }

    /**
     * Return the implementation of a given check, and instantiate if needed.
     *
     * @param check
     * @return
     * @throws Exception
     */
    private CheckImplementation getImplementationForCheck(Check check) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (!checkImplementations.containsKey(check)) {
            CheckImplementation checkImplementation = (CheckImplementation) Class.forName("com.peadargrant.filecheck.core.checks." + check.getProcedure()).newInstance();
            checkImplementation.applyParameters(check.getParameter());
            checkImplementations.put(check, checkImplementation);
        }

        return checkImplementations.get(check);
    }

}
