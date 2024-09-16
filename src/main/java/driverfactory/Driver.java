package driverfactory;

import browserActions.BrowserActions;
import elementActions.ElementActions;
import listeners.webdriver.WebDriverListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class Driver {
    private static WebDriver driver;
    public Driver(String driverType) {
        WebDriver undecoratedDriver = getDriver(driverType).startDriver();

//        driver = new EventFiringDecorator<>(org.openqa.selenium.WebDriver.class,
//                new WebDriverListener(undecoratedDriver)).decorate(undecoratedDriver);
//
        driver = new EventFiringDecorator<>(org.openqa.selenium.WebDriver.class,
                new WebDriverListeners(undecoratedDriver))
                .decorate(undecoratedDriver);
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
    public static WebDriver get() {
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
