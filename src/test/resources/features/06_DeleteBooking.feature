Feature: Delete Booking

@positive
Scenario: Delete Booking by ID
When Call Delete Booking Details by passing booking id
Then Validate if delete status code is 201

@negative
Scenario: Delete Booking by ID with missing token
When Call Delete Booking Details with missing token
Then Validate if delete status code for missing token is 401

@negative
Scenario: Delete Booking by ID with invalid token
When Call Delete Booking Details with invalid token
Then Validate if delete status code for invalid token is 401
