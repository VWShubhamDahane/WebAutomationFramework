package org.vw.qa.PageObject;

import org.openqa.selenium.By;
import org.vw.qa.Enum.WaitStrategy;

public final class LoginHomePage extends BasePage {
    private final By signInLocally = By.xpath("//coral-accordion-item-label[contains(.,'Sign in locally (admin tasks only)')]");
    private final By txtUsername = By.xpath("//input[@id='username']");
    private final By txtPassword = By.xpath("//input[@id='password']");

    private final By btnsignIn = By.xpath("//button[@id='submit-button']");

    public void enterUsername(String username) {

        sendkeys(txtUsername, username, WaitStrategy.PRESENCE,"Username");
    }

    public void enterPassword(String Password) {
        sendkeys(txtPassword, Password, WaitStrategy.PRESENCE,"Password");

    }

    public void signInLocally() throws Exception {
         click(signInLocally, WaitStrategy.PRESENCE,"signInLocally");

    }
    public void clickonSignIn() throws Exception {
        click(btnsignIn, WaitStrategy.PRESENCE,"btnsignIn");

    }
}
