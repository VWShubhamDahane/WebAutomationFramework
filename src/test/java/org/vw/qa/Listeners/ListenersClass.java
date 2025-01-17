package org.vw.qa.Listeners;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.vw.qa.Reports.ExtentLogger;
import org.vw.qa.Reports.ExtentReportsNew;

import java.util.Arrays;

public class ListenersClass implements ITestListener, ISuiteListener {

    @Override
    public void onTestStart(ITestResult result) {

        ExtentReportsNew.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
                try {
            ExtentLogger.pass(result.getMethod().getMethodName() + " is Pass    ", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

        //ExtentLogger.fail(result.getMethod().getMethodName() + " is failed");
        //Attached ScreenShot
        try {
            ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
            ExtentLogger.fail(result.getThrowable().toString());
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        try {
            ExtentReportsNew.initReports();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportsNew.flushReports();
    }

}
