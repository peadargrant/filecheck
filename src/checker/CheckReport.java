/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package checker;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public interface CheckReport {
    
    /**
     * Blanks the report for a new check run
     */
    public void clear();
    
    /**
     * Posts a result to the report
     * @param checkResult 
     */
    public void post(CheckResult checkResult);
    
    /**
     * Set assignment name
     * @param assignmentName
     */
    public void setAssignmentName(String assignmentName);
}
