package com.booking.stepdefinitions;

import java.util.Map;

import org.hamcrest.Matchers;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;

public class StepDefinitionCreateBooking extends BaseClass {
	
	@Given("Build request payload {string},{string},{string},{string},{string},{string} and hit create booking endpoint")
	public void postCreateBooking(String firstname, String lastname, String phone, String email, String checkin, String checkout) {
		  Map createdRequestPayloadBody = new BaseClass().createRequestPayloadBody(firstname,lastname,phone,email,checkin,checkout);
		  StepDefinitionForAuthToken.inputRequest = RestAssured.given().cookie(StepDefinitionForAuthToken.authToken).when().body(createdRequestPayloadBody);
		  StepDefinitionForAuthToken.response = StepDefinitionForAuthToken.inputRequest.post("/booking");
		  StepDefinitionForAuthToken.response.then().assertThat().statusCode(Matchers.equalTo(200));
		  
	}
}
