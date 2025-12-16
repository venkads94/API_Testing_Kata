package com.booking.stepdefinitions;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;

public class StepDefinitionUpdateBooking extends BaseClass {
	
	public String json;
	
	//PUT Update Booking Details by Id - Positive Scenario
	@Given("Create request payload by passing {string},{string},{string},{string},{string},{string} to update booking")
	public void createPayloadForUpdateBooking(String firstName, String lastName, String phone, String email, String checkIn, String checkOut) {
		 json = updateBookingPayloadBody(firstName, lastName, phone, email, checkIn, checkOut);
		response = RestAssured.given().cookie("token",authToken).contentType("application/json").when().body(json).put("/booking/"+bookingId);
	}
	@When("Call PUT method to update booking")
	public void hitUpdateBooking() {
		response = RestAssured.given().cookie("token",authToken).contentType("application/json").when().body(json).put("/booking/"+bookingId);
	}
	@Then("Validate if update response code is 200")
	public void validateUpdateResponseCode() {
		response.then().assertThat().statusCode(Matchers.equalTo(200));
	}

	//PUT Update Booking Details with missing token - Negative Scenario
	@When("Call PUT method to update booking with missing token")
	public void hitUpdateBookingWithMissingToken() {
		response = RestAssured.given().contentType("application/json").when().body(json).put("/booking/"+bookingId);
	}
	@Then("Validate if update response code with missing token is 401")
	public void validateAuthErrorResponseForMissingToken() {
		response.then().assertThat().statusCode(Matchers.equalTo(401));
	}
	@And("Validate the error response message for missing token")
	public void validateUpdateBookingMissingTokenErrorMessage() {
		String errorMessage = response.jsonPath().getString("error");
		Assert.assertEquals(errorMessage, "Authentication required");
	}
	
	//PUT Update Booking Details with invalid token - Negative Scenario
		@When("Call PUT method to update booking with invalid token")
		public void hitUpdateBookingWithInvalidToken() {
			response = RestAssured.given().cookie("token","123abc456").contentType("application/json").when().body(json).put("/booking/"+bookingId);
		}
		@Then("Validate if update response code with invalid token is 401")
		public void validateAuthErrorResponseForInvalidToken() {
			response.then().assertThat().statusCode(Matchers.equalTo(401));
		}
		@And("Validate the error response message for invalid token")
		public void validateUpdateBookingInvalidTokenErrorMessage() {
			String errorMessage = response.jsonPath().getString("error");
			Assert.assertEquals(errorMessage, "Failed to update booking");
		}
}
