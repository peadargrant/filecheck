/*
 * Copyright (C) 2014 peadar
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

import com.peadargrant.filecheck.core.checker.CheckResult;
import com.peadargrant.filecheck.core.checker.Outcome;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author peadar
 */
public class CssValidatesTest {
    
    public static final String VALID_CSS = "body { font-family: sans-serif; }";
    public static final String INVALID_CSS = "nothing at all here.!!!!";
    
    Fake instance = null;
    CheckResult result = null;
    
    @Before
    public void setUp() throws IOException {
        instance = new Fake(); 
        result = Mockito.mock(CheckResult.class);
    }
    
    @After
    public void tearDown() {
        instance = null;
        result = null;
    }
    
    @Test
    public void validCssShouldPass() throws IOException {
        InputStream input = IOUtils.toInputStream(VALID_CSS, "UTF-8");
        instance.runCheck(input, result);
        Mockito.verify(result).setOutcome(Outcome.PASS);
    }
    
    @Test
    @Ignore("need to get canonical invalid CSS example")
    public void invalidCssShouldFail() throws IOException {
        InputStream input = IOUtils.toInputStream(INVALID_CSS, "UTF-8");
        instance.runCheck(input, result);
        Mockito.verify(result).setOutcome(Outcome.FAIL);
    }
    
}
