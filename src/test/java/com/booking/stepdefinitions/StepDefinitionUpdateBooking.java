package com.booking.stepdefinitions;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;

public class StepDefinitionUpdateBooking extends BaseClass {
	
	//GET Booking by Id - Positive
	@When("Call Get Booking Details by passing booking id")
	public void getBookinBgyId() {
		response = RestAssured.given().cookie("token",authToken).when().get("/booking/"+bookingId);
	}
	@Then("Validate if status code is 200")
	public void validateGetResponseCode() {
		response.then().assertThat().statusCode(Matchers.equalTo(200));
	}
	//GET Booking by Id - Negative
	@When("Call Get Booking Details by passing invalid token")
	public void getBookingByInvalidToken() {
		response = RestAssured.given().cookie("token", "12SDS223").when().get("/booking/"+bookingId);
	}
	@Then("Validate if status code is 403")
	public void validateStatusCodeForInvalidToken() {
		response.then().assertThat().statusCode(Matchers.equalTo(403));
	}
	//PUT Update Booking Details by Id
	@When("Create payload by passing {string},{string},{string},{string},{string},{string} and call PUT endpoint")
	public void updateBookingById(String firstName, String lastName, String phone, String email, String checkIn, String checkOut) {
		String json = "{"
	            + "\"roomid\":900,"
	            + "\"depositpaid\":true,"
	            + "\"firstname\":\""+firstName+"\","
	            + "\"lastname\":\""+lastName+"\","
	            + "\"email\":\""+email+"\","
	            + "\"phone\":\"90955567378212\","
	            + "\"bookingdates\":{"
	            + "\"checkin\":\""+checkIn+"\","
	            + "\"checkout\":\""+checkOut+"\""
	            + "}"
	            + "}";
		System.out.println("PUT payload:"+json);
		response = RestAssured.given().cookie("token",authToken).contentType("application/json").when().body(json).put("/booking/"+bookingId);
	}
}
