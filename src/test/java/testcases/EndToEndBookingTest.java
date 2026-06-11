package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataproviders.BookingDataProvider;
import pages.ConfirmationPage;
import pages.FlightSelectionPage;
import pages.HomePage;
import pages.PurchasePage;

public class EndToEndBookingTest extends BaseTest {

    @Test(
            dataProvider = "passengerData",
            dataProviderClass = BookingDataProvider.class)
    public void verifyCompleteBookingFlow(
            String fromCity,
            String toCity,
            String name,
            String address,
            String city,
            String state,
            String zipCode,
            String cardType,
            String cardNumber,
            String month,
            String year,
            String nameOnCard) {

        HomePage homePage =
                new HomePage(driver);

        homePage.searchFlight(fromCity, toCity);

        FlightSelectionPage flightPage =
                new FlightSelectionPage(driver);

        Assert.assertTrue(
                flightPage.isFlightListDisplayed(),
                "Flight list is not displayed");

        flightPage.chooseFirstFlight();

        PurchasePage purchasePage =
                new PurchasePage(driver);

        String purchaseTitle =
                purchasePage.getPurchasePageTitle();

        System.out.println(
                "Purchase Page Title : "
                        + purchaseTitle);

        Assert.assertTrue(
                purchaseTitle.contains(
                        "Your flight"),
                "Purchase Flight page not displayed");

        Assert.assertTrue(
                purchasePage.isAirlineDisplayed(),
                "Airline information not displayed");

        Assert.assertTrue(
                purchasePage.isTotalCostDisplayed(),
                "Price information not displayed");

        purchasePage.enterPassengerDetails(
                name,
                address,
                city,
                state,
                zipCode);

        purchasePage.enterPaymentDetails(
                cardType,
                cardNumber,
                month,
                year,
                nameOnCard);

        purchasePage.clickPurchaseFlight();

        ConfirmationPage confirmationPage =
                new ConfirmationPage(driver);

        String actualMessage =
                confirmationPage.getConfirmationMessage();

        String bookingId =
                confirmationPage.getBookingId();

        String bookingStatus =
                confirmationPage.getBookingStatus();

        String bookingAmount =
                confirmationPage.getBookingAmount();
        
        System.out.println(
                "Route : "
                        + fromCity
                        + " -> "
                        + toCity);

        System.out.println(
                "Passenger : "
                        + name);

        System.out.println(
                "Confirmation Message : "
                        + actualMessage);

        System.out.println(
                "Booking ID : "
                        + bookingId);

        System.out.println(
                "Booking Status : "
                        + bookingStatus);

        System.out.println(
                "Booking Amount : "
                        + bookingAmount);

        Assert.assertTrue(
                actualMessage.contains(
                        "Thank you"),
                "Booking confirmation failed");

        Assert.assertFalse(
                bookingId.isEmpty(),
                "Booking ID not generated");

        Assert.assertEquals(
                bookingStatus,
                "PendingCapture",
                "Incorrect booking status");

        Assert.assertTrue(
                bookingAmount.contains(
                        "USD"),
                "Booking amount not displayed");
    }
}