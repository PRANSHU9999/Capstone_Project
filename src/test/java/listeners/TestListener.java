package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.DriverFactory;
import utilities.ExtentManager;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static ExtentReports extentReports =
            ExtentManager.getInstance();

    private static ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {

        extentTest =
                extentReports.createTest(
                        result.getName());

        System.out.println(
                "STARTED : "
                        + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.pass(
                "Test Passed");

        System.out.println(
                "PASSED : "
                        + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String screenshotPath =
                ScreenshotUtil.captureScreenshot(
                        DriverFactory.getDriver(),
                        result.getName());

        extentTest.fail(result.getThrowable());

        extentTest.addScreenCaptureFromPath(
                screenshotPath);
    }

    @Override
    public void onStart(ITestContext context) {

        System.out.println(
                "TEST EXECUTION STARTED");
    }

    @Override
    public void onFinish(ITestContext context) {

        extentReports.flush();

        System.out.println(
                "TEST EXECUTION FINISHED");
    }
}