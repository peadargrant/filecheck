/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package checks;

import checker.CheckImplementation;
import checker.CheckResult;
import checker.Outcome;
import java.io.InputStream;

/**
 * Fake check that is designed to always pass
 * 
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class FakeCheck extends CheckImplementation {

    @Override
    public CheckResult runCheck(InputStream input, CheckResult cr) {
        
        CheckResult checkResult = new CheckResult();
        checkResult.setResultText("Fake check success");
        checkResult.setOutcome(Outcome.PASS);
        return checkResult; 
        
    }
    
}
