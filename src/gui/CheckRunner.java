/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package gui;

import assignments.Assignment;
import checker.Checker;
import checker.Outcome;
import java.awt.Color;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class CheckRunner extends SwingWorker<Void,Void> {
    
    private ReportTableModel reportTableModel;
    private Assignment assignment; 
    private Checker checker; 
    private File file;
    private JLabel outcomeDisplay; 
        private boolean colorEnabled;

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
        
        checker.runChecks(this.file, this.assignment ) ;
        
        return null;
        
    }
    
    @Override
    protected void done() {
        
        Outcome finalOutcome = reportTableModel.getSummaryTableModel().getFinalOutcome();
        
        outcomeDisplay.setText(finalOutcome.toString());
        if ( this.colorEnabled==true )
        {
            outcomeDisplay.setBackground(finalOutcome.getSaturatedColor());
        }
        else
        {
            outcomeDisplay.setBackground(Color.BLACK); 
        }
    }
    
    public void setReportTableModel(ReportTableModel reportTableModel) {
        this.reportTableModel = reportTableModel;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public void setChecker(Checker checker) {
        this.checker = checker;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    public JLabel getOutcomeDisplay() {
        return outcomeDisplay;
    }

    public void setOutcomeDisplay(JLabel outcomeDisplay) {
        this.outcomeDisplay = outcomeDisplay;
    }
    
}
