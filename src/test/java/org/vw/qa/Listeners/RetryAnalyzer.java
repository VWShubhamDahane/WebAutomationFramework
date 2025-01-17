package org.vw.qa.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.vw.qa.Utilities.ReadPropertyFile;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private int retries = 1;


    @Override
    public boolean retry(ITestResult result) {
        boolean value = false;
        try {

            if (ReadPropertyFile.getValue("retryfailedtestcases").equalsIgnoreCase("yes")) {
                value = count < retries;
                count++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
