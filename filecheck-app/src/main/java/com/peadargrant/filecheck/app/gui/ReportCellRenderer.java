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

import com.peadargrant.filecheck.core.checker.Outcome;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class ReportCellRenderer extends DefaultTableCellRenderer 
{
    private final AbstractTableModel tableModel;
    private final int targetColumn;
    
    public ReportCellRenderer(AbstractTableModel tableModel, int targetColumn) {
        this.tableModel = tableModel;
        this.targetColumn = targetColumn;
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