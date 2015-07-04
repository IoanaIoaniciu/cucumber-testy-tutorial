package org.fasttrackit.workshop.preferences;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Ioana on 7/4/2015.
 */
public class PreferencesWindow {

    private WebLocator window = new WebLocator().setId("preferences-win");

    private Button preferencesButton = new Button().setText("Preferences");
    private Button clickSaveButton = new Button(window).setText("Save");
    private Button closeButton = new Button(window).setText("Close");
    private TextField currentPassword = new TextField().setLabel("Current Password");
    private TextField newPassword = new TextField(window).setLabel("New Password");
    private TextField confirmNewPassword = new TextField(window).setLabel("Repeat Password");
    //private TextField currentPassword = new TextField().setElPath("//label[text()='Current Password']//following-sibling::*//input");

    private WebLocator statusMessageEl = new WebLocator(window).setClasses("status-msg");

    public static void main(String[] args) {

        PreferencesWindow preferencesWindow = new PreferencesWindow();

        System.out.println(preferencesWindow.window.getPath());
        System.out.println(preferencesWindow.statusMessageEl.getPath());
    }

    public void open() {
        preferencesButton.click();
        Utils.sleep(1000); // because of fading window
    }

    public void typeCurrentPassword(String validPassword) {
        currentPassword.setValue(validPassword);
        Utils.sleep(1000);
    }

    public void typeNewPassword(String password) {
        newPassword.setValue(password);
    }

    public void typeConfirmPassword(String password) {
        confirmNewPassword.setValue(password);
    }

    public void clickSaveNewPassword() {
        clickSaveButton.assertClick();
    }

    public void statusMessageShouldBePresent(String expectedMessage) {
        assertThat(statusMessageEl.getHtmlText(), is(expectedMessage));
    }

    public void close() {
        closeButton.assertClick();
        Utils.sleep(1000);
    }
}
