package my.sikuli.example;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

import org.sikuli.basics.Debug;
import org.sikuli.basics.Settings;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Pattern;

public class MySikuliTest {

    public static void main(String[] args) throws FindFailed {
        String browser = "Safari";
        Debug.user("[STARTING] running test with %s", browser);
        Debug.on(0);
        Settings.ActionLogs = false;
        Settings.InfoLogs = false;
        
        ImagePath.add("my.sikuli.example.MySikuliTest/images.sikuli");
        Screen screen = new Screen();
        String image1 = "pompei";
        Match pompei = startBrowserOpenLinkWaitForImage(browser, "http://currentlabel.co.uk/flexuscalculus/", image1, 20);

        // set all fields in the row to 0
        int clickAt = 70;
        while(clickAt < 500) {
            screen.click(pompei.offset(clickAt,0));
            clearField(screen);
            screen.type("0");
            clickAt += 100;
        }
        // deselect last field
        screen.click(pompei.offset(clickAt,0));

        // check that all fields are set to 0
        if (null == screen.exists(new Pattern("pompeiRowOfZeros").exact())) {
          Debug.user("[ERROR] did not work");
          System.exit(1);
        }
        
        Debug.user("[ENDING] should have worked");
    }

    private static void clearField(Screen screen) {
        screen.type("a", Key.CMD);
        screen.type(Key.BACKSPACE);
    }
    
    private static Match startBrowserOpenLinkWaitForImage(
            String browser, String link, String image, int waitTime) throws FindFailed {
      Screen screen = new Screen();
      App ff = new App(browser);
      ff.focus();
      if (null == screen.exists(image)) {
          while (null == ff.window()) {
            screen.wait(1f);
          }
          screen.type("l", Key.CMD);
          screen.wait(1f);
          screen.paste(link);
          screen.type(Key.ENTER);
          screen.wait(image, waitTime);
      }
      return screen.getLastMatch();
    }

}
