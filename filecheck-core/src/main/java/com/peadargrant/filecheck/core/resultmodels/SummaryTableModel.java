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
package com.peadargrant.filecheck.core.resultmodels;

import com.peadargrant.filecheck.core.checker.FinalOutcome;
import com.peadargrant.filecheck.core.checker.Outcome;
import java.util.HashMap;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class SummaryTableModel extends AbstractTableModel {

    private final HashMap<Outcome, Integer> tally;

    public SummaryTableModel() {
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
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
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

        switch (columnIndex) {
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

    public void clear() {
        this.tally.clear();
        this.fireTableDataChanged();
    }

    public void increment(Outcome outcome) {
        if (!this.tally.containsKey(outcome)) {
            this.tally.put(outcome, 0);
        }
        this.tally.put(outcome, this.tally.get(outcome) + 1);
        this.fireTableDataChanged();
    }

    private int getNumberOfTests() {
        int nTests = 0;
        for (Integer n : this.tally.values()) {
            nTests = nTests + n;
        }
        return nTests;
    }

    public FinalOutcome getFinalOutcome() {

        FinalOutcome finalOutcome = null;
        if ( this.getNumberOfTests() > 0 ) {
            finalOutcome = FinalOutcome.PASS;
        }
        for ( Outcome outcome : Outcome.values() ) {
            if ( this.tally.containsKey(outcome) && outcome.causesFailure() ) {
                finalOutcome = FinalOutcome.FAIL;
                return finalOutcome;
            }
        }
        
        return finalOutcome;
    }

}
