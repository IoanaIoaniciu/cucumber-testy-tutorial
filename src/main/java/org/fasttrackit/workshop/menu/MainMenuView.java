package org.fasttrackit.workshop.menu;

import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.link.WebLink;
import com.sdl.selenium.web.utils.Utils;

/**
 * Created by Ioana on 7/4/2015.
 */
public class MainMenuView {
    public static WebLink logout = new WebLink().setText("Logout");
    public Button preferencesButton = new Button().setText("Preferences");

    public static void logout(){
        logout.assertClick();
    }
}
