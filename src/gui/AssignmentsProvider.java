/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package gui;

import assignments.Assignments;
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
            this.schema = schemaFactory.newSchema( new URL("https://raw.github.com/peadargrant/assignments/master/assignments.xsd") );
        }
        
        return this.schema;
    }
    
    public Assignments defaultLibrary() throws Exception
    {
    
        JAXBContext jc = JAXBContext.newInstance("assignments");
        Unmarshaller u = jc.createUnmarshaller();
        
        u.setSchema(this.getSchema());
        u.setEventHandler( new AssignmentsValidationEventHandler() );
        
        return (Assignments) u.unmarshal( new URL("https://raw.github.com/peadargrant/assignments/master/assignments.xml") );
     
    }
    
}