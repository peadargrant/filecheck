/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package com.peadargrant.filecheck.gui;

import com.peadargrant.filecheck.assignments.Assignments;
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
        JAXBContext jc = JAXBContext.newInstance("com.peadargrant.filecheck.assignments");
        Unmarshaller u = jc.createUnmarshaller();
        
        u.setSchema(this.getSchema());
        u.setEventHandler( new AssignmentsValidationEventHandler() );
        
        return (Assignments) u.unmarshal( new URL(location) );
    }
    
    public Assignments defaultLibrary() throws Exception
    {   
        return this.customLibrary("https://raw.github.com/peadargrant/assignments/master/assignments.xml");
    }
    
}
