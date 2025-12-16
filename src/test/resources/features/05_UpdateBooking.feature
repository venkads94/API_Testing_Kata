Feature: Update Booking

@Positive
Scenario Outline: Update Booking Details
Given Create request payload by passing <firstname>,<lastname>,<phone>,<email>,<checkin>,<checkout> to update booking
When Call PUT method to update booking
Then Validate if update response code is 200
Examples:
|firstname|lastname|phone|email|checkin|checkout|
|'Sub'|'Kri'|'9095553431123'|'abc@gmail.com'|'2026-03-20'|'2026-03-21'|

@Negative
Scenario Outline: Update Booking Details with missing token
Given Create request payload by passing <firstname>,<lastname>,<phone>,<email>,<checkin>,<checkout> to update booking
When Call PUT method to update booking with missing token
Then Validate if update response code is 401
And Validate the error response message for missing token
Examples:
|firstname|lastname|phone|email|checkin|checkout|
|'Sub'|'Kri'|'909555343112309'|'abc@gmail.com'|'2026-03-20'|'2026-03-21'|

@Negative
Scenario Outline: Update Booking Details with invalid token
Given Create request payload by passing <firstname>,<lastname>,<phone>,<email>,<checkin>,<checkout> to update booking
When Call PUT method to update booking with invalid token
Then Validate if update response code is 403
And Validate the error response message for invalid token
Examples:
|firstname|lastname|phone|email|checkin|checkout|
|'Sub'|'Kri'|'909555343112309'|'abc@gmail.com'|'2026-03-20'|'2026-03-21'|
 
 
