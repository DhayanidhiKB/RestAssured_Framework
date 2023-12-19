package org.restAssured.tests;

import org.restAssured.reports.ExtentLogger;
import org.restAssured.reports.ExtentReport;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTest {

    @BeforeSuite
    public void setupSuite() {
        ExtentReport.initReports();
    }

    @AfterSuite
    public void teardownSuite() {
        ExtentReport.tearDownReports();
    }

    @BeforeMethod
    public void setup(Method method) {
        ExtentReport.createTest(method.getName());
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        if (!result.isSuccess()) {
            ExtentLogger.fail(String.valueOf(result.getThrowable()));
        }
    }
}
