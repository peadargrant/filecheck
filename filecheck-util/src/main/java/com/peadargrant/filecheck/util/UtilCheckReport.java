package com.peadargrant.filecheck.util;


import com.peadargrant.filecheck.core.checker.CheckReport;
import com.peadargrant.filecheck.core.checker.CheckResult;
import com.peadargrant.filecheck.core.checker.FinalOutcome;
import com.peadargrant.filecheck.core.checker.Outcome;

/*
 *  Copyright Peadar Grant.
 *  All rights reserved.
 */
/**
 *
 * @author Peadar Grant
 */
public class UtilCheckReport implements CheckReport {

    private FinalOutcome finalOutcome = FinalOutcome.PASS;
    
    @Override
    public void clear() {
        // nothing - it will never be cleared.
    }

    @Override
    public void post(CheckResult checkResult) {
        if ( checkResult.getOutcome().causesFailure() ) {
            finalOutcome = FinalOutcome.FAIL;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("+ ");
        sb.append(checkResult.getPath());
        sb.append(" | ");
        sb.append(checkResult.getDescription());
        sb.append(" | ");
        sb.append(checkResult.getResultText());
        sb.append(" | ");
        sb.append(checkResult.getOutcome());
        System.out.println(sb.toString());
    }

    @Override
    public void setAssignmentName(String assignmentName) {
        // nothing - no need for it
    }
    
    public FinalOutcome getFinalOutcome() {
        return finalOutcome;
    }
    
}
