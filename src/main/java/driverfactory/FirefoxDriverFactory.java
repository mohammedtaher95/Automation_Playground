package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverFactory extends DriverAbstract{
    @Override
    public WebDriver startDriver() {
        driver = new FirefoxDriver();
        return driver;
    }
}
