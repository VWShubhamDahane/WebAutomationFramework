package apitests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Data {
	
	
	public static void main(String[] args) {
		RestAssured.proxy("127.0.0.1", 9000);
        // Specify the base URL
        RestAssured.baseURI = "https://gcp.oneapi.volkswagen.com";

            // Send a GET request without a RequestSpecification
            Response response = RestAssured.given()
            			.contentType(ContentType.JSON)
					.header("x-api-key", "bloqbAHdDeiHZMxBS0WX5zUqM5lTJXA3")
                    .when()
                    .get("/viso/catalogue/models/overview?tenant=ihdcc-vw-gb-en");

            // Print the status code
            int statusCode = response.getStatusCode();
            System.out.println("Status Code : " + statusCode);

            // Print the response body
            //String responseBody = response.getBody().asPrettyString();
           // System.out.println("Response Body: " + responseBody);
    }
}
