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
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Peadar Grant
 */
public class Checksum extends CheckImplementation {

    @Override
    public void runCheck(InputStream input, CheckResult cr) {
        try {
            String sha = org.apache.commons.codec.digest.DigestUtils.sha1Hex(input);
            cr.setResultText(sha);
            cr.setOutcome(Outcome.PASS);
        } catch ( IOException e )
        {
            cr.setResultText("(i/o exception)");
            cr.setOutcome(Outcome.CHECK_FAILURE);
        }

    }

    @Override
    public String getDescription() {
        return "file checksum";
    }
    
}
