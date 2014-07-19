/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package com.peadargrant.filecheck.app.guiservices;

import java.io.StringWriter;
import javax.swing.table.AbstractTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class HtmlTableRenderer {
    
    private DocumentBuilder db;
    
    public HtmlTableRenderer() throws Exception
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        this.db = dbf.newDocumentBuilder();
    }
    
    public String renderTableAsHtml(AbstractTableModel atm)
    {
        Document doc = db.newDocument();
        
        Element table = doc.createElement("table");
        doc.appendChild(table);
        
        Element headerrow = doc.createElement("tr"); 
        table.appendChild(headerrow);
        
        // Column headers
        for ( int k = 0 ; k < atm.getColumnCount(); k++ ) 
        {
            Element td = doc.createElement("th"); 
            
            td.setTextContent( atm.getColumnName(k) );
            
            headerrow.appendChild(td); 
        }
        
        // Rows
        for ( int m = 0 ; m < atm.getRowCount() ; m++ )
        {
            Element row = doc.createElement("tr"); 
            
            for ( int k = 0 ; k < atm.getColumnCount() ; k++ )
            {
                Element td = doc.createElement("td"); 
                
                td.setTextContent( atm.getValueAt(m, k).toString() );
                
                row.appendChild(td); 
            }
            
            table.appendChild(row);
        }
        
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            StreamResult result = new StreamResult(new StringWriter());
            DOMSource source = new DOMSource(doc);
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.transform(source, result);
            return result.getWriter().toString();
        } catch(TransformerException ex) {
              ex.printStackTrace();
            return null;
        }
        
    }
    
    public void copyTableToClipboard(AbstractTableModel atm)
    {
        String tableAsHtml = this.renderTableAsHtml(atm);
        
        try {
            ClipboardUtils.copyHtmlToClipboard(tableAsHtml);
        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
    }
    
}
