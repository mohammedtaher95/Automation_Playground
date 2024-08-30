package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage {

    public WebDriver driver;

    By pageTitle = By.xpath("(//h2[@class=\"title text-center\"])[1]");
    By password = By.id("password");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By address = By.id("address1");
    By state = By.id("state");
    By city = By.id("city");
    By country = By.id("country");
    By zipCode = By.xpath("//input[@data-qa=\"zipcode\"]");
    By mobileNumber = By.xpath("//input[@data-qa=\"mobile_number\"]");
    By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    /***************************************** Assertions  ******************************************/

    public void checkThatRegistrationPageIsLoadedSuccessfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
        Assert.assertEquals(driver.findElement(pageTitle).getText(), "ENTER ACCOUNT INFORMATION");
    }

    /******************************************* Actions ********************************************/

    public void fillInRegistrationPage() {
        driver.findElement(password).sendKeys("12345678");
        driver.findElement(firstName).sendKeys("Mohammed");
        driver.findElement(lastName).sendKeys("Taher");
        driver.findElement(address).sendKeys("Alexandria");
        driver.findElement(state).sendKeys("Alex");
        driver.findElement(city).sendKeys("Alex");

        Select select = new Select(driver.findElement(country));
        select.selectByValue("Canada");

        driver.findElement(zipCode).sendKeys("21500");
        driver.findElement(mobileNumber).sendKeys("01234456978");
    }

    public void clickOnCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }
}
