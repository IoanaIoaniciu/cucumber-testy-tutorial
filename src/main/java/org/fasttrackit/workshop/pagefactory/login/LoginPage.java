package org.fasttrackit.workshop.pagefactory.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(how = How.ID, using = "loginButton")
    private WebElement loginButton;

    @FindBy(how = How.ID, using = "email")
    private WebElement email;

    @FindBy(how = How.ID, using = "password")
    private WebElement pass;

   @FindBy(how = How.CLASS_NAME, using = "error-msg")
    private  WebElement error;

    public void clickOnLoginButton() {
        loginButton.click();
    }


    public void enterCredentials(String emailValue, String passValue) {;
        email.sendKeys(emailValue);
        pass.sendKeys(passValue);
    }

    public void errorMessageShouldBePresent( String expectedMessage) {
        assertThat(error.getText(), is(expectedMessage));
    }
}
