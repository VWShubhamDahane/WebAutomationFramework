package org.vw.qa.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.vw.qa.Utilities.ReadPropertyFile;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DriverManager {

	private static ThreadLocal<WebDriver> drLocal = new ThreadLocal<>();

	public static WebDriver getDriver() {

		return drLocal.get();
	}

	public static void setDriver(WebDriver driverref) {
		drLocal.set(driverref);
	}

	public static void unload() {

		drLocal.remove();
	}

	public static void initeDriver() throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
			
				DriverManager.setDriver(new ChromeDriver());


			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			try {

				DriverManager.getDriver().get(ReadPropertyFile.getValue("url"));
				System.out.println("URL");

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}

	public static void quiteDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();// set driver is null

		}
	}
}
