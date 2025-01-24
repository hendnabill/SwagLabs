package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static drivers.DriverHolder.getDriver;
import static pages.PageBase.captureScreenshot;


public class TC02_Inventory extends TestBase {
    P02_InventoryPage inventoryPage;
    P03_CartPage cartPage;
    String firstname="hend";
    String lastname="nabil";
    String postalcode="1234";



    @Test
    public void addRandomProductsToCart_p() throws InterruptedException {

       // todo:login to app
        new P01_LoginPage(getDriver()).enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();

        //todo:add random product
        new P02_InventoryPage(getDriver()).addRandomProducts();
        Thread.sleep(3000);

        //todo: open the cart page
        new P02_InventoryPage(getDriver()).openCartPage();
        Thread.sleep(3000);

        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/cart.html");

        //todo: go to check out
        new P03_CartPage(getDriver()).clickCheckoutButton();
        Thread.sleep(3000);
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");

       //todo: fill in checkout info page
        new P04_CheckInfo(getDriver())
                .enterFirstName(firstname)
                .enterLastName(lastname)
                .enterPostalCode(postalcode);
        Thread.sleep(3000);


        new P04_CheckInfo(getDriver()).clickContinueButton();
        Thread.sleep(3000);
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");



        // Assert: Verify item total matches the sum of product prices
        P05_CheckOverviewPage checkOverviewPage = new P05_CheckOverviewPage(getDriver());
        double sumOfProductPrices = checkOverviewPage.getSumOfProductPrices();
        double displayedItemTotal = checkOverviewPage.getDisplayedItemTotal();

        Assert.assertEquals(displayedItemTotal, sumOfProductPrices, "Item total does not match the sum of product prices!");


        //assert total after tax

        double displayedTax = new P05_CheckOverviewPage(getDriver()).getDisplayedTax(); // tax value
        double displayedTotalPrice = new P05_CheckOverviewPage(getDriver()).getDisplayedTotalPrice(); // displayed total
        double calculatedTotalPrice = sumOfProductPrices + displayedTax; // total +tax
        BigDecimal roundedCalculatedTotal = new BigDecimal(calculatedTotalPrice).setScale(2, RoundingMode.HALF_UP);
        BigDecimal roundedDisplayedTotal = new BigDecimal(displayedTotalPrice).setScale(2, RoundingMode.HALF_UP);

        Assert.assertEquals(roundedDisplayedTotal, roundedCalculatedTotal, "Total price with tax does not match!");


        //todo:finish the order
        new P05_CheckOverviewPage(getDriver()).clickFinishButton();
        Thread.sleep(3000);

        captureScreenshot(getDriver(),"Create Order successfully");


        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");






    }

  }
