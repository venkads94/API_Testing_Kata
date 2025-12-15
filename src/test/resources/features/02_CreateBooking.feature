Feature: Create Booking

@Positive
Scenario Outline: Create Booking
When Create payload by passing <firstname>,<lastname>,<phone>,<email>,<checkin>,<checkout> and call POST call
Then Validate if status code is 201
Examples:
|firstname|lastname|phone|email|checkin|checkout|
|'Sub'|'Kri'|'9095553431123'|'abc@gmail.com'|'2026-02-20'|'2026-02-21'|
|'SubhalakshmiVenkat'|'Kri'|'9095553431123'|'abc@gmail.com'|'2026-02-20'|'2026-02-21'|
|'Sub'|'Venkadakrishnansvk'|'9095553431123'|'abc@gmail.com'|'2026-02-20'|'2026-02-21'|

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

