package org.vw.qa.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.vw.qa.Driver.DriverManager;
import org.vw.qa.Enum.WaitStrategy;
import org.vw.qa.Factories.ExplicitWaitFactory;
import org.vw.qa.Reports.ExtentLogger;

public class BasePage {


	protected void click(By by, WaitStrategy waitStrategy, String elementName) throws Exception {
	 WebElement element=	ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		try {
			ExtentLogger.pass(elementName+ " is Click  Successfully",true);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			ExtentLogger.fail(elementName+ " is not click  Successfully",true);
		}
	}

	protected void sendkeys(By by, String value, WaitStrategy waitStrategy,String elementName) {
		 WebElement element=ExplicitWaitFactory.performExplicitWait(waitStrategy, by);

		try {
			element.sendKeys(value);
			ExtentLogger.pass(value + " is Enter Successfully in  ["+elementName+"]  text box",true);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getTitle() {

		return DriverManager.getDriver().getTitle();
	}

	

}
