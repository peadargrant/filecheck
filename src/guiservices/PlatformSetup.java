/*
 *  Copyright Peadar Grant - All rights reserved.
 */
package guiservices;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class PlatformSetup {
    
    public static void detectAndSetupPlatform(String applicationName)
    {
        // Set up Mac integration
        if( System.getProperty("os.name").equals("Mac OS X") )
        {
            try{
                PlatformHandler h = (PlatformHandler) Class.forName("guiservices.PlatformHandlerMac").newInstance();
                h.setupApplication(applicationName);
            }
            catch ( Exception e )
            {
                e.printStackTrace();
                MessageProvider.showMessage("Running in degraded Mac mode.");
            }
        }
    }
    
}
