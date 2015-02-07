/*
 * Copyright (C) 2015 Peadar Grant
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
package com.peadargrant.filecheck.core.checker;

import com.peadargrant.filecheck.core.assignments.Check;
import java.util.HashMap;

/**
 *
 * @author Peadar Grant
 */
public class CheckProvider {
    
    private final HashMap<Check, CheckImplementation> checkImplementations;
    
    public CheckProvider() {
        this.checkImplementations = new HashMap<>();
    }
    
    /**
     * Return the implementation of a given check, and instantiate if needed.
     *
     * @param check
     * @return
     * @throws Exception
     */
    public CheckImplementation getImplementationForCheck(Check check) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (!checkImplementations.containsKey(check)) {
            CheckImplementation checkImplementation = (CheckImplementation) Class.forName("com.peadargrant.filecheck.core.checks." + check.getProcedure()).newInstance();
            checkImplementation.applyParameters(check.getParameter());
            checkImplementations.put(check, checkImplementation);
        }

        return checkImplementations.get(check);
    }
    
}
