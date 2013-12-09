
package com.peadargrant.sw.filecheck.guiservices;

import com.apple.eawt.AppEvent.PreferencesEvent;
import com.apple.eawt.PreferencesHandler;
import javax.swing.JOptionPane;

public class MyPreferencesHandler implements PreferencesHandler {
    
    @Override
    public void handlePreferences(PreferencesEvent e)
    {
        MessageProvider.showPreferences();
    }
    
}
