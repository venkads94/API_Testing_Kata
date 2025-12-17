package com.booking.stepdefinitions;

import org.hamcrest.Matchers;
import org.testng.Assert;

import com.booking.config.BaseClass;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import java.sql.Date;

public class StepDefinitionCreateBooking extends BaseClass {

	public String requestPayload;
	public String fName, lName, phoneNum, emailId, checkInDate, checkOutDate;

	// POST Create Booking - Positive Scenario
	@When("Create request payload by passing {string},{string},{string},{string},{string},{string}")
	public void createRequestPayloadForCreateBooking(String firstName, String lastName, String phone, String email, String checkIn,
			String checkOut) {

		fName = firstName;
		lName = lastName;
		phoneNum = phone;
		emailId = email;
		checkInDate = checkIn;
		checkOutDate = checkOut;

		requestPayload = createRequestPayloadBody(firstName, lastName, phone, email, checkIn, checkOut);
	}
	
	@When("Call POST method for create booking")
	public void hitCreateBooking() {
		inputRequest = RestAssured.given().cookie("token",authToken).when().body(requestPayload);
		response = inputRequest.post("/booking");
	}
	
	@Then("Check if status code is 201")
	public void validateStatusCode() {
		response.then().assertThat().statusCode(Matchers.equalTo(201));
		bookingId = response.jsonPath().getInt("bookingid");
	}

	// POST Create Booking - Negative Scenario
	@Then("Check if status code is 400")
	public void validateStatusCodeNegativeScenario() {
		response.then().assertThat().statusCode(Matchers.equalTo(400));
		errorMsg = response.jsonPath().getString("errors");
	}

	@And("Validate the error response message")
	public void validateErrorMessage() {
		if (fName.length() < 3 || fName.length() > 18) {
			Assert.assertEquals(errorMsg, "[size must be between 3 and 18]");
		}
		if (!emailId.contains("@")) {
			Assert.assertEquals(errorMsg, "[must be a well-formed email address]");
		}
		if (phoneNum.length() < 11 || phoneNum.length() > 21) {
			Assert.assertEquals(errorMsg, "[size must be between 11 and 21]");
		}
		
		Date inDate = Date.valueOf(checkInDate);
		Date outDate = Date.valueOf(checkOutDate);
		if(inDate.after(outDate)) {
			Assert.assertEquals(errorMsg, "[Failed to create booking]");
		}
		
	}	
}
