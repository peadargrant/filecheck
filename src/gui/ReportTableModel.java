/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package gui;

import checker.CheckReport;
import checker.CheckResult;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class ReportTableModel extends AbstractTableModel implements CheckReport {
    
    private ArrayList<CheckResult> checkResults; 
    
    public ReportTableModel()
    {
        checkResults = new ArrayList<>(); 
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
    }

    @Override
    public void post(CheckResult checkResult) {
        this.checkResults.add(checkResult);
        this.fireTableDataChanged();
    }


}
