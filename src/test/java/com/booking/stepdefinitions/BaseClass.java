package com.booking.stepdefinitions;
import java.util.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.google.gson.Gson;

public class BaseClass {
	public static RequestSpecification inputRequest;
	public static Response response;
	public static String authToken;
	public String errorMsg;
	public static int bookingId;
	
	public String createRequestPayloadBody(String firstname, String lastname, String phone, String email, String checkin, String checkout) {
		Map<String, Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin", checkin);
        bookingDates.put("checkout", checkout);

        Map<String, Object> requestBody = new HashMap<>();
        int random = (int)(Math.random()*900)+100;
        requestBody.put("roomid", random);
        requestBody.put("depositpaid", true);
        requestBody.put("firstname", firstname);
        requestBody.put("lastname", lastname);
        requestBody.put("email", email);
        requestBody.put("phone", phone);
        requestBody.put("bookingdates", bookingDates);

        String json = new Gson().toJson(requestBody);
        return json;
        
	}
}
