/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package com.peadargrant.filecheck.core.checks;

import com.peadargrant.filecheck.core.checker.CheckImplementation;
import com.peadargrant.filecheck.core.checker.CheckResult;
import com.peadargrant.filecheck.core.checker.Outcome;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class TextEvaluation extends CheckImplementation {

    private int requestedLine()
    {
        return new Integer(this.stringParameters.get("line")).intValue();
    }
    
    @Override
    public void runCheck(InputStream inputStream, CheckResult cr) {
        
        Scanner scanner = new Scanner( inputStream ).useDelimiter("\n");
        
        String outputLine="";
        int k = 0; 
        while(scanner.hasNext())
        {
            k = k + 1;
            outputLine = scanner.next();
            if ( k == this.requestedLine() )
            {
                cr.setResultText(outputLine);
                cr.setOutcome(Outcome.PASS);
                return;
            }
        }
        
        cr.setResultText("(end reached)");
        cr.setOutcome(Outcome.FAIL);
               
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder(); 
        sb.append("Line ");
        sb.append( this.requestedLine() ); 
        return sb.toString();
    }
    
}
