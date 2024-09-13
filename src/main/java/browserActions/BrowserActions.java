package browserActions;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserActions {

    private WebDriver driver;

    public BrowserActions(WebDriver driver){
        this.driver = driver;
    }

    /******************************* URL Controlling and Navigation *********************************/
    public BrowserActions navigateToURL(String url) {
        driver.navigate().to(url);
        return this;
    }

    public BrowserActions getToURL(String url) {
        driver.get(url);
        return this;
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public BrowserActions navigateForward() {
        driver.navigate().forward();
        return this;
    }

    public BrowserActions navigateBack() {
        driver.navigate().back();
        return this;
    }

    public BrowserActions refreshCurrentPage() {
        driver.navigate().refresh();
        return this;
    }

    public BrowserActions scrollToBottom() {
        new Actions(driver).scrollByAmount(0, 2500).build().perform();
        return this;
    }

    public BrowserActions scrollToAmount(int width, int height) {
        new Actions(driver).scrollByAmount(width, height).build().perform();
        return this;
    }

    /****************************************** Cookies ****************************************/

    public BrowserActions addCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
        return this;
    }


    public BrowserActions deleteCookie(Cookie cookie) {
        driver.manage().deleteCookie(cookie);
        return this;
    }

    public BrowserActions deleteCookieWithName(String name) {
        driver.manage().deleteCookieNamed(name);
        return this;
    }

    public BrowserActions deleteAllCookies() {
        driver.manage().deleteAllCookies();
        return this;
    }

    /********************************** Window Control **************************************/
}
