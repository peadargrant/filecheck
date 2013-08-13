/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package checks;

import checker.CheckImplementation;
import checker.CheckResult;
import java.io.InputStream;

/**
 * Checks if an XML file obeys the specified XML schema (XSD) file.
 * 
 * If the schema validates, then the test passes.
 * Otherwise the outcome is a fail.
 * If the schema cannot be accessed, then the test itself fails.
 * 
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class XmlSchemaValidates extends CheckImplementation {

    @Override
    public CheckResult runCheck(InputStream input, CheckResult cr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
