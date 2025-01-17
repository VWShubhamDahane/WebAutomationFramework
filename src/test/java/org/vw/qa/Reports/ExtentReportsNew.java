package org.vw.qa.Reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.vw.qa.Constant.FrameworkContstant;

public   final class ExtentReportsNew {

	private ExtentReportsNew(){

	}

	public static ExtentReports extent;

//Reporting setup code  
public static void initReports() throws Exception {
	if(Objects.isNull(extent)) {
	extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkContstant.getExtentReportFilePath());
	extent.attachReporter(spark);
	spark.config().setTheme(Theme.STANDARD);
	spark.config().setDocumentTitle("Web Automation Report");
	spark.config().setReportName("Web Automation Report");
	}
}
//TearDown 
public static void flushReports() {
	if (Objects.nonNull(extent)) {	
	extent.flush();
	try {
		Desktop.getDesktop().browse(new File(FrameworkContstant.getExtentReportFilePath()).toURI());
	} catch (IOException e) {
				e.printStackTrace();
	} catch (Exception e) {
        throw new RuntimeException(e);
    }
    }
	

}
public static void createTest(String testCaseName) {
	ExtentTest test = extent.createTest(testCaseName);
	ExtentManager.setExtentTest(test);
}
}
