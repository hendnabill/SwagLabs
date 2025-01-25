package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P05_CheckOverviewPage extends PageBase {

    //todo: define constructor
    public P05_CheckOverviewPage(WebDriver driver){
        super(driver);
    }

    //todo: locators
    private final By SUBTOTAL_PRICE=By.xpath("//div[@class='summary_subtotal_label']");
    private final By TAX_VALUE=By.xpath("//div[@class='summary_tax_label']");
    private final By PRICE_AFTER_TAX =By.xpath("//div[@class='summary_total_label']");
    private final By Finish_BUTTON=By.id("finish");
    private final By SUCCESS_MESSAGE=By.xpath("//h2[contains(text(),'Thank you for your order!')]");
    private final By ITEM_PRICES = By.className("inventory_item_price");
    private final By ITEM_TOTAL = By.xpath("//div[@class='summary_subtotal_label']");




    // todo: methods

    // Method to get total price from the checkout page
    public String getDisplayedTotal() {
        String totalText = driver.findElement(SUBTOTAL_PRICE).getText();
        return driver.findElement(SUBTOTAL_PRICE).getText();
    }

    public String getTax() {
        String taxText = driver.findElement(TAX_VALUE).getText();
        return driver.findElement(TAX_VALUE).getText();
    }

    // get tax 
    public double getDisplayedTax() {
        String taxText = driver.findElement(TAX_VALUE).getText();
        return Double.parseDouble(taxText.replace("Tax: $", "").trim());
    }

    //get total+tax
    public double getDisplayedTotalPrice() {
        String totalPriceText = driver.findElement(PRICE_AFTER_TAX).getText();
        return Double.parseDouble(totalPriceText.replace("Total: $", "").trim());
    }

    //click finish button
    public P05_CheckOverviewPage clickFinishButton (){
        driver.findElement(this.Finish_BUTTON).click();
        return this;
    }

    public String getSuccessMessage() {
        WebElement successElement = driver.findElement(SUCCESS_MESSAGE);
        return successElement.getText();
    }


    // Get all product prices
    public double getSumOfProductPrices() {
        List<WebElement> prices = driver.findElements(ITEM_PRICES);
        double sum = 0.0;

        for (WebElement price : prices) {
            // Remove "$" and parse to double
            sum += Double.parseDouble(price.getText().replace("$", "").trim());
        }

        return sum;
    }

    // Get the "Item Total" value
    public double getDisplayedItemTotal() {
        String itemTotalText = driver.findElement(ITEM_TOTAL).getText();
        return Double.parseDouble(itemTotalText.replace("Item total: $", "").trim());
    }


}
