/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package checks;

import checker.CheckImplementation;
import checker.CheckResult;
import checker.Outcome;
import com.rexsl.w3c.ValidationResponse;
import com.rexsl.w3c.Validator;
import com.rexsl.w3c.ValidatorBuilder;
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
        }
        catch (Exception e )
        {
            cr.setResultText("(error occurred)");
            cr.setOutcome(Outcome.CHECK_FAILURE);
            return;
        }
           
        // Return result
        cr.setDetails(vr.toString());
        if (  vr.valid() )
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

    @Override
    public String getDescription() {
        return "check CSS validity";
    }
    
}
