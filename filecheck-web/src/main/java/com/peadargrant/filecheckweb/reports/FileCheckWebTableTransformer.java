/*
 *  Copyright Peadar Grant.
 *  All rights reserved.
 */

package com.peadargrant.filecheckweb.reports;

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
