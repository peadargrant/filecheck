/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package checker;

import java.awt.Color;

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

    private Outcome(Color color) {
                this.color = color;
        }
    
    public Color getColor()
    {
        return this.color; 
    }
    
}
