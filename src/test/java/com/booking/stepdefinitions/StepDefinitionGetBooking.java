package com.booking.stepdefinitions;

import org.hamcrest.Matchers;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;

public class StepDefinitionGetBooking extends BaseClass {

	//GET Booking by Id - Positive
	@When("Call Get Booking Details by passing booking id")
	public void getBookinById() {
		response = RestAssured.given().cookie("token",authToken).when().get("/booking/"+bookingId);
	}
	@Then("Validate if status code is 200")
	public void validateGetResponseCode() {
		response.then().assertThat().statusCode(Matchers.equalTo(200));
	}
	
	//GET Booking by Id - Negative
	@When("Call Get Booking Details by passing invalid token")
	public void getBookingByInvalidToken() {
		response = RestAssured.given().cookie("token", "123abc456").when().get("/booking/"+bookingId);
	}
	@Then("Validate if status code is 403")
	public void validateStatusCodeForInvalidToken() {
		response.then().assertThat().statusCode(Matchers.equalTo(403));
	}
}
