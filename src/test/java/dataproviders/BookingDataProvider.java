package dataproviders;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtils;

public class BookingDataProvider {

    @DataProvider(name = "passengerData")
    public Object[][] getPassengerData() {

        return ExcelUtils.getTestData("PassengerData");
    }
}