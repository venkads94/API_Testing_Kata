Feature: Get Booking

@Positive
Scenario: Get Booking Details by Id
When Call Get Booking Details by passing booking id
Then Validate if status code is 200

@Negative
Scenario: Get Booking Details by Id Negative Scenario
When Call Get Booking Details by passing invalid token
Then Validate if status code is 403
