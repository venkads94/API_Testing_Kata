package stepDefinition;

import org.testng.Assert;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinitionClass {
	
	public static RequestSpecification inputRequest;
	public static Response response;
	
	@Given("Declare base uri")
	public void declareBaseURI() {
		RestAssured.baseURI = "https://automationintesting.online/api";
	}
	
	@When("Hit Health Check endpoint")
	public void healthCheck() {
		response = RestAssured.get("/booking/actuator/health");
	}
	@Then("Status should be UP")
	public void checkHealthCheckStatus() {
		String status = response.jsonPath().getString("status");
		Assert.assertEquals(status, "UP");
	}
}