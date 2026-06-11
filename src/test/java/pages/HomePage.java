package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtils;

public class HomePage {

    WebDriver driver;

    By fromPort = By.name("fromPort");
    By toPort = By.name("toPort");
    By findFlightsButton = By.cssSelector("input[type='submit']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFlight(String fromCity, String toCity) {

        WebElement fromDropdown =
                WaitUtils.waitForElementVisible(driver, fromPort);

        Select from = new Select(fromDropdown);
        from.selectByVisibleText(fromCity);

        WebElement toDropdown =
                WaitUtils.waitForElementVisible(driver, toPort);

        Select to = new Select(toDropdown);
        to.selectByVisibleText(toCity);

        WaitUtils.waitForElementVisible(driver, findFlightsButton)
                 .click();
    }
}