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

import com.peadargrant.filecheck.core.assignments.Parameter;
import com.peadargrant.filecheck.core.checker.CheckImplementation;
import com.peadargrant.filecheck.core.checker.CheckResult;
import com.peadargrant.filecheck.core.checker.Outcome;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author peadar
 */
public class PDFPageCountTest {
    
    CheckImplementation instance = null;
    CheckResult result = null;
    
    @Before
    public void setUp() throws IOException {
        instance = new PDFPageCount(); 
        result = Mockito.mock(CheckResult.class);
    }
    
    @After
    public void tearDown() {
        instance = null;
        result = null;
    }
    
    @Test
    public void pageWithinRangeShouldPass() throws IOException {
        InputStream input = this.getClass().getResourceAsStream("PDFPageCountTest_sample1.pdf");
        ArrayList<Parameter> parameters = new ArrayList<>();
        Parameter p = new Parameter();
        p.setName("minPages");
        p.setValue("1");
        parameters.add(p);
        Parameter p2 = new Parameter();
        p2.setName("maxPages");
        p2.setValue("3");
        parameters.add(p2);
        instance.applyParameters(parameters);
        instance.runCheck(input, result);
        Mockito.verify(result).setOutcome(Outcome.PASS);
    }
    
    @Test
    public void pageLowerThanRangeShouldFail() throws IOException {
        InputStream input = this.getClass().getResourceAsStream("PDFPageCountTest_sample1.pdf");
        ArrayList<Parameter> parameters = new ArrayList<>();
        Parameter p = new Parameter();
        p.setName("minPages");
        p.setValue("10");
        parameters.add(p);
        Parameter p2 = new Parameter();
        p2.setName("maxPages");
        p2.setValue("30");
        parameters.add(p2);
        instance.applyParameters(parameters);
        instance.runCheck(input, result);
        Mockito.verify(result).setOutcome(Outcome.FAIL);
    }
    
    @Test
    public void pageHigherThanRangeShouldFail() throws IOException {
        InputStream input = this.getClass().getResourceAsStream("PDFPageCountTest_sample1.pdf");
        ArrayList<Parameter> parameters = new ArrayList<>();
        Parameter p = new Parameter();
        p.setName("minPages");
        p.setValue("1");
        parameters.add(p);
        Parameter p2 = new Parameter();
        p2.setName("maxPages");
        p2.setValue("1");
        parameters.add(p2);
        instance.applyParameters(parameters);
        instance.runCheck(input, result);
        Mockito.verify(result).setOutcome(Outcome.FAIL);
    }
}
