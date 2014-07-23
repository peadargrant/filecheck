/* 
 * Copyright (C) 2014 Peadar Grant
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.peadargrant.filecheck.core.checks;

import com.peadargrant.filecheck.core.checker.CheckImplementation;
import com.peadargrant.filecheck.core.checker.CheckResult;
import com.peadargrant.filecheck.core.checker.Outcome;
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
