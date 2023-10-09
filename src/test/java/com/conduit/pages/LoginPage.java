package com.conduit.pages;

import com.conduit.utilities.BrowserUtilities;
import com.conduit.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPageBase{

    @FindBy(xpath = "//input[@placeholder = 'Email']")
    private WebElement email;

    @FindBy(xpath = "//input[@placeholder = 'Password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement login;

    /**
     * Method to login, version #1
     * Login as a specific user
     *
     */
    public void login(String usernameValue, String passwordValue) {
        clickToLogin();
        email.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
    }

    /**
     * Method to login, version #2
     * Login as a default user
     * Credentials will be retrieved from configuration.properties file
     */
    public void login() {
        clickToLogin();
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
        email.sendKeys(ConfigurationReader.getProperty("DEFAULT_EMAIL"));
        password.sendKeys(ConfigurationReader.getProperty("DEFAULT_PASSWORD"), Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
    }
}
