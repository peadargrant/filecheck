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
