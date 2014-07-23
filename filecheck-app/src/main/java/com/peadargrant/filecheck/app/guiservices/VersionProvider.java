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
package com.peadargrant.filecheck.app.guiservices;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Peadar Grant
 */
public class VersionProvider {
    
    private String lookupProperty(String propertyToFind)
    {
        String path = "/version.txt";
        InputStream stream = getClass().getResourceAsStream(path);
        if (stream == null) {
            return "UNKNOWN";
        }
        Properties props = new Properties();
        try {
            props.load(stream);
            stream.close();
            return (String) props.get(propertyToFind);
        } catch (IOException e) {
            return "UNKNOWN";
        }
    }
    
    public String getBuildVersion() {
        return this.lookupProperty("version");
    }
    
    public double getApiVersion() {
        String buildVersion = this.getBuildVersion();
        String components[] = buildVersion.split("-");
        String initial = components[0];
        double apiVersion = Double.parseDouble(initial);
        return apiVersion;
    }
    
    public String getBuildDate() {
        return this.lookupProperty("build.date");
    }
    
}
