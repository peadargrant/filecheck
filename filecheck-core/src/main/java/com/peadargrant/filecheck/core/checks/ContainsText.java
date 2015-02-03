/*
 * Copyright (C) 2015 Peadar Grant
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
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Peadar Grant
 */
public class ContainsText extends CheckImplementation {

    @Override
    public void runCheck(InputStream input, CheckResult cr) {
        
        String target = this.stringParameters.get("string");
        String shouldInvert = this.stringParameters.get("invert"); 
	boolean invert = false;
	if ( shouldInvert!=null && shouldInvert.equals("true") ) {
	    invert = true;
	}
	    
	
        // from SO:
        // http://stackoverflow.com/questions/15577688/search-a-file-for-a-string-and-return-that-string-if-found
        final Scanner scanner = new Scanner(input);
        boolean found = false;
        int line = 0;
        while (scanner.hasNextLine()) {
            final String lineFromFile = scanner.nextLine();
            line++;
            if (lineFromFile.contains( target )) {
                found = true;
                break;
            }
        }
        
        String description = "contains text: ";
        if ( invert ) {
            description = "doesn't contain text: "; 
        }
        cr.setDescription(description + target );
        
        if ( found ) {
            cr.setResultText("found on line " + line);
            cr.setOutcome( invert ? Outcome.FAIL : Outcome.PASS );
        } 
        else {
            cr.setResultText("text not found");
            cr.setOutcome( invert ? Outcome.PASS : Outcome.FAIL ); 
        }

    }

}
