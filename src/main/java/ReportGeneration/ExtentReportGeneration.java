package ReportGeneration;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import base.BaseTestApi;

public class ExtentReportGeneration extends BaseTestApi {

	public static ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal();
	//public static ExtentTest extenttest;
	public static ExtentSparkReporter extentReporter;

	public static ExtentReports extent;
	// public static ExtentTest extentTestObj;
	static String method;
	static Properties config;

	/*
	 * static { try { FileInputStream FIS = new FileInputStream(
	 * System.getProperty("user.dir") +
	 * "\\src\\test\\resources\\Config.properties"); config = new Properties();
	 * config.load(FIS); } catch (Exception e) { e.printStackTrace(); } }
	 */

	public static ExtentReports generateExtentReports() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy h-m-s-ms");
		Date dateObj = new Date();
		extentReporter = new ExtentSparkReporter(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\ExtentReports\\" + "GripApiTests" + dateFormat.format(dateObj) + ".html");

		extent = new ExtentReports();
		extent.attachReporter(extentReporter);
		extentReporter.config().setDocumentTitle("ExtentReportForGriptTestApi");
		extentReporter.config().setTheme(Theme.STANDARD);
		extentReporter.config().setReportName("LCM Automation Test Execution Report");
		return extent;
	}

	// to call it from every test to add same test in the report

	public static void addTestToReport(String testname) {
		extent.createTest("Test Name", "Test Description");
	}

	public static void addLogStepsToReport(String stepName) {
		getTest().log(Status.INFO, stepName);
	}

	public static void addLogStepsToReportWithScreenshot(String stepName) {
		// extentTestObj.log(Status.INFO, stepName);

		/*
		 * getTest().log(Status.INFO, stepName,
		 * MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		 */
	}

	// ThreadLocal implementation for
	public static void setTestThread(String TestName) {
		ExtentTest extextTestObj = extent.createTest(TestName, "Test Description");
		extentTestThread.set(extextTestObj);
	}

	public static ExtentTest getTest() {
		return extentTestThread.get();
	}

	public static void localExtentTestThreadTearDown() {
		extentTestThread.remove();
	}

//TO generate the extent report with the help of testng interfaces

	public static ExtentTest captureScreenshotOnTestCompletion(int itestresultdigit) {
		// method = testResult.getMethod().getMethodName();
		if (extent == null) {
			// extent = generateExtentReports( testResult);
		}
		if (itestresultdigit == ITestResult.FAILURE) {
			// extentTestObj = extent.createTest(testResult.getMethod().getMethodName(),
			// testResult.getMethod().getDescription());
			// String screenshotPath = TestBase.captureScreenshot(false);

			// getTest().fail("Fail step's Screenshot",
			// MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			// extent.flush();
			getTest().fail("Test Is failed");
		}
		if (itestresultdigit == ITestResult.SUCCESS) {
			// extentTestObj = extent.createTest(testResult.getMethod().getMethodName(),
			// testResult.getMethod().getDescription());
			// extentTestObj.log(Status.PASS, "Test script is passed.");
			// getTest().pass("Pass -- > The test script is successfully completed.",
			// MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			// extent.flush();
			getTest().pass("Pass -- > The test script is successfully completed.");
		}
		return getTest();

	}

	public static void endreport() {
		extent.flush();
	}
}
