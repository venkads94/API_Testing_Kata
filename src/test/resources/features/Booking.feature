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
