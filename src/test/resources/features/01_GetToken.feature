Feature: Get Auth Token

@Positivere
Scenario Outline: Get Authentication Tokenue
Given Create request payload by passing <username> and <password>
When Send POST request with the request payload
Then Save the token created
And Check if status code is 200
Examples:
|username|password|
|'admin'|'password'|

@Negative
Scenario Outline: Get Authentication Token Negative Scenario
Given Create request payload by passing <username> and <password>
When Send POST request with the request payload
Then Check if status code is 401
Examples:
|username|password|
|'admin1'|'password'|
|'admin1'|'password1'|
