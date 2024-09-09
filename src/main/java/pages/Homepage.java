package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage {

    public Driver driver;


    By loginLink = By.xpath("//a[@href=\"/login\"]");
    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");
    By contactUsLink = By.xpath("//a[@href=\"/contact_us\"]");

    public Homepage(Driver driver){
        this.driver = driver;
    }

    /***************************************** Assertions ********************************************/

    public Homepage checkThatLogoutLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(logoutLink));
        return this;
    }

    public Homepage checkThatLoginLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(loginLink));
        return this;
    }

    public Homepage checkThatDeleteAccountLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(deleteAccountLink));
        return this;
    }

    public Homepage checkThatUserShouldBeNavigatedToHomePageSuccessfully() {
        Assert.assertEquals(driver.get().getCurrentUrl(), "https://automationexercise.com/");
        return this;
    }


    /******************************************* Actions ********************************************/

    public LoginSignUpPage clickOnLoginLink(){
        driver.get().findElement(loginLink).click();
        return new LoginSignUpPage(driver);
    }

    public LoginSignUpPage clickOnLogoutLink(){
        driver.get().findElement(logoutLink).click();
        return new LoginSignUpPage(driver);
    }

    public AccountSuccessfulDeletion clickOnDeleteAccountLink(){
        driver.element().click(deleteAccountLink);
        return new AccountSuccessfulDeletion(driver);
    }

    public ContactUsPage clickOnContactUsLink() {
        driver.get().findElement(contactUsLink).click();
        return new ContactUsPage(driver);
    }

}
