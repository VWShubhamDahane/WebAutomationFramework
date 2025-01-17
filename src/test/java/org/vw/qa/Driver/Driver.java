package org.vw.qa.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.vw.qa.Utilities.ReadPropertyFile;

import java.time.Duration;
import java.util.Objects;

public class Driver {

public static WebDriver driver;

    public static void initdriver() throws Exception {
        if (Objects.isNull(DriverManager.getDriver())) {
            driver = new EdgeDriver();
            DriverManager.setDriver(driver);
            DriverManager.getDriver().get(ReadPropertyFile.getValue("url"));
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            DriverManager.getDriver().manage().window().maximize();
        }

    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }

    }
}
