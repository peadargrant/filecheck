/*
 *  Copyright Peadar Grant.
 *  All rights reserved.
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
