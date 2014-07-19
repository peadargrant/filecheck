/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package com.peadargrant.filecheck.app.batchgui;

import com.peadargrant.filecheck.app.assignments.Assignment;
import com.peadargrant.filecheck.app.checker.Checker;
import java.io.File;
import javax.swing.SwingWorker;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class BatchRunner extends SwingWorker<Void,Void> {
    
    
    private Checker checker;
    private Assignment assignment;
    private BatchReportModel batchReportModel;
    private File container;

    public File getContainer() {
        return container;
    }

    public void setContainer(File container) {
        this.container = container;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public BatchReportModel getBatchReportModel() {
        return batchReportModel;
    }

    public void setBatchReportModel(BatchReportModel batchReportModel) {
        this.batchReportModel = batchReportModel;
    }

    public Checker getChecker() {
        return checker;
    }

    public void setChecker(Checker checker) {
        this.checker = checker;
    }

    @Override
    protected Void doInBackground() throws Exception {
        
        
        
        return null;
        
    }
    
}
