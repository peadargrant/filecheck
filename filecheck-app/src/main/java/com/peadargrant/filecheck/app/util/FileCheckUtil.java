/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package com.peadargrant.filecheck.app.util;

import com.peadargrant.filecheck.app.gui.AssignmentsProvider;
import java.io.File;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class FileCheckUtil {
    
    public static void main(String[] args) throws Exception
    {
        UtilityRunner ur = new UtilityRunner(); 
        
        switch ( args.length )
        {
            case 2:
                ur.runChecks(args[1], args[0]);
                break;
            default:
                System.out.println("usage: java -jar FileCheck.jar FileCheckUtil <assignmentcode> <jar/zip file>\n");
                System.out.println("where assignment is one of:\n");
                ur.printAssignments();
                break;
        }
    }
    
}
