package com.booking.stepdefinitions;
import com.booking.config.BaseClass;
import org.hamcrest.Matchers;
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
		response.then().assertThat().statusCode(Matchers.equalTo(200));
	}
}
