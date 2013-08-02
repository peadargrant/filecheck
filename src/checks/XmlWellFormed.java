/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package checks;

import checker.CheckImplementation;
import checker.CheckResult;
import java.io.InputStream;

/**
 * Checks if an XML file is well-formed by attempting to parse the DOM.
 * 
 * If this succeeds then the test passes.
 * Otherwise it fails.
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class XmlWellFormed extends CheckImplementation {

    @Override
    public CheckResult runCheck(InputStream input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
