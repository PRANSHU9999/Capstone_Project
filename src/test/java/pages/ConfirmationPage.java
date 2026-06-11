package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtils;

public class ConfirmationPage {

    WebDriver driver;

    By confirmationMessage =
            By.tagName("h1");

    By bookingId =
            By.xpath("//td[text()='Id']/following-sibling::td");

    By bookingStatus =
            By.xpath("//td[text()='Status']/following-sibling::td");

    By bookingAmount =
            By.xpath("//td[text()='Amount']/following-sibling::td");

    public ConfirmationPage(
            WebDriver driver) {

        this.driver = driver;
    }

    public String getConfirmationMessage() {

        return WaitUtils
                .waitForElementVisible(
                        driver,
                        confirmationMessage)
                .getText();
    }

    public String getBookingId() {

        return driver
                .findElement(bookingId)
                .getText();
    }

    public String getBookingStatus() {

        return driver
                .findElement(bookingStatus)
                .getText();
    }

    public String getBookingAmount() {

        return driver
                .findElement(bookingAmount)
                .getText();
    }
}