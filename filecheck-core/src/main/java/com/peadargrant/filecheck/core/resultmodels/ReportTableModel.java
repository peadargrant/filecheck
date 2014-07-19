/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package com.peadargrant.filecheck.core.resultmodels;

import com.peadargrant.filecheck.core.checker.CheckReport;
import com.peadargrant.filecheck.core.checker.CheckResult;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class ReportTableModel extends AbstractTableModel implements CheckReport {
    
    private ArrayList<CheckResult> checkResults; 
    private SummaryTableModel summaryTableModel; 
    private String assignmentName;
    
    @Override
    public void setAssignmentName(String assignmentName)
    {
        this.assignmentName = assignmentName;
    }
    
    public String getAssignmentName()
    {
        return this.assignmentName;
    }

    public SummaryTableModel getSummaryTableModel() {
        return summaryTableModel;
    }

    public void setSummaryTableModel(SummaryTableModel summaryTableModel) {
        this.summaryTableModel = summaryTableModel;
    }
    
    public ReportTableModel(SummaryTableModel summaryTableModel)
    {
        this.checkResults = new ArrayList<>(); 
        this.summaryTableModel = summaryTableModel;
    }

    @Override
    public int getRowCount() {
        return checkResults.size();
    }

    @Override
    public int getColumnCount() {
        return 4; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        CheckResult checkResult = checkResults.get(rowIndex);
        
        switch ( columnIndex ) 
        {
            case 0:
                return checkResult.getPath();
            case 1:
                return checkResult.getDescription(); 
            case 2: 
                return checkResult.getResultText();
            case 3: 
                return checkResult.getOutcome(); 
            default:
                return ""; 
        }
        
    }
    
    @Override
    public String getColumnName(int columnIndex)
    {
        switch ( columnIndex )
        {
            case 0:
                return "Path"; 
            case 1:
                return "Description"; 
            case 2:
                return "Result"; 
            case 3:
                return "Outcome"; 
            default:
                return ""; 
        }
    }

    @Override
    public void clear() {
        this.checkResults.clear();
        this.fireTableDataChanged();
        this.summaryTableModel.clear();
    }

    @Override
    public void post(CheckResult checkResult) {
        this.checkResults.add(checkResult);
        this.fireTableDataChanged();
        this.summaryTableModel.increment(checkResult.getOutcome());
    }

}
