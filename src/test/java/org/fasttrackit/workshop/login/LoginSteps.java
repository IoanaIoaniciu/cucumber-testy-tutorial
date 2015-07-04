package org.fasttrackit.workshop.login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);
    public static final String VALID_EMAIL = "em@fast.com";
    public static String VALID_PASSWORD = "eu.pass";

    private LoginView loginPage = new LoginView(); // practic loginPage e un obiect de tip LoginView, o puteam denumi si loginView :D

    @Given("^I access the login page$")
    public void I_access_the_login_page() throws Throwable {
        driver.get("https://dl.dropboxusercontent.com/u/16174618/FastTrackIT/app-demo/login.html");
    }


    @Given("^I insert valid credentials$")
    public void I_insert_valid_credentials() throws Throwable {
        I_enter_credentials("eu@fast.com", "eu.pass");

    }



    @When("^I click login button$")
    public void I_click_login_button() throws Throwable {
        loginPage.clickOnLoginButton();

    }


    @Then("^I check if user was logged in$")
    public void I_check_if_user_was_logged_in() throws Throwable {
        //WebElement logout = driver.findElement(By.linkText("Logout"));
        //boolean successLoggedIn = logout.isDisplayed();
        //assertThat("Could not find logout button", successLoggedIn, is(true));
        boolean successLoggedIn = false;
        try{
            WebElement logout = driver.findElement(By.linkText("Logout"));
            successLoggedIn = logout.isDisplayed();
        } catch (Exception e){}
        assertThat("Could not find logout button", successLoggedIn, is(true));
    }

    @Given("^I insert invalid credentials$")
    public void I_insert_invalid_credentials() throws Throwable {
        I_enter_credentials(VALID_EMAIL, VALID_PASSWORD);
    }

    @Then("^I expect invalid credential message$")
    public void I_expect_invalid_credential_message(){
       loginPage.errorMessageShouldBePresent("Invalid user or password!");
    }


    @Given("^I open this url \"([^\"]*)\"$")
    public void I_open_this_url(String url) throws Throwable {
        driver.get(url);
    }

    @Then("^I send (\\d+) into search field$")
    public void I_send_into_search_field(int arg1) throws Throwable {
        System.out.println("numarul este: " + arg1);
    }

    @When("^I enter \"([^\"]*)\"/\"([^\"]*)\" credentials$")
    public void I_enter_credentials(String emailValue, String passValue) throws Throwable {
        loginPage.enterCredentials(emailValue, passValue);
    }

    @Then("^I expect \"([^\"]*)\" message$")
    public void I_expect_message(String errorMessage) {

        loginPage.errorMessageShouldBePresent(errorMessage);
    }

    @Given("^I successfully login$")
    public void I_successfully_login() throws Throwable {
        I_access_the_login_page();
        I_insert_valid_credentials();
        I_click_login_button();
        I_check_if_user_was_logged_in();
    }
}
