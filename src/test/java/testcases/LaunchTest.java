package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class LaunchTest extends BaseTest {

    @Test
    public void verifyApplicationLaunch() {

        String actualTitle = driver.getTitle();

        System.out.println("Page Title: " + actualTitle);

        Assert.assertFalse(actualTitle.isEmpty());
    }
}