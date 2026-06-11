package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class CrossBrowserLaunchTest extends BaseTest {

    @Test
    public void verifyApplicationLaunchInDifferentBrowsers() {

        String actualTitle = driver.getTitle();

        System.out.println("Browser Title: " + actualTitle);

        Assert.assertEquals(actualTitle, "BlazeDemo");
    }
}