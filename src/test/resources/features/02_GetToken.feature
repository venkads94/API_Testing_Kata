Feature: Get Auth Token

@positive
Scenario Outline: Get Authentication Token
Given Create request payload by passing <username> and <password>
When Send POST request with the request payload
Then Save the token created
And Check if status code is 200
Examples:
|username|password|
|'admin'|'password'|

@negative
Scenario Outline: Get Authentication Token Negative Scenario
Given Create request payload by passing <username> and <password>
When Send POST request with the request payload
Then Check if status code is 401
Examples:
|username|password|
|'admin1'|'password'|
|'admin1'|'password1'|
