package tests;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import pages.ContactUsPage;
import pages.Homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ScreenShotManager;

import java.time.Duration;

public class ContactUsTest {

    Driver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = new Driver("CHROME");
        driver.get().manage().window().maximize();
        driver.get().navigate().to("https://automationexercise.com/");
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

    }

    @Test
    public void contactUsTest() throws InterruptedException {
//        driver.element().hoverOnItem(By.xpath("(//div[@class=\"product-overlay\"])[1]"))
//                .click(By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]"));
//        Thread.sleep(5000);

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
