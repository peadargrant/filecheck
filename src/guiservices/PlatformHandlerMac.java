
package guiservices;

import com.apple.eawt.Application;

/**
 *
 * @author peadar
 */
public class PlatformHandlerMac implements PlatformHandler {
    
    @Override
    public void setupApplication(String applicationName)
    {
        Application a = Application.getApplication();
        
        a.setAboutHandler(new SimpleAboutHandler());
        
        a.setQuitHandler(new MyQuitHandler());
        
        a.setPreferencesHandler(new MyPreferencesHandler());
    }
    
}
