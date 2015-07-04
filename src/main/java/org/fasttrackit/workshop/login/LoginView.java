package org.fasttrackit.workshop.login;

import com.sdl.selenium.web.WebLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginView {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginView.class);

    private WebLocator loginButton = new WebLocator().setId("loginButton");

    private WebLocator email = new WebLocator().setId("email");

    private WebLocator pass = new WebLocator().setId("password");

    private  WebLocator error = new WebLocator().setClasses("error-msg");

    public void clickOnLoginButton() {
        loginButton.click();
    }


    public void enterCredentials(String emailValue, String passValue) {
        System.out.println("enter email" + " " + emailValue);
        email.sendKeys(emailValue);
        System.out.println("enter password" + " " + passValue);
        pass.sendKeys(passValue);
    }

    public void errorMessageShouldBePresent( String expectedMessage) {
        assertThat(error.getHtmlText(), is(expectedMessage));
    }
}
