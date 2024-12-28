package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Constants;

public class LoginPage {
    private WebDriver driver;

    //By Locators
    private By userName = By.id("user-name");
    private By password = By.id("password");
    private By signInButton = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void insertUsernameAndPassword(){
        driver.findElement(userName).sendKeys(Constants.USER_NAME);
        driver.findElement(password).sendKeys(Constants.PASSWORD);
    }

    public void clickOnLoginButton(){
        driver.findElement(signInButton).click();
    }

    public HomePage doLogin() {
        driver.findElement(userName).sendKeys(Constants.USER_NAME);
        driver.findElement(password).sendKeys(Constants.PASSWORD);
        driver.findElement(signInButton).click();
        return new HomePage(driver);
    }
}