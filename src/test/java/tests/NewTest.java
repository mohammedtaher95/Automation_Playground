package tests;

import pages.Homepage;
import pages.LoginSignUpPage;
import pages.RegistrationPage;
import pages.RegistrationSuccessPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.AccountSuccessfulDeletion;

public class NewTest {

    WebDriver driver;

    Homepage homepage;
    LoginSignUpPage loginSignUpPage;
    RegistrationPage registrationPage;
    RegistrationSuccessPage successPage;
    AccountSuccessfulDeletion deleteAccount;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");
    }

    @Test(priority = 1)
    public void userCanRegisterSuccessfully() {
        homepage = new Homepage(driver);
        loginSignUpPage = new LoginSignUpPage(driver);
        registrationPage = new RegistrationPage(driver);
        successPage = new RegistrationSuccessPage(driver);

        homepage.checkThatUserShouldBeNavigatedToHomePageSuccessfully();
        homepage.clickOnLoginLink();

        loginSignUpPage.checkThatUserIsNavigatedToLoginSignUpPage();
        loginSignUpPage.fillInSignUpName("Mohammed");
        loginSignUpPage.fillInSignUpEmail("test85874@gmail.com");
        loginSignUpPage.clickOnSignUpButton();

        registrationPage.checkThatRegistrationPageIsLoadedSuccessfully();

        registrationPage.fillInRegistrationPage();
        registrationPage.clickOnCreateAccountButton();

        successPage.checkThatSuccessMessageShouldBeDisplayed();

        driver.manage().deleteAllCookies();

    }

    @Test(dependsOnMethods = "userCanRegisterSuccessfully", priority = 2)
    public void userCanLoginSuccessfully() {
        driver.navigate().to("https://automationexercise.com/login");

        loginSignUpPage.fillInLoginEmail("test85874@gmail.com");
        loginSignUpPage.fillInLoginPassword("12345678");
        loginSignUpPage.clickOnLoginButton();

        homepage.checkThatLogoutLinkShouldBeDisplayed();
    }

    @Test(dependsOnMethods = "userCanLoginSuccessfully", priority = 3)
    public void userCanLogoutSuccessfully() {
        homepage.clickOnLogoutLink();
        homepage.checkThatLoginLinkShouldBeDisplayed();
        loginSignUpPage.checkThatUserIsNavigatedToLoginSignUpPage();
    }

    @Test(dependsOnMethods = "userCanLogoutSuccessfully", priority = 4)
    public void userCanDeleteAccountSuccessfully() {
        deleteAccount = new AccountSuccessfulDeletion(driver);

        loginSignUpPage.fillInLoginEmail("test85874@gmail.com");
        loginSignUpPage.fillInLoginPassword("12345678");
        loginSignUpPage.clickOnLoginButton();

        homepage.checkThatLogoutLinkShouldBeDisplayed();
        homepage.clickOnDeleteAccountLink();

        deleteAccount.checkThatAccountShouldBeDeletedSuccessfully();
        deleteAccount.clickOnContinueButton();

        homepage.checkThatUserShouldBeNavigatedToHomePageSuccessfully();
        homepage.checkThatLoginLinkShouldBeDisplayed();

    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
