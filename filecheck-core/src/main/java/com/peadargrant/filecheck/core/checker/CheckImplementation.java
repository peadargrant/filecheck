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
package com.peadargrant.filecheck.core.checker;

import com.peadargrant.filecheck.core.assignments.Parameter;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public abstract class CheckImplementation {
    
    protected HashMap<String,String> stringParameters;
    
    /**
     * Applies parameters specified in XML file to HashMap
     * @param parameters 
     */
    public void applyParameters(List<Parameter> parameters)
    {
        if ( null == this.stringParameters )
        {
            this.stringParameters = new HashMap<>(); 
        }
        
        for ( Parameter p : parameters )
        {
            stringParameters.put(p.getName(), p.getValue());
        }
    }
    
    /**
     * Runs the check on the InputStream given
     * @param input
     * @return 
     */
    public abstract void runCheck(InputStream input, CheckResult cr);

}
