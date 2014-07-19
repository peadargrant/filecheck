/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package com.peadargrant.filecheck.core.checks;

import com.peadargrant.filecheck.core.checker.CheckImplementation;
import com.peadargrant.filecheck.core.checker.CheckResult;
import com.peadargrant.filecheck.core.checker.Outcome;
import com.rexsl.w3c.ValidationResponse;
import com.rexsl.w3c.Validator;
import com.rexsl.w3c.ValidatorBuilder;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class HtmlValidates extends CheckImplementation {

    @Override
    public void runCheck(InputStream input, CheckResult cr) {
        
        // Turn input stream into string
        String content = new Scanner(input).useDelimiter("\\Z").next();
        
        // Validate using ReXSL
        ValidationResponse vr = null;
        try
        {
            ValidatorBuilder vb = new ValidatorBuilder();
            Validator html = vb.html();
            vr = html.validate(content);
            cr.setDetails(vr.toString());
            // Return result
            if ( vr.valid() )
            {
                cr.setResultText("valid HTML");
                cr.setOutcome(Outcome.PASS);
            }
            else
            {
                cr.setResultText("invalid HTML");
                cr.setOutcome(Outcome.FAIL);
            }
        }
        catch (Exception e )
        {
            cr.setResultText("(error occurred)");
            cr.setOutcome(Outcome.CHECK_FAILURE);
            return;
        }
            
    }

    @Override
    public String getDescription() {
        return "check HTML validity";
    }
    
}
