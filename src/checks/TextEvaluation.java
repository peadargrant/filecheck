/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package checks;

import checker.CheckImplementation;
import checker.CheckResult;
import java.io.InputStream;

/**
 * Extracts the specified line from the given text file
 * 
 * If the specified line can be extracted at all, the test passes and the text
 * itself is returned as the result.
 * 
 * If the text file does not have the given line, the result is a fail.
 * 
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class TextEvaluation extends CheckImplementation {

    @Override
    public CheckResult runCheck(InputStream input, CheckResult cr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
