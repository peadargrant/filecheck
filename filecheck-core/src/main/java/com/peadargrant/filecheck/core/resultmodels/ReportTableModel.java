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

import com.peadargrant.filecheck.core.checker.CheckReport;
import com.peadargrant.filecheck.core.checker.CheckResult;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class ReportTableModel extends AbstractTableModel implements CheckReport {

    private final ArrayList<CheckResult> checkResults;
    private SummaryTableModel summaryTableModel;
    private String assignmentName;

    @Override
    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getAssignmentName() {
        return this.assignmentName;
    }

    public SummaryTableModel getSummaryTableModel() {
        return summaryTableModel;
    }

    public void setSummaryTableModel(SummaryTableModel summaryTableModel) {
        this.summaryTableModel = summaryTableModel;
    }

    public ReportTableModel(SummaryTableModel summaryTableModel) {
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

        switch (columnIndex) {
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
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
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
