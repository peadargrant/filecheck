/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package checks;

import checker.CheckImplementation;
import checker.CheckResult;
import java.io.InputStream;

/**
 * Fake check that is designed to always pass
 * 
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class FakeCheck extends CheckImplementation {

    @Override
    public CheckResult runCheck(InputStream input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
