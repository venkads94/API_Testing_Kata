package com.booking.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class HookClass {
	@Before
	@Given("Set value of base uri")
	public void declareBaseURI() {
		RestAssured.baseURI = "https://automationintesting.online/api";
	}
}
