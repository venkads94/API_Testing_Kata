package com.booking.stepdefinitions;

import org.hamcrest.Matchers;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;

public class StepDefinitionForDeleteBooking extends BaseClass{
	
	//Positive Scenario
	@When("Call Delete Booking Details by passing booking id")
	public void deleteBookingByID() {
		response = RestAssured.given().cookie("token",authToken).when().delete("/booking/"+bookingId);
	}
	@Then("Validate if delete status code is 201")
	public void validateDeleteStatusCode() {
		response.then().assertThat().statusCode(Matchers.equalTo(200));
	}
	
	// Delete Booking missing token- Negative
	@When("Call Delete Booking Details with missing token")
	public void deleteBookingWithMissingToken() {
		response = RestAssured.given().when().delete("/booking/" + bookingId);
	}

	@Then("Validate if delete status code for missing token is 401")
	public void validateDeleteStatusCodeForMissingToken() {
		response.then().assertThat().statusCode(Matchers.equalTo(401));
	}
	
	// Delete Booking with invalid token- Negative
	@When("Call Delete Booking Details with invalid token")
	public void deleteBookingByInvalidToken() {
		response = RestAssured.given().cookie("token", "123abc456").when().delete("/booking/" + bookingId);
	}
	
	@Then("Validate if delete status code for invalid token is 401")
	public void validateDeleteStatusCodeForInvalidToken() {
		response.then().assertThat().statusCode(Matchers.equalTo(401));
	}
}
