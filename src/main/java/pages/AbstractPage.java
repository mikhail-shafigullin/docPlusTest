package pages;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class AbstractPage {

    private static final WebDriver driver = chooseDriver();

    private static WebDriver chooseDriver(){
        String browserProperty = System.getProperty("browser", "chrome");
        switch (browserProperty) {
            case "chrome":
                return initChromeDriver();
            case "ie":
                return initIEDriver();
            default:
                return initChromeDriver();
        }
    }

    private static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        return new ChromeDriver();
    }

    private static WebDriver initIEDriver(){
        System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("internet explorer");
        capabilities.setCapability("ignoreProtectedModeSettings", "true");
        capabilities.setCapability("requireWindowFocus", "false");
        return new InternetExplorerDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

}
