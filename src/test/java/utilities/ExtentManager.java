package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extentReports;

    public static ExtentReports getInstance() {

        if (extentReports == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(
                            "reports/ExtentReport.html");

            sparkReporter.config()
                    .setReportName(
                            "BlazeDemo Automation Report");

            sparkReporter.config()
                    .setDocumentTitle(
                            "Automation Execution Report");

            extentReports =
                    new ExtentReports();

            extentReports.attachReporter(
                    sparkReporter);

            extentReports.setSystemInfo(
                    "Framework",
                    "Selenium TestNG");

            extentReports.setSystemInfo(
                    "Application",
                    "BlazeDemo");
        }

        return extentReports;
    }
}