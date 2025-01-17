package org.vw.qa.Reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public class ExtentManager {
    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

     static ExtentTest getExtentTest() {//Default It can access within package only
            return extTest.get();
    }

     static void setExtentTest(ExtentTest test) {
        if(Objects.nonNull(test)) {
        extTest.set(test);
    }
    }

     static void unload() {

         extTest.remove();
    }

}
