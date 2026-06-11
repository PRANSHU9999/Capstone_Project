package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtils;

public class PurchasePage {

    WebDriver driver;

    By purchasePageTitle = By.tagName("h2");

    By airlineInfo =
            By.xpath("//p[contains(text(),'Airline')]");

    By totalCostInfo =
            By.xpath("//p[contains(text(),'Price')]");

    By nameField = By.id("inputName");
    By addressField = By.id("address");
    By cityField = By.id("city");
    By stateField = By.id("state");
    By zipCodeField = By.id("zipCode");

    By cardTypeDropdown =
            By.id("cardType");

    By creditCardNumber =
            By.id("creditCardNumber");

    By creditCardMonth =
            By.id("creditCardMonth");

    By creditCardYear =
            By.id("creditCardYear");

    By nameOnCard =
            By.id("nameOnCard");

    By purchaseFlightButton =
            By.cssSelector("input[type='submit']");

    public PurchasePage(WebDriver driver) {

        this.driver = driver;
    }

    public String getPurchasePageTitle() {

        return WaitUtils
                .waitForElementVisible(
                        driver,
                        purchasePageTitle)
                .getText();
    }

    public boolean isAirlineDisplayed() {

        return driver.findElement(
                airlineInfo)
                .isDisplayed();
    }

    public boolean isTotalCostDisplayed() {

        return driver.findElement(
                totalCostInfo)
                .isDisplayed();
    }

    public void enterPassengerDetails(
            String name,
            String address,
            String city,
            String state,
            String zipCode) {

        WaitUtils.waitForElementVisible(
                driver,
                nameField)
                .sendKeys(name);

        WaitUtils.waitForElementVisible(
                driver,
                addressField)
                .sendKeys(address);

        WaitUtils.waitForElementVisible(
                driver,
                cityField)
                .sendKeys(city);

        WaitUtils.waitForElementVisible(
                driver,
                stateField)
                .sendKeys(state);

        WaitUtils.waitForElementVisible(
                driver,
                zipCodeField)
                .sendKeys(zipCode);
    }

    public void enterPaymentDetails(
            String cardType,
            String cardNumber,
            String month,
            String year,
            String cardHolderName) {

        Select cardDropdown =
                new Select(
                        driver.findElement(
                                cardTypeDropdown));

        cardDropdown.selectByVisibleText(
                cardType);

        driver.findElement(
                creditCardNumber)
                .sendKeys(cardNumber);

        driver.findElement(
                creditCardMonth)
                .clear();

        driver.findElement(
                creditCardMonth)
                .sendKeys(month);

        driver.findElement(
                creditCardYear)
                .clear();

        driver.findElement(
                creditCardYear)
                .sendKeys(year);

        driver.findElement(
                nameOnCard)
                .sendKeys(cardHolderName);
    }

    public void clickPurchaseFlight() {

        driver.findElement(
                purchaseFlightButton)
                .click();
    }
}