package com.peadargrant.filecheck.util;

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


import com.peadargrant.filecheck.core.checker.CheckReport;
import com.peadargrant.filecheck.core.checker.CheckResult;
import com.peadargrant.filecheck.core.resultmodels.SummaryTableModel;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class TerminalReport implements CheckReport {
    
    private SummaryTableModel stm;
    private String assignmentName;
    
    @Override
    public void setAssignmentName(String assignmentName)
    {
        this.assignmentName = assignmentName;
    }

    public TerminalReport(SummaryTableModel stm)
    {
        this.stm = stm;
    }

    @Override
    public void clear() {
        
        stm.clear();
        
        System.out.println("-------------");
        System.out.println("DETAIL REPORT");
        System.out.println("-------------");
    }

    @Override
    public void post(CheckResult checkResult) {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(checkResult.getPath());
        sb.append(", ");
        
        sb.append(checkResult.getDescription());
        sb.append(", ");
        
        sb.append(checkResult.getResultText());
        sb.append(", ");
        
        sb.append(checkResult.getOutcome());
        stm.increment(checkResult.getOutcome());
        
        System.out.println(sb.toString()); 
        
    }
    
}
