Feature: Hotel Booking

Background: Declare base URI
Given Declare base uri

Scenario: Health Check
When Hit Health Check endpoint
Then Status should be UP

Scenario Outline: Get Authentication Token
When Hit Auth Token call by passing <username> and <password>
Then Assert the response and save the token
Examples:
|username|password|
|'admin'|'password'|