package org.vw.qa.Utils;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.vw.qa.Reporting.ExtentReportManager;

import java.util.Map;

import static io.restassured.config.RestAssuredConfig.config;

public class RestUtils {  
	
	
	private static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload, Map<String,String>headers) {
    return RestAssured.given()
            .baseUri(endPoint)
            .headers(headers)
            .contentType(ContentType.JSON)
            .body(requestPayload);
}


    private static void printRequestLogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint :- " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method :- " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Request Headers are ");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Request body is ");
       ExtentReportManager.logJson(queryableRequestSpecification.getBody());

    }
    
    private static void printResponseLogInReport(Response response) {
        ExtentReportManager.logInfoDetails("Response status code is :-  " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Response body is :- ");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }
    
    public static Response performPostnew(String endpoint, String payload, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endpoint, payload, headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }
    public static Response performPost(String endPoint, Map<String, Object> requestPayload, Map<String,String>headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
        Response response =  requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    public static Response performPost(String endPoint, Object requestPayloadAsPojo, Map<String,String>headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayloadAsPojo, headers);
        Response response =  requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }


}