/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package com.peadargrant.filecheck.app.gui;

import com.peadargrant.filecheck.core.assignments.Assignment;
import com.peadargrant.filecheck.core.checker.Outcome;
import java.awt.Color;
import javax.swing.SwingWorker;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class CheckRunner extends SwingWorker<Void,Void> {
    
    private Assignment assignment; 
    private boolean colorEnabled;
    private FileCheckGui fileCheckGui;

    public FileCheckGui getFileCheckGui() {
        return fileCheckGui;
    }

    public void setFileCheckGui(FileCheckGui fileCheckGui) {
        this.fileCheckGui = fileCheckGui;
    }

    /**
     * Get the value of colorEnabled
     *
     * @return the value of colorEnabled
     */
    public boolean isColorEnabled() {
        return colorEnabled;
    }

    /**
     * Set the value of colorEnabled
     *
     * @param colorEnabled new value of colorEnabled
     */
    public void setColorEnabled(boolean colorEnabled) {
        this.colorEnabled = colorEnabled;
    }


    @Override
    protected Void doInBackground() throws Exception {
        
        fileCheckGui.getChecker().runChecks(fileCheckGui.getSelectedFile(), this.assignment ) ;
        
        return null;
        
    }
    
    @Override
    protected void done() {
        
        Outcome finalOutcome = fileCheckGui.getReportTableModel().getSummaryTableModel().getFinalOutcome();
        
        fileCheckGui.getOutcomeDisplay().setText(finalOutcome.toString());
        if ( this.colorEnabled==true )
        {
            fileCheckGui.getOutcomeDisplay().setBackground(finalOutcome.getSaturatedColor());
        }
        else
        {
            fileCheckGui.getOutcomeDisplay().setBackground(Color.BLACK); 
        }
        
        this.fileCheckGui.setTestInProgress(false);
    }
    
    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
      
}
