package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;

import static drivers.DriverHolder.getDriver;
import static pages.PageBase.captureScreenshot;

public class TC01_Login extends TestBase {
    P01_LoginPage loginPage;
    String username="standard_user";
    String password="secret_sauce";

    @Test(priority = 1,description = "verify valid login")

    public void validLogin_p() throws InterruptedException {
        loginPage=new P01_LoginPage(getDriver());

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        Thread.sleep(3000);

        //capture screenshot
        captureScreenshot(getDriver(),"login successfully");

        //assertion
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/inventory.html");



    }


}
