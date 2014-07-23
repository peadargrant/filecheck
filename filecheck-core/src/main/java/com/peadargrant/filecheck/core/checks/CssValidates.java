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
package com.peadargrant.filecheck.core.checks;

import com.peadargrant.filecheck.core.checker.CheckImplementation;
import com.peadargrant.filecheck.core.checker.CheckResult;
import com.peadargrant.filecheck.core.checker.Outcome;
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
