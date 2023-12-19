package org.restAssured.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {

    private ExtentReport() {
    }

    private static ExtentReports extent;
    private static ExtentTest test;  //thread safe --> ThreadLocal

    public static ExtentTest getTest() {
        return test;
    }

    public static void setTest(ExtentTest test) {
        ExtentReport.test = test;
    }


    public static void initReports() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
        extent.attachReporter(spark);

    }

    public static void tearDownReports() {
        extent.flush();
    }

    public static void createTest(String name) {
        test = extent.createTest(name);
    }
}
