/*
 *  Copyright Peadar Grant.
 *  All rights reserved.
 */
package com.peadargrant.filecheck.util;

import com.peadargrant.filecheck.core.assignments.Assignment;
import com.peadargrant.filecheck.core.assignments.Assignments;
import com.peadargrant.filecheck.core.checker.Checker;
import com.peadargrant.filecheck.core.checker.FinalOutcome;
import com.peadargrant.filecheck.core.provider.AssignmentsProvider;
import java.io.File;
import java.util.List;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

/**
 *
 * @author Peadar Grant
 */
public class FileCheckUtil {
    
    public static void main(String args[]) throws Exception {
        
        ArgumentParser parser = ArgumentParsers.newArgumentParser("filecheck")
                .defaultHelp(true)
                .description("Check that files comply with given criteria.");
        parser.addArgument("definitionsFile")
                .help("definitions file to load assignment from")
                .required(true);
        parser.addArgument("code")
                .help("assignment code to check against")
                .required(false);
        parser.addArgument("archive")
                .help("file name to check")
                .required(false);
        parser.addArgument("-r", "--return")
                .help("return error status on failure")
                .action(Arguments.storeTrue())
                .setDefault(false);
        
        try {
            Namespace res = parser.parseArgs(args);
            
            if (  res.getString("code")==null && res.getString("archive")==null  ) {
                printAssignments(res.getString("definitionsFile"));
            } else {
                FinalOutcome finalOutcome = checkAssignment(res.getString("definitionsFile"), res.getString("code"), res.getString("archive"));
                if ( res.getBoolean("return")) {
                    if ( finalOutcome != FinalOutcome.PASS ) {
                        System.exit(1);
                    }
                }
            }
            
        } catch (ArgumentParserException e) {
            parser.handleError(e);
        }
        
        
    }
    
    public static void printAssignments(String xmlFile) throws Exception {
        
        AssignmentsProvider provider = new AssignmentsProvider();
        
        Assignments assignments = provider.customLibrary(xmlFile);
        
        List<Assignment> assignmentList = assignments.getAssignment();
        for ( Assignment assignment : assignmentList ) {
            System.out.println(assignment.getCode() + " " + assignment.getTitle());
        }
    }
    
    public static FinalOutcome checkAssignment(String libraryPath, String code, String path) throws Exception {
        
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
            throw new Exception("assignment code not found");
        } 
        System.out.println("* "+selectedAssignment.getCode());
        System.out.println("% "+selectedAssignment.getTitle());
        
        UtilCheckReport ucr = new UtilCheckReport();
        Checker checker = new Checker();
        checker.setReport(ucr);
        
        File file = new File(path);
        checker.runChecks(file, selectedAssignment);
        
        System.out.println("= "+ucr.getFinalOutcome());
        
        return ucr.getFinalOutcome();
    }
    
}
