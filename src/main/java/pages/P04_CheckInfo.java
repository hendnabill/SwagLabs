package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_CheckInfo extends PageBase{
    //todo: define constructor
    public P04_CheckInfo(WebDriver driver){
        super(driver);
    }

    //todo:locators
    private final By FIRST_NAME=By.id("first-name");
    private final By LAST_NAME=By.id("last-name");
    private final By POSTAL_CODE=By.id("postal-code");
    private final By CONTINUE_BUTTON=By.id("continue");

    //todo:methos
    public P04_CheckInfo enterFirstName(String firstname){
        driver.findElement(this.FIRST_NAME).sendKeys(firstname);
        return this;
    }

    public P04_CheckInfo enterLastName(String lastname){
        driver.findElement(this.LAST_NAME).sendKeys(lastname);
        return this;
    }

    public P04_CheckInfo enterPostalCode(String postalcode){
        driver.findElement(this.POSTAL_CODE).sendKeys(postalcode);
        return this;
    }

    public P04_CheckInfo clickContinueButton(){
        driver.findElement(this.CONTINUE_BUTTON).click();
        return this;
    }





}
