package org.vw.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

import org.vw.qa.ResuestPayload.Payload;
import org.vw.qa.Utils.ReadPropertyFile;
import org.vw.qa.Utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class RestTest {
	@Test
    public void createAirline() throws Exception{
       RestAssured.proxy("127.0.0.1", 9000);
        String Endpoint=ReadPropertyFile.getValue("BaseUrl_prod");        
        //Using String
   //  String payload= Payload.getCreateAirlinePayloadFromString("1223456767","Shubham Airways","fg","https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
      //       "From Sri Lanka","From Sri Lanka","www.srilankaaairways.com","1998");
        //--Using Map
        Map<String, Object> payload=Payload.getCreateAirlinePayloadFromMap("12237","Shubham Airways","fg","https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
        	           "From Sri Lanka","From Sri Lanka","www.srilankaaairways.com","1998");
     Response response = RestUtils.performPost(Endpoint,payload,new HashMap<>());
    Assert.assertEquals(response.statusCode(),200);

    }

   //@Test
    public void getCompanyConsumers() throws Exception {
        Response response = RestUtils.performPostnew("https://mule-t.vw-group.com/gcmp/leanix/papi/v1/get-company-consumers","", new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println(response.getBody().asPrettyString());
        System.out.println(response.getStatusCode());
    }


    //@Test
    public void test2() {
        RestAssured.proxy("127.0.0.1", 9000);
        RestAssuredConfig sslConfig = RestAssuredConfig.config().sslConfig(
                SSLConfig.sslConfig()
                        .keyStore(System.getProperty("user.dir") +"\\Systemuser_LEANIX-GRIP-QS_VWPKI_482CF3BD8BFC5398_normalized.p12", "91791898")
                        .keystoreType("PKCS12")
                        .relaxedHTTPSValidation());
        Response response = RestAssured.given().config(sslConfig).when()
                .post("https://mule-t.vw-group.com/gcmp/leanix/papi/v1/get-company-consumers").then().extract()
                .response();
        System.out.println(response.getBody().asPrettyString());
        System.out.println(response.getStatusCode());

    }

}