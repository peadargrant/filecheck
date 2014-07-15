/*
 *  Copyright Peadar Grant.
 *  All rights reserved.
 */

package com.peadargrant.filecheck.guiservices;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Peadar Grant
 */
public class VersionProvider {
    
    public String getBuildVersion() {
        String path = "/version.txt";
        InputStream stream = getClass().getResourceAsStream(path);
        if (stream == null) {
            return "UNKNOWN";
        }
        Properties props = new Properties();
        try {
            props.load(stream);
            stream.close();
            return (String) props.get("version");
        } catch (IOException e) {
            return "UNKNOWN";
        }
    }
    
    public double getApiVersion() {
        String buildVersion = this.getBuildVersion();
        String components[] = buildVersion.split("-");
        String initial = components[0];
        double apiVersion = Double.parseDouble(initial);
        return apiVersion;
    }
    
}
