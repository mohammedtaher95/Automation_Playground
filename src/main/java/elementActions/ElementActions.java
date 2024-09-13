package elementActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementActions {
    private WebDriver driver;
    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }

    public ElementActions click(By locator) {
        System.out.println("Click on: " + locator.toString());
        driver.findElement(locator).click();
        return this;
    }

    public ElementActions fillField(By locator, String text){
        clearField(locator);
        System.out.println("fill field: " + locator.toString() + " with: " + text);
        driver.findElement(locator).sendKeys(text);
        return this;
    }

    public ElementActions clearField(By locator){
        System.out.println("Clear field with locator: " + locator.toString());
        driver.findElement(locator).clear();
        return this;
    }

    public ElementActions selectByIndex(By locator, int index) {
        new Select(driver.findElement(locator)).selectByIndex(index);
        return this;
    }

    public ElementActions selectByValue(By locator, String text) {
        new Select(driver.findElement(locator)).selectByValue(text);
        return this;
    }

    public ElementActions scrollToElement(By locator) {
        new Actions(driver).scrollToElement(driver.findElement(locator)).build().perform();
        return this;
    }

    public ElementActions hoverOnItem(By locator) {
        new Actions(driver).moveToElement(driver.findElement(locator)).click().build().perform();
        return this;
    }

    public String getTextOf(By locator) {
        return driver.findElement(locator).getText();
    }

    public Boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public Boolean isSelected(By locator) {
        return driver.findElement(locator).isSelected();
    }

    public Boolean isClickable(By locator) {
        return driver.findElement(locator).isEnabled();
    }
}
