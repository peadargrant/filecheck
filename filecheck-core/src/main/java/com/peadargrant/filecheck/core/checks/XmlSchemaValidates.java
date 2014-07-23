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
import java.net.URL;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class XmlSchemaValidates extends CheckImplementation {
    
    private Validator validator = null;
    private DocumentBuilder documentBuilder = null; 
    
    /**
     * Returns the stored validator object, or sets it up if needed.
     * 
     * @return the shared validator object
     * @throws Exception 
     */
    private Validator getValidator() throws Exception
    {
        if ( this.validator == null )
        {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            
            Schema schema = schemaFactory.newSchema(new URL(this.stringParameters.get("schemaURL")));
            
            this.validator = schema.newValidator(); 
        }
        
        return this.validator;
    }
    
    /**
     * Returns the stored document builder object, or sets it up if needed.
     * 
     * @return the shared documentbuilder object
     * @throws Exception 
     */
    private DocumentBuilder getBuilder() throws Exception
    {
        if ( this.documentBuilder == null )
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            
            dbf.setNamespaceAware(true);
            
            this.documentBuilder = dbf.newDocumentBuilder(); 
        }
        
        return this.documentBuilder;
    }

    @Override
    public void runCheck(InputStream input, CheckResult cr) {
        
        // Get the builder
        DocumentBuilder db;
        try {
            db = this.getBuilder();
        } 
        catch (Exception e)
        {
            cr.setResultText("(parser setup failure)");
            cr.setOutcome(Outcome.CHECK_FAILURE);
            return; 
        }
        
        // Get the validator
        Validator validator;
        try {
            validator = this.getValidator();
        } 
        catch (Exception e)
        {
            cr.setResultText("(validator setup error)");
            cr.setOutcome(Outcome.CHECK_FAILURE);
            return;
        }
        
        // Get the document
        Document doc; 
        try
        {
            doc = db.parse(input);
        }
        catch (Exception e)
        {
            cr.setResultText("(document not well-formed)");
            cr.setOutcome(Outcome.FAIL);
            return;
        }
        
        // Set up the DOMSource
        DOMSource source = new DOMSource(doc); 
        
        // Attempt to validate and return PASS if so
        try
        {
            validator.validate(source);
            
            cr.setResultText("validates");
            cr.setOutcome(Outcome.PASS);
        }
        catch ( SAXException e )
        {
            cr.setResultText("does not validate");
            cr.setOutcome(Outcome.FAIL);
        }
        catch ( IOException e )
        {
            cr.setResultText("(I/O error)");
            cr.setOutcome(Outcome.CHECK_FAILURE);
        }
        
    }
    
    @Override
    public String getDescription()
    {
        StringBuilder sb = new StringBuilder(); 
        sb.append("validates against "); 
        sb.append(this.stringParameters.get("schemaURL")); 
        return sb.toString(); 
    }
    
}
