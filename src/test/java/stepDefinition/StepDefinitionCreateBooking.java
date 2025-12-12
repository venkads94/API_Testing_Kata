package stepDefinition;

import io.cucumber.java.en.*;

public class StepDefinitionCreateBooking {
	
	@Given("Build request payload {string},{string},{string},{string},{string},{string} and hit create booking endpoint")
	public void postCreateBooking(String firstname, String lastname, String phone, String email, String checkin, String checkout) {
		String requestBody = new CreateRequestBody.createRequestPayloadBody(firstname,lastname,phone,email,checkin,checkout);
	}
}
