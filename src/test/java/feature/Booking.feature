Feature: Hotel Booking

Background: Declare base URI
Given Declare base uri

Scenario: Health Check
When Hit Health Check endpoint
Then Status should be UP

@Positive
Scenario Outline: Get Authentication Token
When Hit Auth Token call by passing <username> and <password>
Then Assert the response and save the token
Examples:
|username|password|
|'admin'|'password'|

@Negative
Scenario Outline: Get Authentication Token Negative Scenario
When Hit Auth Token call by passing <username> and <password>
Then Assert the unthorized response code
Examples:
|username|password|
|'admin1'|'password'|
|'admin1'|'password1'|

@Positive
Scenario Outline: Create Booking
When Build request payload <firstname>,<lastname>,<phone>,<email>,<checkin>,<checkout> and hit create booking endpoint
Then Assert the positive response 200
Examples:
|firstname|lastname|phone|email|checkin|checkout|
|'Sub'|'Kri'|'9095553431123'|'abc@gmail.com'|'2026-02-20'|'2026-02-21'|