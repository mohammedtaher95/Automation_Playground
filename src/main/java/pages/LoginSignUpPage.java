package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSignUpPage {

    public WebDriver driver;

    By loginEmail = By.xpath("//input[@data-qa=\"login-email\"]");
    By loginPassword = By.xpath("//input[@data-qa=\"login-password\"]");
    By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");

    By signUpFormTitle = By.xpath("(//h2)[3]");
    By signUpName = By.name("name");
    By signUpEmail = By.xpath("//input[@data-qa=\"signup-email\"]");
    By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");

    public LoginSignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    /****************************************** Assertions ******************************************/

    public void checkThatUserIsNavigatedToLoginSignUpPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        Assert.assertEquals(driver.findElement(signUpFormTitle).getText(),"New User Signup!");
    }

    /******************************************* Actions ********************************************/

    public void fillInLoginEmail(String email) {
        driver.findElement(loginEmail).sendKeys(email);
    }

    public void fillInLoginPassword(String password) {
        driver.findElement(loginPassword).sendKeys(password);
    }

    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void fillInSignUpName(String name) {
        driver.findElement(signUpName).sendKeys(name);
    }
    public void fillInSignUpEmail(String email) {
        driver.findElement(signUpEmail).sendKeys(email);
    }

    public void clickOnSignUpButton() {
        driver.findElement(signUpButton).click();
    }

}
