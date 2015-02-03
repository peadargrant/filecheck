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
package com.peadargrant.filecheck.core.provider;

import com.peadargrant.filecheck.core.assignments.Assignments;
import java.net.URL;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class AssignmentsProvider {
    
    private Schema schema; 
    
    public AssignmentsProvider() throws Exception {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            schema = schemaFactory.newSchema( this.getClass().getResource("/jaxb/assignments-binding/assignments.xsd") );
    }
    
    public Assignments customLibrary(String location) throws Exception
    {
        JAXBContext jc = JAXBContext.newInstance("com.peadargrant.filecheck.core.assignments");
        Unmarshaller u = jc.createUnmarshaller();
        
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setXIncludeAware(true);
        spf.setNamespaceAware(true);
        
        XMLReader xr = spf.newSAXParser().getXMLReader();
        SAXSource source = new SAXSource(xr, new InputSource(location));
        
        u.setSchema(schema);
        u.setEventHandler( new AssignmentsValidationEventHandler() );
        
        Assignments assignments = (Assignments) u.unmarshal( source );
        
        return assignments;
    }
    
}
