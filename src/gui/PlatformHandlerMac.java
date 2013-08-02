
package gui;

import com.apple.eawt.Application;

/**
 *
 * @author peadar
 */
public class PlatformHandlerMac implements PlatformHandler {
    
    @Override
    public void setupApplication()
    {
        Application a = Application.getApplication();
        a.setAboutHandler(new MyAboutHandler());
        a.setQuitHandler(new MyQuitHandler());
        a.setPreferencesHandler(new MyPreferencesHandler());
    }
    
}
