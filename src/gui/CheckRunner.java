/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package gui;

import assignments.Assignment;
import checker.Checker;
import java.io.File;
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

    @Override
    protected Void doInBackground() throws Exception {
        
        checker.runChecks(this.file, this.assignment ) ;
        
        return null;
        
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
    
}
