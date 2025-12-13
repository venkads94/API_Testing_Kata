package com.booking.stepdefinitions;
import java.util.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	public static RequestSpecification inputRequest;
	public static Response response;
	public static String authToken;
	
	public Map createRequestPayloadBody(String firstname, String lastname, String phone, String email, String checkin, String checkout) {
		Map<String, Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin", checkin);
        bookingDates.put("checkout", checkout);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("roomid", 401);
        requestBody.put("depositpaid", true);
        requestBody.put("firstname", firstname);
        requestBody.put("lastname", lastname);
        requestBody.put("email", email);
        requestBody.put("phone", phone);
        requestBody.put("bookingdates", bookingDates);

        return requestBody;
	}
}
