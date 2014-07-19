/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package com.peadargrant.filecheck.app.checks;

import com.peadargrant.filecheck.app.checker.CheckImplementation;
import com.peadargrant.filecheck.app.checker.CheckResult;
import com.peadargrant.filecheck.app.checker.Outcome;
import java.io.InputStream;

/**
 * Fake check that is designed to always pass
 * 
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class Fake extends CheckImplementation {

    @Override
    public void runCheck(InputStream input, CheckResult checkResult) {
        
        checkResult.setResultText("Fake check success");
        checkResult.setDescription("Fake check");
        checkResult.setOutcome(Outcome.PASS);
        
    }

    @Override
    public String getDescription() {
        return "fake check"; 
    }
    
}
