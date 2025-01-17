package org.vw.qa.Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager {

    public static ExtentReports extentReports;
    public static ExtentReports createIntance(String filename, String reportname, String DocumentTitle) {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(filename);
        extentSparkReporter.config().setReportName(reportname);
        extentSparkReporter.config().setDocumentTitle(DocumentTitle);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("utf-8");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;

    }
    public static String getReportNameWithTimeStamp(){
        DateTimeFormatter dateTimeFormatter  = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String formatedTime=dateTimeFormatter.format(localDateTime);
        String reportname = "Test Report"+formatedTime+".html";
        return reportname;
    }
    public static  void logPassDetails(String log){
       setup.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));

    }
    public static  void logFailureDetails(String log){
        setup.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.RED));

    }
    public static  void logInfoDetails(String log){
        setup.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREY));

    }
    public static  void logWarningDetails(String log){
        setup.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.YELLOW));

    }
}



