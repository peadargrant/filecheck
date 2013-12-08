/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package batchgui;

import gui.ReportTableModel;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class BatchReportModel extends AbstractTableModel {
    
    private ArrayList<ReportTableModel> reports;
    
    public BatchReportModel()
    {
        reports = new ArrayList<>(); 
    }

    @Override
    public int getRowCount() {
        return reports.size();
    }

    @Override
    public int getColumnCount() {
        if ( reports.size() > 0 )
        {
            return reports.get(0).getRowCount();
        }
        else
        {
            return 0;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return reports.get(rowIndex).getValueAt(columnIndex, 3);
    }
    
    public void clear()
    {
        reports.clear();
        this.fireTableDataChanged();
    }
    
    public void post(ReportTableModel batchReport)
    {
        reports.add(batchReport);
        this.fireTableDataChanged();
    }
    
}
