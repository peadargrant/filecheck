/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package checks;

import checker.CheckImplementation;
import checker.CheckResult;
import checker.Outcome;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class XmlWellFormed extends CheckImplementation {
    
    @Override
    public void runCheck(InputStream input, CheckResult cr) {
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try
        {
            db = dbf.newDocumentBuilder(); 
        }
        catch ( ParserConfigurationException e )
        {
            cr.setResultText("Parser setup error");
            cr.setOutcome(Outcome.CHECK_FAILURE);
            return; 
        }
        
        Document doc = null;
        try
        {
            doc = db.parse(input);
            cr.setResultText("well-formed");
            cr.setOutcome(Outcome.PASS);
        }
        catch ( SAXException e )
        {
            cr.setResultText("not well-formed");
            cr.setOutcome(Outcome.FAIL);
        }
        catch ( IOException e )
        {
            cr.setResultText("IO error");
            cr.setOutcome(Outcome.CHECK_FAILURE);
        }
        
    }

    @Override
    public String getDescription() {
        return "well-formed XML"; 
    }
    
}
