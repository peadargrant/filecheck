/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package checks;

import checker.CheckImplementation;
import checker.CheckResult;
import java.io.InputStream;

/**
 * Evaluates the given PDF meta-data field.
 * 
 * Attempts to evaluate the given PDF metadata field.  If the field exists and
 * has non-zero length, a pass results.  Otherwise a fail results.  If the
 * input stream is not actually a PDF file, then the test fails. 
 * 
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class PdfMetaEvaluation extends CheckImplementation {

    @Override
    public CheckResult runCheck(InputStream input) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
