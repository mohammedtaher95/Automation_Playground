package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationSuccessPage {

    public WebDriver driver;

    By successMessage = By.xpath("//h2[@data-qa=\"account-created\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");


    public RegistrationSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    /****************************************** Assertions ******************************************/

    public void checkThatSuccessMessageShouldBeDisplayed() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/account_created"));
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
        Assert.assertEquals(driver.findElement(successMessage).getText(), "ACCOUNT CREATED!");
    }
}
