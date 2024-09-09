package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSignUpPage {

    public Driver driver;

    By loginEmail = By.xpath("//input[@data-qa=\"login-email\"]");
    By loginPassword = By.xpath("//input[@data-qa=\"login-password\"]");
    By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");

    By signUpFormTitle = By.xpath("(//h2)[3]");
    By signUpName = By.name("name");
    By signUpEmail = By.xpath("//input[@data-qa=\"signup-email\"]");
    By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");

    public LoginSignUpPage(Driver driver) {
        this.driver = driver;
    }

    /****************************************** Assertions ******************************************/

    public LoginSignUpPage checkThatUserIsNavigatedToLoginSignUpPage() {
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/login"));
        Assert.assertEquals(driver.element().getTextOf(signUpFormTitle),"New User Signup!");
        return this;
    }

    /******************************************* Actions ********************************************/

    public LoginSignUpPage fillInLoginEmail(String email) {
        driver.element().fillField(loginEmail, email);
        return this;
    }

    public LoginSignUpPage fillInLoginPassword(String password) {
        driver.element().fillField(loginPassword, password);
        return this;
    }

    public Homepage clickOnLoginButton() {
        driver.element().click(loginButton);
        return new Homepage(driver);
    }

    public LoginSignUpPage fillInSignUpName(String name) {
        driver.element().fillField(signUpName ,name);
        return this;
    }
    public LoginSignUpPage fillInSignUpEmail(String email) {
        driver.element().fillField(signUpEmail, email);
        return this;
    }

    public RegistrationPage clickOnSignUpButton() {
        driver.element().click(signUpButton);
        return new RegistrationPage(driver);
    }

}
