package stepDefinition;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinitionClass {
	
	public static RequestSpecification inputRequest;
	public static Response response;
	public String authToken;
	
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
	
	@When("Hit Auth Token call by passing {string} and {string}")
	public void getAuthToken(String uname, String pwd) {
		String requestBody = "{"
                + "\"username\":\"" + uname + "\","
                + "\"password\":\"" + pwd + "\""
                + "}";
		System.out.println(requestBody);
		inputRequest = RestAssured.given().contentType("application/json").when().body(requestBody);
		response = inputRequest.post("/auth/login");
	}
	@Then("Assert the response and save the token")
	public void assertResponseForAuthToken() {
		response.then().assertThat().statusCode(Matchers.equalTo(200));
		authToken = response.jsonPath().getString("token");
	}
}