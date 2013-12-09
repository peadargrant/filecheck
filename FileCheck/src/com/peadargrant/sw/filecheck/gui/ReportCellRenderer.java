package com.peadargrant.sw.filecheck.gui;

import com.peadargrant.sw.filecheck.checker.Outcome;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class ReportCellRenderer extends DefaultTableCellRenderer 
{
    private AbstractTableModel tableModel;
    private int targetColumn;

    public int getTargetColumn() {
        return targetColumn;
    }

    public void setTargetColumn(int targetColumn) {
        this.targetColumn = targetColumn;
    }

    public AbstractTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(AbstractTableModel rtm) {
        this.tableModel = rtm;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        Color colorForOutcome = ((Outcome) tableModel.getValueAt(row, this.targetColumn)).getColor();
        if ( isSelected )
        {
            c.setForeground(colorForOutcome);
            c.setBackground(Color.BLACK);
        }
        else
        {
            c.setBackground(colorForOutcome);
            c.setForeground(Color.BLACK);
        }
        return c;
    }
}