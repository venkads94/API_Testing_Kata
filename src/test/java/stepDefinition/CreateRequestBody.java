package stepDefinition;
import java.util.*;

public class CreateRequestBody {
	public String createRequestPayloadBody(String firstname, String lastname, String phone, String email, String checkin, String checkout) {
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

        // Convert to JSON string (if you need the raw string)
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(requestBody);
	}
}
