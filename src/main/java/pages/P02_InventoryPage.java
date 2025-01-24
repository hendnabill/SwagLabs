package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class P02_InventoryPage extends PageBase {

    private List<Double> selectedPrices = new ArrayList<>(); // save the product prices
    private final By CART_BUTTON = By.xpath("//a[@class='shopping_cart_link']");

    // Constructor
    public P02_InventoryPage(WebDriver driver) {
        super(driver);
    }

    // Method to find "Add to Cart" buttons
    private List<WebElement> getAddToCartButtons() {
        return driver.findElements(By.xpath("//button[text()='Add to cart']"));
    }

    // Method to find product prices
    private List<WebElement> getProductPrices() {
        return driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
    }

    // Method to add random products and save their prices
    public P02_InventoryPage addRandomProducts() {
        List<WebElement> buttons = getAddToCartButtons(); //all  "Add to Cart" buttons
        List<WebElement> prices = getProductPrices(); // all product prices

        if (buttons.isEmpty()) {
            throw new IllegalStateException("No products available to add.");
        }

        Random random = new Random();
        int randomCount = random.nextInt(Math.min(buttons.size(), 5)) + 1; //random n < 6

        for (int i = 0; i < randomCount; i++) {
            int index = random.nextInt(buttons.size());
            selectedPrices.add(Double.parseDouble(prices.get(index).getText().replace("$", ""))); // حفظ سعر المنتج
            buttons.get(index).click(); //add to cart
            buttons.remove(index); // remove to prevent repeating
            prices.remove(index); // remove prices
        }

        return this; // Return the current instance for chaining
    }

    // Method to open the cart page
    public P02_InventoryPage openCartPage() {
        driver.findElement(CART_BUTTON).click();
        return this;
    }

}
