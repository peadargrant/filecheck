
package gui;

import com.apple.eawt.QuitResponse;
import com.apple.eawt.QuitHandler;
import com.apple.eawt.AppEvent;

public class MyQuitHandler implements QuitHandler {

  @Override
  public void handleQuitRequestWith(AppEvent.QuitEvent e, QuitResponse r)
  {
    System.exit(0);
  }
    
}
