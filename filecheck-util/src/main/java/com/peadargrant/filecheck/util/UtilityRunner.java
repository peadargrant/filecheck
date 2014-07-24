package com.peadargrant.filecheck.util;

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


import com.peadargrant.filecheck.core.assignments.Assignment;
import com.peadargrant.filecheck.core.assignments.Assignments;
import com.peadargrant.filecheck.core.checker.Checker;
import com.peadargrant.filecheck.core.provider.AssignmentsProvider;
import com.peadargrant.filecheck.core.resultmodels.SummaryTableModel;
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
