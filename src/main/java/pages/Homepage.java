package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage {

    public WebDriver driver;

    By loginLink = By.xpath("//a[@href=\"/login\"]");
    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");
    By contactUsLink = By.xpath("//a[@href=\"/contact_us\"]");

    public Homepage(WebDriver driver){
        this.driver = driver;
    }

    /***************************************** Assertions ********************************************/

    public void checkThatLogoutLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.findElement(logoutLink).isDisplayed());
    }

    public void checkThatLoginLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.findElement(loginLink).isDisplayed());
    }

    public void checkThatDeleteAccountLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.findElement(deleteAccountLink).isDisplayed());
    }

    public void checkThatUserShouldBeNavigatedToHomePageSuccessfully() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
    }


    /******************************************* Actions ********************************************/

    public void clickOnLoginLink(){
        driver.findElement(loginLink).click();
    }

    public void clickOnLogoutLink(){
        driver.findElement(logoutLink).click();
    }

    public void clickOnDeleteAccountLink(){
        driver.findElement(deleteAccountLink).click();
    }

    public void clickOnContactUsLink() {
        driver.findElement(contactUsLink).click();
    }

}
