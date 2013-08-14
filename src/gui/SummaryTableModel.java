/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package gui;

import checker.Outcome;
import java.util.HashMap;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class SummaryTableModel extends AbstractTableModel {
    
    private HashMap<Outcome,Integer> tally;
    
    public SummaryTableModel()
    {
        this.tally = new HashMap<>(); 
    }

    @Override
    public int getRowCount() {
        return tally.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public String getColumnName(int columnIndex)
    {
        switch ( columnIndex )
        {
            case 0:
                return "Outcome";
            case 1:
                return "Count";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Outcome requiredOutcome = (Outcome) tally.keySet().toArray()[rowIndex]; 
        
        switch ( columnIndex )
        {
            case 0:
                // Want the outcome name
                return requiredOutcome; 
            case 1:
                // Want the count
                return tally.get(requiredOutcome); 
            default:
                return ""; 
        }
        
    }
    
    public void clear()
    {
        this.tally.clear();
        this.fireTableDataChanged();
    }
    
    public void increment(Outcome outcome)
    {
        if ( !this.tally.containsKey(outcome) )
        {
            this.tally.put(outcome, 0); 
        }
        this.tally.put(outcome, this.tally.get(outcome) + 1 );
        this.fireTableDataChanged();
    }
    
}
