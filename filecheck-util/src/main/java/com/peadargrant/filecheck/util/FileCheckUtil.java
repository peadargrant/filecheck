/*
 *  Copyright Peadar Grant.
 *  All rights reserved.
 */
package com.peadargrant.filecheck.util;

import com.peadargrant.filecheck.core.assignments.Assignment;
import com.peadargrant.filecheck.core.assignments.Assignments;
import com.peadargrant.filecheck.core.checker.Checker;
import com.peadargrant.filecheck.core.provider.AssignmentsProvider;
import java.io.File;
import java.util.List;

/**
 *
 * @author Peadar Grant
 */
public class FileCheckUtil {
    
    public static void main(String args[]) throws Exception {
        
        if ( args.length == 1 ) {
            printAssignments(args[0]);
            return;
        }
        
        if ( args.length == 3 ) {
            checkAssignment(args[0], args[1], args[2]);
            return;
        }
        
        System.out.println("usage: filecheck-util <xml file> <assignment code> <archivepath>");
        
    }
    
    public static void printAssignments(String xmlFile) throws Exception {
        
        AssignmentsProvider provider = new AssignmentsProvider();
        
        Assignments assignments = provider.customLibrary(xmlFile);
        
        List<Assignment> assignmentList = assignments.getAssignment();
        for ( Assignment assignment : assignmentList ) {
            System.out.println(assignment.getCode() + " " + assignment.getTitle());
        }
    }
    
    public static void checkAssignment(String libraryPath, String code, String path) throws Exception {
        
        AssignmentsProvider provider = new AssignmentsProvider();
        
        Assignments assignments = provider.customLibrary(libraryPath);
        
        List<Assignment> assignmentList = assignments.getAssignment();
        Assignment selectedAssignment = null;
        for ( Assignment assignment : assignmentList ) {
            if ( code.equals(assignment.getCode()) ) {
                selectedAssignment = assignment;
                break;
            }
        }
        
        if ( selectedAssignment==null ) {
            System.err.println("code not found"); 
            return;
        } 
        System.out.println("* "+selectedAssignment.getCode());
        System.out.println("% "+selectedAssignment.getTitle());
        
        UtilCheckReport ucr = new UtilCheckReport();
        Checker checker = new Checker();
        checker.setReport(ucr);
        
        File file = new File(path);
        checker.runChecks(file, selectedAssignment);
        
        System.out.println("= "+ucr.getFinalOutcome());
    }
    
}
