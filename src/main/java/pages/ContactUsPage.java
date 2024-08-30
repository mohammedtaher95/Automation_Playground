package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactUsPage {

    public WebDriver driver;

    By formTitle = By.xpath("(//h2[@class=\"title text-center\"])[2]");
    By nameField = By.name("name");
    By emailField = By.name("email");
    By subjectField = By.name("subject");
    By messageField = By.id("message");
    By submitButton = By.name("submit");
    By successMessage = By.cssSelector("div.status.alert.alert-success");
    By homeButton = By.cssSelector("a.btn.btn-success");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    /************************************ Assertions ******************************************/

    public void checkThatContactUsPageIsLoadedSuccessfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/contact_us"));
        Assert.assertEquals(driver.findElement(formTitle).getText(), "GET IN TOUCH");
    }

    public void checkThatFormShouldBeSubmittedSuccessfully() {
        Assert.assertEquals(driver.findElement(successMessage).getText(), "Success! Your details have been submitted successfully.");
    }

    /********************************** Actions ******************************************/

    public void fillInContactUsForm(String name, String email, String subject, String message) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(messageField).sendKeys(message);

    }

    public void clickOnSubmitButton() {
        driver.findElement(submitButton).click();
        driver.switchTo().alert().accept();
    }

    public void clickOnHomeButton() {
        driver.findElement(homeButton).click();
    }
}
