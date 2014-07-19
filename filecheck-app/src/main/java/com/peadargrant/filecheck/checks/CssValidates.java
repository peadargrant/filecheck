/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package com.peadargrant.filecheck.checks;

import com.peadargrant.filecheck.checker.CheckImplementation;
import com.peadargrant.filecheck.checker.CheckResult;
import com.peadargrant.filecheck.checker.Outcome;
import com.rexsl.w3c.ValidationResponse;
import com.rexsl.w3c.Validator;
import com.rexsl.w3c.ValidatorBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class CssValidates extends CheckImplementation {

    @Override
    public void runCheck(InputStream input, CheckResult cr) {
        
        // Turn input stream into string
        String content = new Scanner(input).useDelimiter("\\Z").next();
        
        // Validate using ReXSL
        ValidationResponse vr = null;
        try
        {
            ValidatorBuilder vb = new ValidatorBuilder();
            Validator css = vb.css();
            vr = css.validate(content);
            cr.setDetails(vr.toString());
            // Return result
            if ( vr.valid() )
            {
                cr.setResultText("valid CSS");
                cr.setOutcome(Outcome.PASS);
            }
            else
            {
                cr.setResultText("invalid CSS");
                cr.setOutcome(Outcome.FAIL);
            }
        }
        catch (IOException e )
        {
            cr.setResultText("(i/o error occurred)");
            cr.setOutcome(Outcome.CHECK_FAILURE);   
        }
            
    }

    @Override
    public String getDescription() {
        return "check CSS validity";
    }
    
}
