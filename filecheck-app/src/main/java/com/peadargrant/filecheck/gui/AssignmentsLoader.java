/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package com.peadargrant.filecheck.gui;

import javax.swing.SwingWorker;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class AssignmentsLoader extends SwingWorker<Void,Void> {
    
    private AssignmentsModel atm; 
    private String location;
    
    /**
     * Creates the assignment loader for the assignments table model
     * 
     * @param atm the assignment table model to be operated on
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
