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
