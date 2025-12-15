Feature: Update Booking

@Positive
Scenario Outline: Update Booking Details
When Create payload by passing <firstname>,<lastname>,<phone>,<email>,<checkin>,<checkout> and call PUT endpoint
Then Validate if status code is 200
Examples:
|firstname|lastname|phone|email|checkin|checkout|
|'Sub'|'Kri'|'9095553431123'|'abc@gmail.com'|'2026-03-20'|'2026-03-21'|

@Negative
Scenario Outline: Update Booking Details with invalid token
When Create payload by passing <firstname>,<lastname>,<phone>,<email>,<checkin>,<checkout> and call PUT endpoint with empty token
Then Validate if status code is 401
Examples:
|firstname|lastname|phone|email|checkin|checkout|
|'Sub'|'Kri'|'909555343112309'|'abc@gmail.com'|'2026-03-20'|'2026-03-21'|
 