Feature: Get Booking

@positive
Scenario: Get Booking Details by Id
When Call Get Booking Details by passing booking id
Then Validate if status code is 200

@negative
Scenario: Get Booking Details by Id with invalid token
When Call Get Booking Details by passing invalid token
Then Validate if response status code is 401

@negative
Scenario: Get Booking Details by Id with missing token
When Call Get Booking Details by passing missing token
Then Validate if response status code is 401