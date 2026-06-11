package defecttests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ConfirmationPage;
import pages.FlightSelectionPage;
import pages.HomePage;
import pages.PurchasePage;

public class EmptyPassengerDetailsTest extends BaseTest {

    @Test
    public void verifyBookingWithEmptyPassengerDetails() {

        HomePage homePage =
                new HomePage(driver);

        homePage.searchFlight(
                "Paris",
                "Cairo");

        FlightSelectionPage flightPage =
                new FlightSelectionPage(driver);

        flightPage.chooseFirstFlight();

        PurchasePage purchasePage =
                new PurchasePage(driver);

        purchasePage.enterPassengerDetails(
                "",
                "",
                "",
                "",
                "");

        purchasePage.enterPaymentDetails(
                "Visa",
                "4111111111111111",
                "11",
                "2028",
                "Test User");

        purchasePage.clickPurchaseFlight();

        ConfirmationPage confirmationPage =
                new ConfirmationPage(driver);

        Assert.assertTrue(
                confirmationPage
                        .getConfirmationMessage()
                        .contains("Thank you"));

        System.out.println(
                "DEFECT FOUND : Booking allowed with empty passenger details");
    }
}