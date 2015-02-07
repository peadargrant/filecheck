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

import com.peadargrant.filecheck.core.checker.FinalOutcome;
import com.peadargrant.filecheck.core.checker.Outcome;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author peadar
 */
public class SummaryTableModelTest {
    
    SummaryTableModel instance = null;
    
    @Before
    public void setUp() {
        instance = new SummaryTableModel();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void shouldBeEmptyIfNothingPosted() {
        assertEquals(0, instance.getRowCount());
    }
    
    @Test
    public void finalOutcomeShouldBeNullIfEmpty() {
        assertEquals(null, instance.getFinalOutcome());
    }
    
    @Test
    public void finalOutcomeShouldBePassIfOnlyPassInput() {
        instance.increment(Outcome.PASS);
        assertEquals(FinalOutcome.PASS, instance.getFinalOutcome());
    }
    
    @Test
    public void finalOutcomeShouldBeFailIfOnlyFailInput() {
        instance.increment(Outcome.FAIL);
        assertEquals(FinalOutcome.FAIL, instance.getFinalOutcome());
    }
    
    @Test
    public void finalOutcomeShouldBeFailIfAnyFailInput() {
        instance.increment(Outcome.PASS);
        instance.increment(Outcome.FAIL);
        assertEquals(FinalOutcome.FAIL, instance.getFinalOutcome());
    }
    
    @Test
    public void finalOutcomeShouldBeNullIfCleared() {
        instance.increment(Outcome.PASS);
        instance.clear();
        assertEquals(null, instance.getFinalOutcome());
    }
    
}
