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

import com.peadargrant.filecheck.core.assignments.Parameter;
import com.peadargrant.filecheck.core.checker.CheckResult;
import com.peadargrant.filecheck.core.checker.Outcome;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author Peadar Grant
 */
public class TextEvaluationTest {
    
    private static final String SOURCE_TEXT_LINE_1 = "Fake test input line 1";
    private static final String SOURCE_TEXT_LINE_2 = "Fake test input line 2";
    private static final String SOURCE_TEXT = SOURCE_TEXT_LINE_1 + "\n" + SOURCE_TEXT_LINE_2 + "\n"; 
    
    TextEvaluation instance = null;
    InputStream input = null;
    CheckResult result = null;
    List<Parameter> parameters = null;
    
    @Before
    public void setUp() throws IOException {
        instance = new TextEvaluation(); 
        input = IOUtils.toInputStream(SOURCE_TEXT, "UTF-8");
        result = Mockito.mock(CheckResult.class);
        parameters = new ArrayList<>(); 
    }
    
    @After
    public void tearDown() {
        instance = null;
        input = null;
        result = null; 
        parameters = null; 
    }
    
    @Test
    public void correctlyReturnsSpecifiedLine() {
        Parameter parameter = new Parameter(); 
        parameter.setName("line");
        parameter.setValue("1");
        parameters.add(parameter);
        instance.applyParameters(parameters);
        instance.runCheck(input, result);
        Mockito.verify(result).setResultText(SOURCE_TEXT_LINE_1);
    }
    
    @Test
    public void passesIfLineFound() {
        Parameter parameter = new Parameter(); 
        parameter.setName("line");
        parameter.setValue("1");
        parameters.add(parameter);
        instance.applyParameters(parameters);
        instance.runCheck(input, result);
        Mockito.verify(result).setOutcome(Outcome.PASS);
    }
    
    @Test
    public void failsIfLineIsBeyondEndOfFile() {
        Parameter parameter = new Parameter(); 
        parameter.setName("line");
        parameter.setValue("100");
        parameters.add(parameter);
        instance.applyParameters(parameters);
        instance.runCheck(input, result);
        Mockito.verify(result).setOutcome(Outcome.FAIL);
    }
    
}
