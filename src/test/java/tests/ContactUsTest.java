package tests;

import driverfactory.Driver;
import org.openqa.selenium.By;
import pages.ContactUsPage;
import pages.Homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactUsTest {

    Driver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = new Driver("CHROME");
        driver.get().manage().window().maximize();
        driver.get().navigate().to("https://automationexercise.com/");
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.element().hoverOnItem(By.xpath("(//div[@class=\"product-overlay\"])[1]"))
                .click(By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]"));
        Thread.sleep(5000);
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

    @AfterClass
    public void tearDown() {
        driver.get().manage().deleteAllCookies();
        driver.quit();
    }
}
