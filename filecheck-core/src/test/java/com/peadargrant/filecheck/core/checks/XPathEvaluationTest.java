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
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author peadar
 */
public class XPathEvaluationTest {
    
    CheckImplementation instance = null;
    CheckResult result = null;
    List<Parameter> parameters = null;
    
    @Before
    public void setUp() throws IOException {
        instance = new XPathEvaluation(); 
        result = Mockito.mock(CheckResult.class);
        parameters = new ArrayList<>();
    }
    
    @After
    public void tearDown() {
        instance = null;
        result = null;
    }
    
    @Test
    @Ignore("problem with XPath instantiation during test only.")
    public void validXpathShouldPass() {
        String expression = "/root/child/text()";
        String expectedOutput = "Contents of child";
        Parameter parameter = new Parameter(); 
        parameter.setName("expression");
        parameter.setValue(expression);
        parameters.add(parameter);
        instance.applyParameters(parameters);
        InputStream input = this.getClass().getResourceAsStream("XPathEvaluationTest_input.xml"); 
        instance.runCheck(input, result);
        Mockito.verify(result).setOutcome(Outcome.PASS);
    }
    
    @Test
    @Ignore("problem with XPath instantiation during test only.")
    public void validXpathShouldGiveCorrectTextOutput() {
        String expression = "/root/child/text()";
        String expectedOutput = "Contents of child";
        Parameter parameter = new Parameter(); 
        parameter.setName("expression");
        parameter.setValue(expression);
        parameters.add(parameter);
        instance.applyParameters(parameters);
        InputStream input = this.getClass().getResourceAsStream("XPathEvaluationTest_input.xml"); 
        instance.runCheck(input, result);
        Mockito.verify(result).setResultText(expectedOutput);
    }
    
    @Test
    @Ignore("problem with XPath instantiation during test only.")
    public void validXpathShouldEchoExpression() {
        String expression = "/root/child/text()";
        String expectedOutput = "Contents of child";
        Parameter parameter = new Parameter(); 
        parameter.setName("expression");
        parameter.setValue(expression);
        parameters.add(parameter);
        instance.applyParameters(parameters);
        InputStream input = this.getClass().getResourceAsStream("XPathEvaluationTest_input.xml"); 
        instance.runCheck(input, result);
        Mockito.verify(result).setDetails(expression);
    }
}
