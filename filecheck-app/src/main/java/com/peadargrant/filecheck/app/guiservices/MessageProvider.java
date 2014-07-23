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

import javax.swing.JOptionPane;

/**
 *
 * @author peadar
 */
public class MessageProvider {
    
    public static void showAbout()
    {
        VersionProvider vp = new VersionProvider(); 
        JOptionPane.showMessageDialog(null, "FileCheck\nVersion: "+vp.getBuildVersion()+"\nAPI version: "+vp.getApiVersion()+"\nCreated by Peadar Grant\nCopyright "+vp.getBuildDate()+"\nAll rights reserved", "About FileCheck", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showPreferences()
    {
        JOptionPane.showMessageDialog(null, "No user-configurable preferences!", "Preferences", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void showException(Exception e)
    {
        java.awt.Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, e.getMessage(), "Exception occurred", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void showMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }
    
    public static void showWarning(String title, String message)
    {
        java.awt.Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }
    
}
