package com.conduit.pages;


import com.conduit.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * This class will be extended by page classes
 * Ant common webelements/locators can be stored here
 * Since navigation menu doesn't belong to particular page
 * We cannot really create a dedicated page class to store
 * elements from that menu
 */
public abstract class AbstractPageBase {

    @FindBy(xpath = "//a[@routerlink = '/home']")
    private WebElement homePage;
    @FindBy(xpath = "//a[@routerlink = '/login']")
    private WebElement loginPage;
    @FindBy(xpath = "//a[@routerlink = '/register']")
    private WebElement registerPage;

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25);

    public AbstractPageBase() {
        PageFactory.initElements(driver, this);
    }

    public void clickToLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage)).click();
    }

}
