/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package com.peadargrant.sw.filecheck.guiservices;

import java.awt.Desktop;
import java.net.URL;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class Website {
    
    private static void visitWebsite(URL url) throws Exception
    {
        Desktop.getDesktop().browse(url.toURI());
    }
    
    public static void visitDeveloperWebsite() throws Exception
    {
        visitWebsite(new URL("http://peadargrant.com/"));
    }
    
}
