package tests;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.ContactUsPage;
import pages.Homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ScreenShotManager;

import java.time.Duration;

public class ContactUsTest {

    public Driver driver;
    ThreadLocal<Driver> parallelDriver;

    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setUp(@Optional("EDGE") String browserName) {
        driver = new Driver(browserName);
        driver.get().manage().window().maximize();
        driver.get().navigate().to("https://automationexercise.com/");
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

    }

    @Test
    public void contactUsTest() {
        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .clickOnContactUsLink()
                .checkThatContactUsPageIsLoadedSuccessfully()
                .fillInContactUsForm("Mohammed", "test12345@gmail.com", "Test", "Welcome")
                .clickOnSubmitButton()
                .checkThatFormShouldBeSubmittedSuccessfully()
                .clickOnHomeButton()
                .checkThatUserShouldBeNavigatedToHomePageSuccessfully();



    }

//    @AfterMethod
//    public void screenshotOnFailure(ITestResult result) {
//
//        if(result.getStatus() == ITestResult.FAILURE){
//            System.out.println("Test Failed");
//            System.out.println("Taking screen shot.....");
//            ScreenShotManager.captureScreenshot(driver.get(), result.getName());
//        }
//
//    }

    @AfterClass
    public void tearDown() {
        driver.get().manage().deleteAllCookies();
        driver.quit();
    }
}
