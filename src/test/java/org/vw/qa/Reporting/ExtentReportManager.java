package org.vw.qa.Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.http.Header;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
        setup.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));

    }
    public static void logExceptionDetails(String log) {
        setup.extentTest.get().fail(log);
    }
    public static void logIncollapsExpand(String log) {
        setup.extentTest.get().info(log);
    }
    public static  void logInfoDetails(String log){
        setup.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));

    }
    public static  void logWarningDetails(String log){
        setup.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));

    }
    public static void logJson(String json) {    	
        String jsonString = json.toString();   
      String  stackTrace = jsonString.replaceAll(",", "<br>");
                String formmatedResponse = "<details>\n" +
                        "    <summary>Click Here To See the Json Response</summary>\n" +
                        "    " + stackTrace + "\n" +
                        "</details>\n";
                ExtentReportManager.logIncollapsExpand(formmatedResponse);
             
        //setup.extentTest.get().info(MarkupHelper.createCodeBlock(jsonString, CodeLanguage.JSON));

    }
    public static void logHeaders(List<Header> headersList) {

        String[][] arrayHeaders = headersList.stream().map(header -> new String[] {header.getName(), header.getValue()})
                        .toArray(String[][] :: new);
        setup.extentTest.get().info(MarkupHelper.createTable(arrayHeaders));
    }
}



