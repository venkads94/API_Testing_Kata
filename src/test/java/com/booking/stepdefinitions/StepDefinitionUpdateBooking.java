package com.booking.stepdefinitions;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;

public class StepDefinitionUpdateBooking extends BaseClass {
	
	//PUT Update Booking Details by Id
	@When("Create payload by passing {string},{string},{string},{string},{string},{string} and call PUT endpoint")
	public void updateBookingById(String firstName, String lastName, String phone, String email, String checkIn, String checkOut) {
		String json = updateBookingPayloadBody(firstName, lastName, phone, email, checkIn, checkOut);
		response = RestAssured.given().cookie("token",authToken).contentType("application/json").when().body(json).put("/booking/"+bookingId);
	}

	//PUT Update Booking Details with missing token - Negative Scenario
	@When("Create payload by passing {string},{string},{string},{string},{string},{string} and call PUT endpoint with empty token")
	public void updateBookingWithMissingToken(String firstName, String lastName, String phone, String email, String checkIn, String checkOut) {
		String json = updateBookingPayloadBody(firstName, lastName, phone, email, checkIn, checkOut);
		response = RestAssured.given().contentType("application/json").when().body(json).put("/booking/"+bookingId);
	}
	@Then("Validate if status code is 401")
	public void validateAuthErrorResponse() {
		response.then().assertThat().statusCode(Matchers.equalTo(401));
		String errorMessage = response.jsonPath().getString("error");
		Assert.assertEquals(errorMessage, "Authentication required");
	}
}
