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
package com.peadargrant.filecheck.util;

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
