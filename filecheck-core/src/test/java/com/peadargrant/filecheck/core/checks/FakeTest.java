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

import com.peadargrant.filecheck.core.checker.CheckImplementation;
import com.peadargrant.filecheck.core.checker.CheckResult;
import com.peadargrant.filecheck.core.checker.Outcome;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author peadar
 */
public class FakeTest {
    
    private static final String SOURCE_TEXT = "Fake test input line 1\nFake test input line 2.\n";
    
    CheckImplementation instance = null;
    InputStream input = null;
    CheckResult result = null;
    
    @Before
    public void setUp() throws IOException {
        instance = new Fake(); 
        input = IOUtils.toInputStream(SOURCE_TEXT, "UTF-8");
        result = Mockito.mock(CheckResult.class);
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void fakeCheckShouldAlwaysPass() {
        instance.runCheck(input, result);
        Mockito.verify(result).setOutcome(Outcome.PASS);
    }
    
}
