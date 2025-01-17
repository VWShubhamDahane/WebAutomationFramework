package org.vw.qa.Testcases;

import org.testng.annotations.Test;
import org.vw.qa.Driver.DriverManager;
import org.vw.qa.PageObject.OrangeHRMHomePage;
import org.vw.qa.Reports.ExtentManager;
import org.vw.qa.Reports.ExtentReportsNew;

public class OrangeHRMLoginTest extends BaseTest {

    private OrangeHRMLoginTest() {
    	 

    }

    @Test
    public void loginTest() throws Exception {
       OrangeHRMHomePage HomePage = new OrangeHRMHomePage();
        HomePage.enterUsername("Admin");
        HomePage.enterPassword("admin123");
        HomePage.clickLogin();
        String titileString=DriverManager.getDriver().getTitle();
        System.out.println(titileString);
    }

    //@Test
    public void loginTestA() throws Exception {
       OrangeHRMHomePage HomePage = new OrangeHRMHomePage();
        HomePage.enterUsername("Admin");
        HomePage.enterPassword("qadmin123");
        HomePage.clickLogin();
    }

  // @Test
    public void loginTestB() throws Exception {
        OrangeHRMHomePage HomePage = new OrangeHRMHomePage();
        HomePage.enterUsername("AAdmin");
        HomePage.enterPassword("admin123");
        HomePage.clickLogin();
    }

}
