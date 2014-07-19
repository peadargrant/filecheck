/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package com.peadargrant.filecheck.app.checker;

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
    
    private Color clampedColour(Color color, int min, int max)
    {
        ArrayList<Integer> rgb = new ArrayList<>();
        
        rgb.add( color.getRed() );
        rgb.add( color.getGreen() );
        rgb.add( color.getBlue() );
        
        for ( int k = 0 ; k < rgb.size() ; k++ )
        {
            if ( rgb.get(k) < min )
            {
                rgb.set(k, min);
            }
            else if ( rgb.get(k) > max )
            {
                rgb.set(k, max);
            }
        }
        
        return new Color(rgb.get(0), rgb.get(1), rgb.get(2)); 
    }

    private Outcome(Color color) {
        
        this.saturatedColor = this.clampedColour(color, 0, 100);
        this.color = this.clampedColour(color, 150, 3000);
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
