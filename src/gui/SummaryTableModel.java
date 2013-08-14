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
    
    public int getNumberOfTests()
    {
        int nTests = 0; 
        for ( Integer n : this.tally.values() )
        {
            nTests = nTests + n; 
        }
        return nTests; 
    }
    
    public String getFinalOutcome()
    {
        int nTests = this.getNumberOfTests(); 
        int nPasses = 0; 
        if ( this.tally.containsKey(Outcome.PASS) )
        {
            nPasses = this.tally.get(Outcome.PASS);
        }
        
        if ( nTests == 0 )
        {
            return "";
        }
        else if ( nTests == nPasses )
        {
            return Outcome.PASS.toString(); 
        }
        else
        {
            return Outcome.FAIL.toString(); 
        }
    }

}
