/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package checker;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public enum Outcome {
    
    PASS( Color.GREEN ),
    FAIL( Color.RED ),
    CHECK_FAILURE( Color.YELLOW),
    SKIPPED( Color.YELLOW ),
    ADVISORY( Color.YELLOW );
    
    private Color color;
    private Color saturatedColor;

    private Outcome(Color color) {
        
        this.saturatedColor = color;
        
        ArrayList<Integer> rgb = new ArrayList<>();
        
        int clamp = 150;
        rgb.add( color.getRed() );
        rgb.add( color.getGreen() );
        rgb.add( color.getBlue() );
        
        for ( int k = 0 ; k < rgb.size() ; k++ )
        {
            if ( rgb.get(k) < clamp )
            {
                rgb.set(k, clamp);
            }
        }

        this.color = new Color(rgb.get(0), rgb.get(1), rgb.get(2));
    }
    
    public Color getColor()
    {
        return this.color; 
    }
    
    public Color getSaturatedColor()
    {
        return this.saturatedColor;
    }
    
}
