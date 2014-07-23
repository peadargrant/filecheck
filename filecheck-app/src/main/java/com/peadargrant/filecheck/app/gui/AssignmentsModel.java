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

import com.peadargrant.filecheck.core.provider.AssignmentsProvider;
import com.peadargrant.filecheck.core.assignments.Assignment;
import com.peadargrant.filecheck.core.assignments.Assignments;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class AssignmentsModel extends AbstractTableModel {
    
    private Assignments assignments;

    /**
     * Refreshes the assignments list
     * 
     * @param location the URL where assignments XML are located
     * @throws Exception 
     */
    public final void refreshAssignments(String location) throws Exception {

        AssignmentsProvider ap = new AssignmentsProvider();
        this.assignments = ap.customLibrary(location); 
        this.fireTableDataChanged();
        
    }

    @Override
    public int getRowCount() {
        
        // return zero if null
        if ( null == this.assignments )
        {
            return 0;
        }
        
        // otherwise length of the list
        return this.assignments.getAssignment().size();
    }

    @Override
    public int getColumnCount() {
        
        // Always only 1 column
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        // Display the title
        return this.assignments.getAssignment().get(rowIndex).getTitle();
    }

    
    @Override
    public String getColumnName(int columnIndex)
    {
        return "Assignment"; 
    }
    
    public Assignment getAssignmentAtIndex(int index)
    {
        return this.assignments.getAssignment().get(index); 
    }

    
}
