package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverSetup {
    private static WebDriver driver;
    public static String BROWSER =
            System.getProperty("selenium.browser", "chrome");
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static void initDriver() {
        if (driver == null) {
            switch (BROWSER) {
                case "chrome":
                    String chromeDriverLocation = System.getProperty("webdriver.chrome.driver",
                            "C:\\chromedriver\\chromedriver.exe");
                    System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
                    if (Boolean.valueOf(System.getProperty("selenium.remote", "true"))) {
                        initRemoteDriver(DesiredCapabilities.chrome());
                    } else {
                        driverThread.set(new ChromeDriver());
                    }
                    break;
                case "firefox":
                    String firefoxDriverLocation = System.getProperty("selenium.geckodriver",
                            "C:\\Users\\Lilit\\Downloads\\Automation files\\seleniumDrivers");
                    System.setProperty("webdriver.gecko.driver", firefoxDriverLocation);
                    driver = new FirefoxDriver();
                    driver.manage().window().fullscreen();
                    break;
            }
        }
    }

    public static void initRemoteDriver(DesiredCapabilities capability) {
        capability.setCapability(CapabilityType.PLATFORM_NAME, "Linux");
        WebDriver webDriver = null;
        try {
            webDriver = new RemoteWebDriver(new URL("https://vika_minasyan83e4df83-b821-4b27-b4ad-5222e73af79f.saucelabs.com:80/wd/hub"), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driverThread.set(webDriver);
    }

    public static WebDriver getDriver() {
        return driverThread.get();
    }


    public static void quitDriver() {
        getDriver().close();
        getDriver().quit();

    }
}
