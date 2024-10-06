package tests;

import driverfactory.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Homepage;
import pages.LoginSignUpPage;
import pages.RegistrationPage;
import pages.RegistrationSuccessPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.AccountSuccessfulDeletion;

import java.time.Duration;

public class NewTest {

    public Driver driver;

    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new Driver();
        wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
        driver.get().manage().window().maximize();
        driver.get().navigate().to("https://automationexercise.com/");
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test(priority = 1)
    public void userCanRegisterSuccessfully() {

        new Homepage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .clickOnLoginLink()
                .checkThatUserIsNavigatedToLoginSignUpPage()
                .fillInSignUpName("Mohammed")
                .fillInSignUpEmail("test9584666@gmail.com")
                .clickOnSignUpButton()
                .checkThatRegistrationPageIsLoadedSuccessfully()
                .fillInRegistrationPage()
                .clickOnCreateAccountButton()
                .checkThatSuccessMessageShouldBeDisplayed();


        driver.get().manage().deleteAllCookies();

    }

    @Test(dependsOnMethods = "userCanRegisterSuccessfully", priority = 2)
    public void userCanLoginSuccessfully() {
        driver.get().navigate().to("https://automationexercise.com/login");

        new LoginSignUpPage(driver).fillInLoginEmail("test9584666@gmail.com")
                .fillInLoginPassword("12345678")
                .clickOnLoginButton().checkThatLogoutLinkShouldBeDisplayed();
    }

    @Test(dependsOnMethods = "userCanLoginSuccessfully", priority = 3)
    public void userCanLogoutSuccessfully() {

        new Homepage(driver).clickOnLogoutLink()
                .checkThatUserIsNavigatedToLoginSignUpPage();
    }

    @Test(dependsOnMethods = "userCanLogoutSuccessfully", priority = 4)
    public void userCanDeleteAccountSuccessfully() {

        new LoginSignUpPage(driver).fillInLoginEmail("test9584666@gmail.com")
                .fillInLoginPassword("12345678")
                .clickOnLoginButton()
                .checkThatLogoutLinkShouldBeDisplayed()
                .clickOnDeleteAccountLink()
                .checkThatAccountShouldBeDeletedSuccessfully()
                .clickOnContinueButton()
                .checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .checkThatLoginLinkShouldBeDisplayed();
    }

    @AfterClass
    public void tearDown() {
        driver.get().manage().deleteAllCookies();
        driver.quit();
    }
}
