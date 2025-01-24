package testcases;

import common.MyScreenRecorder;
import drivers.DriverFactory;
import org.testng.annotations.*;

import java.awt.*;
import java.time.Duration;

import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;
import static pages.PageBase.quitBrowser;
import static util.Utility.openBrowserNetworkTab;

public class TestBase {
    String username="standard_user";
    String password="secret_sauce";

    @BeforeSuite
    public void beforSuite() throws Exception {
        MyScreenRecorder.startRecording("SwagLabs-TestCases");

    }

    @Parameters("browsername")
    @BeforeTest

    //set up webdriver
    public void setupDriver(String browsername) throws AWTException {

        setDriver(DriverFactory.getNewInstance(browsername)); //default=chrome
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        getDriver().get("https://www.saucedemo.com/");

        //openBrowserNetworkTab();


    }


   @AfterTest
    public void teardown() {
        quitBrowser(getDriver());
    }

    @AfterSuite
    public void afterSuite() throws Exception {

        MyScreenRecorder.stopRecording();
    }
}
