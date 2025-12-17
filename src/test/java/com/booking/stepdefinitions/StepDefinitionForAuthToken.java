package com.booking.stepdefinitions;
import com.booking.config.BaseClass;
import org.hamcrest.Matchers;
import org.testng.Assert;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;

public class StepDefinitionForAuthToken extends BaseClass {
	
	public String requestBody;
	
	//POST Get Auth Token Positive Case
	@Given("Create request payload by passing {string} and {string}")
	public void createRequestPayloadForAuthToken(String uname, String pwd) {
		requestBody = "{"
                + "\"username\":\"" + uname + "\","
                + "\"password\":\"" + pwd + "\""
                + "}";
	}
	
	@When("Send POST request with the request payload")
	public void assertResponseForAuthToken() {
		inputRequest = RestAssured.given().contentType("application/json").when().body(requestBody);
		response = inputRequest.post("/auth/login");
	}
	
	@Then("Save the token created")
	public void saveAuthToken() {
		authToken = response.jsonPath().getString("token");
	}
	
	@And("Check if status code is 200")
	public void checkStatusCodeisPositive() {
		response.then().assertThat().statusCode(Matchers.equalTo(200));;
	}
	
	//POST Get Auth Token Negative Case
	@Then("Check if status code is 401")
	public void assertUnauthorizedResponseCode() {
		response.then().assertThat().statusCode(Matchers.equalTo(401));
		String errorMsg = response.jsonPath().getString("error");
		Assert.assertEquals(errorMsg, "Invalid credentials");
	}
}


	