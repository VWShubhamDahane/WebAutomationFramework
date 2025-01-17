package org.vw.qa.PageObject;

import org.openqa.selenium.By;
import org.vw.qa.Enum.WaitStrategy;
import org.vw.qa.Reports.ExtentLogger;
import org.vw.qa.Reports.ExtentManager;
import org.vw.qa.Reports.ExtentReportsNew;

public final class OrangeHRMHomePage extends BasePage {
    private final By txtUserName = By.xpath("//input[@placeholder='Username']");
    private final By txtPassword = By.xpath("//input[@placeholder='Password']");
    private final By btnlogin = By.xpath("//button[normalize-space()='Login']");

    public void enterUsername(String username) {
        sendkeys(txtUserName, username, WaitStrategy.CLICKABLE,"Username");
    }

    public void enterPassword(String Password) {
        sendkeys(txtPassword, Password, WaitStrategy.PRESENCE,"Password");

    }

    public void clickLogin() throws Exception {
         click(btnlogin, WaitStrategy.PRESENCE,"LogInButton");
         new OrangeHRMHomePage();
    }
}
