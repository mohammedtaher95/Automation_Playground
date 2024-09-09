package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory extends DriverAbstract {


    @Override
    public WebDriver startDriver() {
        driver = new ChromeDriver();
        return driver;
    }
}
