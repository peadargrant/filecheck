/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package checks;

import checker.CheckImplementation;
import checker.CheckResult;
import java.io.InputStream;

/**
 * Evaluates the given XPath expression on the XML file specified
 * 
 * If the XPath can be evaluated at all, the test passes and the evaluation 
 * result is passed in the result.
 * 
 * Best used for data extraction. 
 * 
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class XPathEvaluation extends CheckImplementation {

    @Override
    public CheckResult runCheck(InputStream input, CheckResult cr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
