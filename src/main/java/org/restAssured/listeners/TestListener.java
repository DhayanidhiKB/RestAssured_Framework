package org.restAssured.listeners;

import org.restAssured.reports.ExtentLogger;
import org.restAssured.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.tearDownReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.fail(result.getName() + "is pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(String.valueOf(result.getThrowable()));
    }

}
