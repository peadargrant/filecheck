/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package util;

import checker.CheckReport;
import checker.CheckResult;
import gui.SummaryTableModel;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class TerminalReport implements CheckReport {
    
    private SummaryTableModel stm;

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
