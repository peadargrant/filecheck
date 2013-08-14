/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package gui;

import assignments.Assignment;
import checker.Checker;
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

    @Override
    protected Void doInBackground() throws Exception {
        
        checker.runChecks(this.file, this.assignment ) ;
        
        return null;
        
    }
    
    @Override
    protected void done() {
        
        String finalOutcome = reportTableModel.getSummaryTableModel().getFinalOutcome();
        
        outcomeDisplay.setText(finalOutcome);
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
