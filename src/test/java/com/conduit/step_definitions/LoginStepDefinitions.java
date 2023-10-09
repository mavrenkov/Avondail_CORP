package com.conduit.step_definitions;

import com.conduit.pages.LoginPage;
import com.conduit.utilities.BrowserUtilities;
import com.conduit.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import com.conduit.utilities.Driver;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("Open login page");
        String env = "dev";
        if (System.getProperty("env") != null) {
            env = System.getProperty("env");
        }
        String URL = ConfigurationReader.getProperty(env);
        System.out.println("URL :: " + URL);
        Driver.getDriver().get(URL);
    }

    @And("Logging in as a default user")
    public void loggingInWirthDefaultCreds() {
        System.out.println("Loggin in with a default creds");
        loginPage.login();
    }


    @Then("user should verify that title is a Conduit")
    public void user_should_verify_that_title_is_a_Conduit() {
        System.out.println("Verify that title is a Conduit");
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);
        Assert.assertEquals("Conduit", Driver.getDriver().getTitle());
    }

}
