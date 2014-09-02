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
package com.peadargrant.filecheck.app.gui;

import javax.swing.SwingWorker;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class AssignmentsLoader extends SwingWorker<Void,Void> {
    
    private final AssignmentsModel atm; 
    private final String location;
    
    /**
     * Creates the assignment loader for the assignments table model
     * 
     * @param atm the assignment table model to be operated on
     * @param location
     */
    public AssignmentsLoader(AssignmentsModel atm, String location)
    {
        this.atm = atm; 
        this.location = location; 
    }

    @Override
    protected Void doInBackground() throws Exception {
        
        this.atm.refreshAssignments(location);
        
        return null;
        
    }
    
}
