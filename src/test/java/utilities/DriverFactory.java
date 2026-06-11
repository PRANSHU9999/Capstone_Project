package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initializeDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();

        } 
        else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();

            driver = new FirefoxDriver(options);

        } 
        else {

            throw new RuntimeException(
                    "Unsupported Browser : "
                            + browser);
        }

        driver.manage().window().maximize();

        return driver;
    }

    public static WebDriver getDriver() {

        return driver;
    }
}