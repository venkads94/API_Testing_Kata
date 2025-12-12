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