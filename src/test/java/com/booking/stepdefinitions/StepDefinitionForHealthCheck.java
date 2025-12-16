package com.booking.stepdefinitions;
import org.testng.Assert;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;

public class StepDefinitionForHealthCheck extends BaseClass{
	
	//Perform HealthCheck
	@Given("Call Healthcheck API")
	public void healthCheck() {
		response = RestAssured.get("/booking/actuator/health");
	}
	@Then("Response should be 200")
	public void checkHealthCheckStatus() {
		String status = response.jsonPath().getString("status");
		Assert.assertEquals(status, "UP");
	}
}
