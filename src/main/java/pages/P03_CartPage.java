package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_CartPage extends PageBase{
    //todo: define constructor
    public P03_CartPage(WebDriver driver){
        super(driver);
    }

    //todo:locators
    private final By CHECKOUT_BUTTON =By.id("checkout");

    //todo: methods
    public P03_CartPage clickCheckoutButton(){
        driver.findElement(this.CHECKOUT_BUTTON).click();
        return this;
    }

}
