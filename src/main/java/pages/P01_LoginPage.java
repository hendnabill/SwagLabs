package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_LoginPage extends PageBase{

    //todo: define constructor
    public P01_LoginPage(WebDriver driver){
        super(driver);
    }

    //todo: define locators

    private final By USERNAME_TEXT=By.id("user-name");
    private final By PASSWORD_TEXT=By.id("password");
    private final By LOGIN_BUTTON=By.id("login-button");

    // todo: action methods

    public P01_LoginPage enterUsername(String username){
        driver.findElement(this.USERNAME_TEXT).sendKeys(username);
        return this;
    }

    public P01_LoginPage enterPassword(String password){
        driver.findElement(this.PASSWORD_TEXT).sendKeys(password);
        return this;
    }

    public P01_LoginPage clickLoginButton(){
        driver.findElement(this.LOGIN_BUTTON).click();
        return this;
    }


}




