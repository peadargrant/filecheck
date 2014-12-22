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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class XmlWellFormedTest {
    
    CheckImplementation instance = null;
    CheckResult result = null;
    
    @Before
    public void setUp() throws IOException {
        instance = new XmlWellFormed(); 
        result = Mockito.mock(CheckResult.class);
    }
    
    @After
    public void tearDown() {
        instance = null;
        result = null;
    }
    
    @Test
    public void wellFormedXmlShouldPass() throws IOException {
        InputStream input = this.getClass().getResourceAsStream("XmlWellFormedTest_pass.xml");
        instance.runCheck(input, result);
        Mockito.verify(result).setOutcome(Outcome.PASS);
    }
    
    @Test
    public void nonWellFormedXmlShouldFail() throws IOException {
        InputStream input = this.getClass().getResourceAsStream("XmlWellFormedTest_fail.xml");
        instance.runCheck(input, result);
        Mockito.verify(result).setOutcome(Outcome.FAIL);
    }
    
    
}
