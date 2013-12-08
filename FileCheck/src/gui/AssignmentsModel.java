/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package gui;

import assignments.Assignment;
import assignments.Assignments;
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
     * @throws Exception 
     */
    public final void refreshAssignments() throws Exception {

        AssignmentsProvider ap = new AssignmentsProvider();
        this.assignments = ap.defaultLibrary(); 
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
