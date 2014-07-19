/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package com.peadargrant.filecheck.app.util;

import com.peadargrant.filecheck.app.assignments.Assignment;
import com.peadargrant.filecheck.app.assignments.Assignments;
import com.peadargrant.filecheck.app.checker.Checker;
import com.peadargrant.filecheck.app.gui.AssignmentsProvider;
import com.peadargrant.filecheck.app.gui.SummaryTableModel;
import java.io.File;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class UtilityRunner {

    private Checker checker;
    private SummaryTableModel stm;
    private TerminalReport report;
    private Assignments assignments;


    public UtilityRunner() throws Exception
    {
        this.checker = new Checker();
        this.stm = new SummaryTableModel(); 
        this.report = new TerminalReport(stm); 
        this.checker.setReport(report);
        
        AssignmentsProvider ap = new AssignmentsProvider();
        this.assignments = ap.defaultLibrary();
    }
    
    public void printAssignments()
    {
        for ( Assignment a : assignments.getAssignment() )
        {
            StringBuilder sb = new StringBuilder(); 
            sb.append(a.getCode());
            sb.append(": ");
            sb.append(a.getTitle());
            System.out.println(sb.toString()); 
        }
    }
    
    public Assignment getAssignmentByCode(final String name) throws AssignmentNotFoundException
    {
        for ( Assignment a : assignments.getAssignment() )
        {
            if ( name.equals(a.getCode()) )
            {
                return a;
            }
        }
        throw new AssignmentNotFoundException(); 
    }
    
    public void runChecks(String fileName, String assignmentCode)
    {
        System.out.println("file name: " + fileName); 
        System.out.println("assignment code " + assignmentCode ); 
        File file = new File(fileName); 
        
        Assignment assignment;
        try {
            assignment = this.getAssignmentByCode(assignmentCode); 
            System.out.println("located assignment"); 
        }
        catch ( AssignmentNotFoundException e )
        {
            System.err.println("Assignment not found."); 
            return;
        }
        
        try {
            checker.runChecks(file, assignment);
        } catch (Exception ex) {
            System.out.println("exception occurred during check - terminating"); 
            return; 
        }
        
        System.out.println("--------------");
        System.out.println("SUMMARY REPORT");
        System.out.println("--------------");
        for ( int k = 0; k < stm.getRowCount(); k++ )
        {
            System.out.println(stm.getValueAt(k, 0) + ": " + stm.getValueAt(k, 1));
        }
        
        System.out.println("TEST OUTCOME: " + stm.getFinalOutcome());
        
    }
}
