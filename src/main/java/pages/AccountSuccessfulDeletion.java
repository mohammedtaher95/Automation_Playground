package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountSuccessfulDeletion {

    public WebDriver driver;

    By successMessage = By.xpath("//h2[@data-qa=\"account-deleted\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    public AccountSuccessfulDeletion(WebDriver driver){
        this.driver = driver;
    }

    /***************************************** Assertions ********************************************/

    public void checkThatAccountShouldBeDeletedSuccessfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/delete_account"));
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
        Assert.assertEquals(driver.findElement(successMessage).getText(), "ACCOUNT DELETED!");
    }

    public void clickOnContinueButton(){
        driver.findElement(continueButton).click();
    }
}
