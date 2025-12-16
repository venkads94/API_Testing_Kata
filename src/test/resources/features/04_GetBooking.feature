Feature: Get Booking

@Positive
Scenario: Get Booking Details by Id
When Call Get Booking Details by passing booking id
Then Validate if status code is 200

@Negative
Scenario: Get Booking Details by Id with invalid token
When Call Get Booking Details by passing invalid token
Then Validate if status code is 403


@Negative
Scenario: Get Booking Details by Id with missing token
When Call Get Booking Details by passing missing token
Then Validate if status code is 401