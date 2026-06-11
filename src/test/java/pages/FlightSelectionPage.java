package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightSelectionPage {

    WebDriver driver;

    public FlightSelectionPage(WebDriver driver) {
        this.driver = driver;
    }

    By flightTable = By.className("table");

    By chooseFlightButton =
            By.xpath("(//input[@type='submit'])[1]");

    public boolean isFlightListDisplayed() {

        return driver.findElement(
                flightTable)
                .isDisplayed();
    }

    public void chooseFirstFlight() {

        driver.findElement(
                chooseFlightButton)
                .click();
    }
    
}