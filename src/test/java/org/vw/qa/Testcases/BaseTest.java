package org.vw.qa.Testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.vw.qa.Driver.DriverManager;
import org.vw.qa.Reports.ExtentReportsNew;
import org.vw.qa.Utilities.ReadPropertyFile;

import java.lang.reflect.Method;

public class BaseTest {

    @BeforeMethod
    public void setUp() throws Exception {
        DriverManager.initeDriver ();
    }

    @AfterMethod
    public void teardown( ) {
        DriverManager.quiteDriver();
    }
}
