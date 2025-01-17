package org.vw.qa.Constant;

import org.vw.qa.Utilities.ReadPropertyFile;

public final class FrameworkContstant {
    private FrameworkContstant() {
    }

    private static final long EXPLICITWAIT = 25;
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output/";
    private static String extentReportFilePath = "";

    public static String getExtentReportFilePath() throws Exception {
        if(extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }
    private static String createReportPath() throws Exception {
        if(ReadPropertyFile.getValue("overridereports").equalsIgnoreCase("no")) {
            return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
        }
        else {
            return EXTENTREPORTFOLDERPATH+"/"+" index.html";
        }
    }
    public static long getExplicitwait() {

        return EXPLICITWAIT;
    }
}
