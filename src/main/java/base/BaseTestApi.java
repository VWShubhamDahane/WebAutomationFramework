package base;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.reporter.FileUtil;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;

public class BaseTestApi {
	
	final String baseURL = "";
	final String proxyIP = "";
	final int proxyportnumber = 0;

	public static String setURI() {
		RestAssured.proxy("127.0.0.1", 9000);
		RestAssured.baseURI = "https://reqres.in/";
		return RestAssured.baseURI;

	}
	
	public static RestAssuredConfig setUpGrip() {
		
		RestAssured.proxy("127.0.0.1", 9000);

		RestAssuredConfig sslConfig = RestAssuredConfig.config().sslConfig(
                SSLConfig.sslConfig()
                        .keyStore("C:\\Users\\UMB87X7\\Eclipse-Workspace New\\apitests\\Systemuser_LEANIX-GRIP-QS_VWPKI_482CF3BD8BFC5398_normalized.p12", "91791898")
                        .keystoreType("PKCS12")
                        .relaxedHTTPSValidation());

		return sslConfig;
	}
	
}
