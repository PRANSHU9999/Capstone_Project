package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FlightSelectionPage;
import pages.HomePage;

public class SearchFlightTest extends BaseTest {

    @Test
    public void verifyFlightSearch() {

        HomePage homePage = new HomePage(driver);

        homePage.searchFlight("Paris","London");

        String currentUrl = driver.getCurrentUrl();

        System.out.println(currentUrl);

        Assert.assertTrue(currentUrl.contains("reserve"));
    }
}