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
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class AssignmentsProvider {
    
    private Schema schema; 
    
    private Schema getSchema() throws Exception
    {
        if ( null == this.schema )
        {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            this.schema = schemaFactory.newSchema( this.getClass().getResource("/jaxb/assignments-binding/assignments.xsd") );
        }
        
        return this.schema;
    }
    
    public Assignments customLibrary(String location) throws Exception
    {
        JAXBContext jc = JAXBContext.newInstance("com.peadargrant.filecheck.core.assignments");
        Unmarshaller u = jc.createUnmarshaller();
        
        u.setSchema(this.getSchema());
        u.setEventHandler( new AssignmentsValidationEventHandler() );
        
        Assignments assignments = (Assignments) u.unmarshal( new URL(location) );
        
        return assignments;
    }
    
}
