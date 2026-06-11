package defecttests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ConfirmationPage;
import pages.FlightSelectionPage;
import pages.HomePage;
import pages.PurchasePage;

public class EmptyCardNumberTest extends BaseTest {

    @Test
    public void verifyBookingWithEmptyCardNumber() {

        HomePage homePage =
                new HomePage(driver);

        homePage.searchFlight(
                "Paris",
                "London");

        FlightSelectionPage flightPage =
                new FlightSelectionPage(driver);

        flightPage.chooseFirstFlight();

        PurchasePage purchasePage =
                new PurchasePage(driver);

        purchasePage.enterPassengerDetails(
                "Pranshu",
                "ABC Street",
                "Varanasi",
                "UP",
                "221001");

        purchasePage.enterPaymentDetails(
                "Visa",
                "",
                "11",
                "2028",
                "Pranshu Mishra");

        purchasePage.clickPurchaseFlight();

        ConfirmationPage confirmationPage =
                new ConfirmationPage(driver);

        Assert.assertTrue(
                confirmationPage
                        .getConfirmationMessage()
                        .contains("Thank you"));

        System.out.println(
                "DEFECT FOUND : Booking allowed with empty card number");
    }
}