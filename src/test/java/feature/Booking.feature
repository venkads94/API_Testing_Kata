Feature: Hotel Booking

Background: Declare base URI
Given Declare base uri

Scenario: Health Check
When Hit Health Check endpoint
Then Status should be UP