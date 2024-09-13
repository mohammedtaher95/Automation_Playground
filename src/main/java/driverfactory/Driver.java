package driverfactory;

import browserActions.BrowserActions;
import elementActions.ElementActions;
import org.openqa.selenium.WebDriver;

public class Driver {
    private WebDriver driver;
    public Driver(String driverType) {
        driver = getDriver(driverType).startDriver();
        assert driver != null;
    }
    private DriverAbstract getDriver(String driver) {

        switch (driver) {
            case "CHROME": {
                return new ChromeDriverFactory();
            }
            case "FIREFOX": {
                return new FirefoxDriverFactory();
            }
            case "EDGE": {
                return new EdgeDriverFactory();
            }
            default: {
                throw new IllegalStateException("Unexpected value: " + driver);
            }
        }
    }
    public WebDriver get() {
        return driver;
    }
    public void quit() {
        driver.quit();
    }

    public ElementActions element() {
        return new ElementActions(driver);
    }

    public BrowserActions browser() {
        return new BrowserActions(driver);
    }
}
