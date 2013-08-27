
package guiservices;

import com.apple.eawt.Application;
import java.awt.Image;
import javax.swing.ImageIcon;

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
        
        Image img = new ImageIcon(this.getClass().getResource("FileCheckIcon.png")).getImage();  // your desired image  
        Application app = Application.getApplication();
        app.setDockIconImage(img);
    }
    
}
