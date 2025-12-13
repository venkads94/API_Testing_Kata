package com.booking.stepdefinitions;

import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;

public class StepDefinitionCreateBooking extends BaseClass {
	
	String requestPayload;
	String fName,lName,phoneNum,emailId,checkInDate,checkOutDate;
	String errorMsg;
	
	//POST Create Booking
	@When("Create payload by passing {string},{string},{string},{string},{string},{string} and call POST call")
	public void createBooking(String firstName, String lastName, String phone, String email, String checkIn, String checkOut) {
		
		fName=firstName;
		lName=lastName;
		phoneNum=phone;
		emailId=email;
		checkInDate=checkIn;
		checkOutDate=checkOut;
		
		String requestPayload = createRequestPayloadBody(firstName,lastName,phone,email,checkIn,checkOut);
		System.out.println(requestPayload);
		inputRequest = RestAssured.given().cookie(authToken).when().body(requestPayload);
		response = inputRequest.post("/booking");
	}
	
	@Then("Validate if status code is 201")
	public void validateStatusCode() {
		response.then().assertThat().statusCode(Matchers.equalTo(201));
	}
	
	//POST Create Booking - Negative Scenario
	@When("Create payload by passing {string},{string},{string},{string},{string},{string} and call POST call for Negative Scenario")
	public void createBookingNegativeScenario(String firstName, String lastName, String phone, String email, String checkIn, String checkOut) {
		
		fName=firstName;
		lName=lastName;
		phoneNum=phone;
		emailId=email;
		checkInDate=checkIn;
		checkOutDate=checkOut;
		
		String requestPayload = createRequestPayloadBody(firstName,lastName,phone,email,checkIn,checkOut);
		System.out.println(requestPayload);
		inputRequest = RestAssured.given().cookie(authToken).when().body(requestPayload);
		response = inputRequest.post("/booking");
	}
	@Then("Validate if status code is 400")
	public void validateStatusCodeNegativeScenario() {
		response.then().assertThat().statusCode(Matchers.equalTo(400));
		errorMsg = response.jsonPath().getString("errors");
	}
	
	@And("Validate the error response message")
	public void validateErrorMessage() {
		if(fName.length()<3 || fName.length()>18) {
			Assert.assertEquals(errorMsg,"[size must be between 3 and 18]");
		}
		
	}
}






