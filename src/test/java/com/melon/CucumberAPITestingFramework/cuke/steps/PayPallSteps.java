package com.melon.CucumberAPITestingFramework.cuke.steps;

import com.melon.CucumberAPITestingFramework.cuke.base.BaseTest;

import org.testng.Assert;

import com.melon.CucumberAPITestingFramework.cuke.api.OrderAPI;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PayPallSteps {
	
	

	@Before
	public void setUp() {

		BaseTest.init();

	}

	@Given("I got access token form PayPal api")
	public void i_got_access_token_form_pay_pal_api() {
		OrderAPI.getAccessToken();

	}

	@When("I set currency code as {string} and value is {string}")
	public void i_set_currency_code_as_and_value_is(String currencyCode, String currencyValue) {
		System.out.println("Currency code: "+currencyCode +"Currency value: "+currencyValue);
		BaseTest.response = OrderAPI.createOrder(currencyCode,currencyValue);
		System.out.println("Response of I set currency code and value is:");
		BaseTest.response.prettyPrint();
	
	}

	@Then("I verify the status as CREATED")
	public void i_verify_the_status_as_created() {
		Assert.assertEquals(BaseTest.response.jsonPath().get("status"), "CREATED", "Status is not CREATED");

	}
	
	@When("I get order from Paypal api")
	public void i_get_order_from_Paypal_api(){
		BaseTest.response=OrderAPI.getOrder();
		System.out.println("Response of Get order is:");
		BaseTest.response.prettyPrint();
	}

	@Then("I verify the {string}")
	public void i_verify_the(String status_code) {
		String statusFromResponse = String.valueOf(BaseTest.response.getStatusCode());
		Assert.assertEquals(statusFromResponse,status_code);    
	}

	

}