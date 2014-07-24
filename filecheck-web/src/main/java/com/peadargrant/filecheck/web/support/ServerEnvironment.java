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

package com.peadargrant.filecheck.web.support;

import javax.naming.Context;
import javax.naming.InitialContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author Peadar Grant
 */
@Component
public class ServerEnvironment {
    
    public String getPropertyAsString(String propertyName) throws Exception
    {
        Context env = (Context) new InitialContext().lookup("java:comp/env");
        
        String property = (String) env.lookup(propertyName);
        
        return property;
    }
    
}
