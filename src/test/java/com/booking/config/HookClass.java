package com.booking.config;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class HookClass {
	
	static boolean healthFailed = false;
	
	@Before(order=0)
	public void stopIfHealthCheckFailed() {
		if(healthFailed) {
			throw new RuntimeException("Healthcheck failed.Skipping remaining tests.");
		}
	}
	
	@Before(order=1)
	@Given("Set value of base uri")
	public void declareBaseURI() {
		RestAssured.baseURI = "https://automationintesting.online/api";
	}
	
	@After("@healthcheck")
	public void captureHealthcheckResult(Scenario scenario) {
		if(scenario.isFailed()) {
			healthFailed = true;
		}
	}
	
	
}
