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

import com.peadargrant.filecheck.core.checker.Outcome;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Peadar Grant
 */
public class FileCheckWebTableTransformer extends WebTableTransformer {
    
    @Override
    public List getTableContents(AbstractTableModel model) {
        
        List<List> rows = super.getTableContents(model);
        
        List<Map<String,Object>> output = new ArrayList<>();
        
        for ( List row : rows )
        {
            Map<String,Object> rowMap = new HashMap<>();
            
            rowMap.put("contents", row);
            
            for ( Object o : row )
            {
                if ( Outcome.class.isInstance(o) ) {
                    
                    Color colorForOutcome = ((Outcome) o).getColor();
                    String colorString = rgbStringForColor(colorForOutcome);
                    rowMap.put("color", colorString);
                }
                
            }
            
            output.add(rowMap);
        }
        
        return output;
    }
    
    private String rgbStringForColor(Color color)
    {
        return "rgb("+color.getRed()+", "+color.getGreen()+", "+color.getBlue()+")";
    }
    
}
