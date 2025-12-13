package com.booking.stepdefinitions;

import org.hamcrest.Matchers;
import org.testng.Assert;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinitionForAuthToken extends BaseClass {
	
	//GET Health Check
	@When("Call Health Check endpoint")
	public void healthCheck() {
		response = RestAssured.get("/booking/actuator/health");
	}
	@Then("Status should be UP")
	public void checkHealthCheckStatus() {
		String status = response.jsonPath().getString("status");
		Assert.assertEquals(status, "UP");
	}
	
	//POST Get Auth Token Positive Case
	@When("Call Auth Token call by passing {string} and {string}")
	public void getAuthToken(String uname, String pwd) {
		String requestBody = "{"
                + "\"username\":\"" + uname + "\","
                + "\"password\":\"" + pwd + "\""
                + "}";
		System.out.println(requestBody);
		inputRequest = RestAssured.given().contentType("application/json").when().body(requestBody);
		response = inputRequest.post("/auth/login");
	}
	@Then("Save the token created and check if status code is 200")
	public void assertResponseForAuthToken() {
		response.then().assertThat().statusCode(Matchers.equalTo(200));
		authToken = response.jsonPath().getString("token");
	}
	//POST Get Auth Token Negative Case
	@Then("Check if status code is 401")
	public void assertUnauthorizedResponseCode() {
		response.then().assertThat().statusCode(Matchers.equalTo(401));
		String errorMsg = response.jsonPath().getString("error");
		Assert.assertEquals(errorMsg, "Invalid credentials");
	}
}