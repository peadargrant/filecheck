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
package com.peadargrant.filecheck.web.reports;

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
