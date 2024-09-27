package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Homepage {

    public final Driver driver;

    By loginLink = By.xpath("//a[@href=\"/login\"]");
    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");
    By contactUsLink = By.xpath("//a[@href=\"/contact_us\"]");

    public Homepage(Driver driver){
        this.driver = driver;
    }

    /***************************************** Assertions ********************************************/

    @Step("checkThatLogoutLinkShouldBeDisplayed")
    public Homepage checkThatLogoutLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(logoutLink));
        return this;
    }

    @Step("checkThatLoginLinkShouldBeDisplayed")
    public Homepage checkThatLoginLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(loginLink));
        return this;
    }

    @Step("checkThatDeleteAccountLinkShouldBeDisplayed")
    public Homepage checkThatDeleteAccountLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(deleteAccountLink));
        return this;
    }

    @Step("Check That User Should Be Navigated To Home Page Successfully")
    public Homepage checkThatUserShouldBeNavigatedToHomePageSuccessfully() {
        Assert.assertEquals(driver.get().getCurrentUrl(), "https://automationexercise.com/");
        return this;
    }


    /******************************************* Actions ********************************************/

    @Step("User clicks on Login Link")
    public LoginSignUpPage clickOnLoginLink(){
        driver.get().findElement(loginLink).click();
        return new LoginSignUpPage(driver);
    }

    @Step("User clicks on Logout Link")
    public LoginSignUpPage clickOnLogoutLink(){
        driver.get().findElement(logoutLink).click();
        return new LoginSignUpPage(driver);
    }

    @Step("User clicks on Delete Account Link")
    public AccountSuccessfulDeletion clickOnDeleteAccountLink(){
        driver.element().click(deleteAccountLink);
        return new AccountSuccessfulDeletion(driver);
    }

    @Step("User clicks on Contact us Link")
    public ContactUsPage clickOnContactUsLink() {
        driver.get().findElement(contactUsLink).click();
        return new ContactUsPage(driver);
    }

}
