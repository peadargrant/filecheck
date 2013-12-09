/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peadargrant.sw.filecheck.guiservices;

import javax.swing.JOptionPane;

/**
 *
 * @author peadar
 */
public class MessageProvider {
    
    public static void showAbout()
    {
        JOptionPane.showMessageDialog(null, "FileCheck\nCreated by Peadar Grant\nCopyright 2013\nAll rights reserved", "About FileCheck", JOptionPane.INFORMATION_MESSAGE);
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
