/*
 *  Copyright Peadar Grant.
 *  All rights reserved.
 */

package com.peadargrant.filecheckweb.reports;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.springframework.web.util.HtmlUtils;

/**
 *
 * @author Peadar Grant
 */
public class WebTableTransformer {
    
    public List<String> getColumnHeaders(AbstractTableModel model)
    {
        List<String> columnHeaders = new ArrayList<>();
        
        int numberOfColumns = model.getColumnCount();
        
        for ( int k = 0 ; k < numberOfColumns ; k++ )
        {
            String heading = model.getColumnName(k);
            columnHeaders.add( heading );
        }
        
        return columnHeaders;
    }
    
    public List getTableContents(AbstractTableModel model)
    {
        int nRows = model.getRowCount();
        int nCols = model.getColumnCount();
        
        List<List> rows = new ArrayList<>();
        for ( int iRow = 0 ; iRow < nRows ; iRow++ )
        {
            List<Object> row = new ArrayList<>();
            
            for ( int iCol = 0 ; iCol < nCols ; iCol++ )
            {
                Object output = model.getValueAt(iRow, iCol);
                if ( String.class.isInstance(output) )
                {
                    output = HtmlUtils.htmlEscape((String) output);
                }
                row.add( output );
            }
            
            rows.add(row);
        }
        
        return rows;
    }
    
}
