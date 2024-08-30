package tests;

import pages.ContactUsPage;
import pages.Homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactUsTest {

    WebDriver driver;
    Homepage homepage;
    ContactUsPage contactUsPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");
    }

    @Test
    public void contactUsTest() {

        homepage = new Homepage(driver);
        contactUsPage = new ContactUsPage(driver);

        homepage.checkThatUserShouldBeNavigatedToHomePageSuccessfully();
        homepage.clickOnContactUsLink();

        contactUsPage.checkThatContactUsPageIsLoadedSuccessfully();
        contactUsPage.fillInContactUsForm("Mohammed", "test12345@gmail.com", "Test", "Welcome");
        contactUsPage.clickOnSubmitButton();
        contactUsPage.checkThatFormShouldBeSubmittedSuccessfully();
        contactUsPage.clickOnHomeButton();

        homepage.checkThatUserShouldBeNavigatedToHomePageSuccessfully();

    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
