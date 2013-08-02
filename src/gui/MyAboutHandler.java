package gui;

import com.apple.eawt.AboutHandler;
import com.apple.eawt.AppEvent.AboutEvent;

public class MyAboutHandler implements AboutHandler
{

  @Override
  public void handleAbout(AboutEvent e)
  {
        MessageProvider.showAbout();
  }

}