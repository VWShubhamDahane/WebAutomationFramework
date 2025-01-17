package org.vw.qa.Factories;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.vw.qa.Constant.FrameworkContstant;
import org.vw.qa.Driver.DriverManager;
import org.vw.qa.Enum.WaitStrategy;


public class ExplicitWaitFactory {

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {
        WebElement element = null;
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameworkContstant.getExplicitwait()))
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverManager.getDriver(),
                    Duration.ofSeconds(FrameworkContstant.getExplicitwait()))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            element = new WebDriverWait(DriverManager.getDriver(),
                    Duration.ofSeconds(FrameworkContstant.getExplicitwait()))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.NONE) {
            element = DriverManager.getDriver().findElement(by);
        }
        return element;
    }
}
