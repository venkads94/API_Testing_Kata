Feature: Hotel Booking

Background: Declare base URI for all test cases
Given Set value of base uri

Scenario: Health Check
When Call Health Check endpoint
Then Status should be UP

@Positive
Scenario Outline: Get Authentication Token
When Call Auth Token call by passing <username> and <password>
Then Save the token created and check if status code is 200
Examples:
|username|password|
|'admin'|'password'|

@Negative
Scenario Outline: Get Authentication Token Negative Scenario
When Call Auth Token call by passing <username> and <password>
Then Check if status code is 401
Examples:
|username|password|
|'admin1'|'password'|
|'admin1'|'password1'|

@Positive
Scenario Outline: Create Booking
When Create payload by passing <firstname>,<lastname>,<phone>,<email>,<checkin>,<checkout> and call POST call
Then Validate if status code is 201
Examples:
|firstname|lastname|phone|email|checkin|checkout|
|'Sub'|'Kri'|'9095553431123'|'abc@gmail.com'|'2026-02-20'|'2026-02-21'|
|'SubhalakshmiVenkat'|'Kri'|'9095553431123'|'abc@gmail.com'|'2026-02-20'|'2026-02-21'|

@Negative
Scenario Outline: Create Booking
When Create payload by passing <firstname>,<lastname>,<phone>,<email>,<checkin>,<checkout> and call POST call for Negative Scenario
Then Validate if status code is 400
And Validate the error response message
Examples:
|firstname|lastname|phone|email|checkin|checkout|
|'SK'|'Kri'|'9095553431123'|'abc@gmail.com'|'2026-02-20'|'2026-02-21'|
|'Sub'|'Krish'|'9095553431123'|'abcgmail.com'|'2026-02-20'|'2026-02-21'|
|'Sub'|'Krish'|'9095553431'|'abc@gmail.com'|'2026-02-20'|'2026-02-21'|

@Positive
Scenario: Get Booking Details by Id
When Call Get Booking Details by passing booking id
Then Validate if status code is 200

@Negative
Scenario: Get Booking Details by Id Negative Scenario
When Call Get Booking Details by passing invalid token
Then Validate if status code is 403

@Positive
Scenario Outline: Update Booking Details
When Create payload by passing <firstname>,<lastname>,<phone>,<email>,<checkin>,<checkout> and call PUT endpoint
Then Validate if status code is 200
Examples:
|firstname|lastname|phone|email|checkin|checkout|
|'Sub'|'Kri'|'9095553431123'|'abc@gmail.com'|'2026-03-20'|'2026-03-21'|
