package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountSuccessfulDeletion {

    public Driver driver;

    By successMessage = By.xpath("//h2[@data-qa=\"account-deleted\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    public AccountSuccessfulDeletion(Driver driver){
        this.driver = driver;
    }

    /***************************************** Assertions ********************************************/

    public AccountSuccessfulDeletion checkThatAccountShouldBeDeletedSuccessfully() {
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/delete_account"));
        Assert.assertTrue(driver.element().isDisplayed(successMessage));
        Assert.assertEquals(driver.element().getTextOf(successMessage), "ACCOUNT DELETED!");
        return this;
    }

    public Homepage clickOnContinueButton(){
        driver.element().click(continueButton);
        return new Homepage(driver);
    }
}
