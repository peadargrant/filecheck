/*
 * Copyright (C) 2017 Peadar Grant
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
import org.apache.poi.POIXMLProperties.ExtendedProperties;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author Peadar Grant
 */
public class DOCXPageCount extends CheckImplementation {

    private int minPages() {
        return new Integer(this.stringParameters.get("minPages"));
    }
    
    private int maxPages() {
        return new Integer(this.stringParameters.get("maxPages"));
    }
    
    @Override
    public void runCheck(InputStream input, CheckResult cr) {

        try {
            
            XWPFDocument document = new XWPFDocument(input);
            
            ExtendedProperties props = document.getProperties().getExtendedProperties();
            
            int nPages = props.getUnderlyingProperties().getPages();
            
            if ( ( nPages < minPages() ) || ( nPages > maxPages() )) {
                cr.setOutcome(Outcome.FAIL);
                cr.setResultText("page count " + nPages + " outside range " + minPages() + "-" + maxPages());
                return;
            }
            
            cr.setOutcome(Outcome.PASS);
            cr.setResultText("page count " + nPages + " within range " + minPages() + "-" + maxPages());
            
        } catch (Exception e) {
            cr.setResultText("(error occurred)");
            cr.setOutcome(Outcome.CHECK_FAILURE);
        }
        
        
        
    }
    
}
