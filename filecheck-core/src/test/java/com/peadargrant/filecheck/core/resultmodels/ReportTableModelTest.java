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
package com.peadargrant.filecheck.core.resultmodels;

import com.peadargrant.filecheck.core.checker.CheckResult;
import com.peadargrant.filecheck.core.checker.Outcome;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author peadar
 */
@RunWith(MockitoJUnitRunner.class)
public class ReportTableModelTest {
    
    CheckResult passResult = null;
    CheckResult failResult = null;
    CheckResult checkFailureResult = null;
    ReportTableModel instance = null;
    @Mock SummaryTableModel summaryTableModel;
    
    @Before
    public void setUp() {
        passResult = new CheckResult();
        passResult.setOutcome(Outcome.PASS);
        passResult.setPath("/path");
        passResult.setDescription("sample test");
        passResult.setResultText("sample passing output");
        passResult.setResultText("sample passing details"); 
        
        failResult = new CheckResult();
        failResult.setOutcome(Outcome.FAIL);
        failResult.setPath("/path");
        failResult.setDescription("sample test");
        failResult.setResultText("sample failing output");
        failResult.setResultText("sample failing details");
        
        checkFailureResult = new CheckResult();
        checkFailureResult.setOutcome(Outcome.CHECK_FAILURE);
        checkFailureResult.setPath("/path");
        checkFailureResult.setDescription("sample test");
        checkFailureResult.setResultText("sample check failure output");
        checkFailureResult.setResultText("sample check failure details");
        
        instance = new ReportTableModel(summaryTableModel); 
    }
    
    @After
    public void tearDown() {
        passResult = null;
        failResult = null;
        checkFailureResult = null;
        
        instance = null; 
    }

    @Test
    public void postsToSummaryOnPassResult() {
        instance.post(passResult);
        Mockito.verify(summaryTableModel).increment(Outcome.PASS);
    }
    
    @Test
    public void clearsSummaryOnClear() {
        instance.clear();
        Mockito.verify(summaryTableModel).clear();
    }
    
    
}
