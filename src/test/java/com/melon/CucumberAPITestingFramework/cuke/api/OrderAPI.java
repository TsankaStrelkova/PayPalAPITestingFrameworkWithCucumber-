package com.melon.CucumberAPITestingFramework.cuke.api;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import com.melon.CucumberAPITestingFramework.cuke.base.BaseTest;
import com.melon.CucumberAPITestingFramework.cuke.pojo.Amount;
import com.melon.CucumberAPITestingFramework.cuke.pojo.Orders;
import com.melon.CucumberAPITestingFramework.cuke.pojo.PurchaseUnit;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OrderAPI extends BaseTest {

	static String access_token;
	static String client_id = "AWO7T6WED1teCFkGwuAe8boPx-urnJc4c7GznyoMLUWWxCYomEAl8fdC6P7TBzGEnboAPZsg2I4eK_mE";
	static String secret = "EKQIDaeBb2MpQDywcdvBpUldTdjkPtYBCQUzGB0HMPPTyolSsv8Chq3YZ903onBvuW8KWjMd7wkfuktd";
	static String orderId;

	public static String getAccessToken() {

		
		Response response = given().param("grant_type","client_credentials")
				.auth().preemptive()
				.basic(client_id,secret)
				.post("https://api.sandbox.paypal.com/v1/oauth2/token");
		response.prettyPrint();
		
		access_token=response.jsonPath().get("access_token").toString();
		
		

		return access_token;

	}
	

	public static Response createOrder(String currency_code, String currency_value) {
		
		ArrayList<PurchaseUnit> list = new ArrayList<PurchaseUnit>();
		list.add(new PurchaseUnit(new Amount(currency_code,currency_value)));
		Orders order = new Orders("CAPTURE",list);
		
		
		String jsonBody ="{\r\n" + 
				"  \"intent\": \"CAPTURE\",\r\n" + 
				"  \"purchase_units\": [\r\n" + 
				"    {\r\n" + 
				"      \"amount\": {\r\n" + 
				"        \"currency_code\": \""+currency_code+"\",\r\n" + 
				"        \"value\": \""+currency_value+"\"\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		System.out.println("JSON BODY: "+jsonBody);	  
		
		Response response = given()
		.contentType(ContentType.JSON)
		.auth().oauth2(access_token)
		// in the body we can use pojo class Order or String jsonBody
		//.body(order)
		.body(jsonBody)
		.post("https://api-m.sandbox.paypal.com/v2/checkout/orders");
		
		System.out.println("createOrder response: ");
		response.prettyPrint();
		
		orderId = response.jsonPath().get("id").toString();
		
		
		return response;
	}
	
	

	public static Response getOrder() {

		System.out.println("Order id is : "+orderId);
		Response response = given()
				.contentType(ContentType.JSON)
				.auth().oauth2(access_token)
				
				.get("https://api-m.sandbox.paypal.com/v2/checkout/orders"+"/"+orderId);
		
		return response;
	}
	
	
}
