Feature: Create Booking

@positive
Scenario Outline: Create Booking
Given Create request payload by passing <firstname>,<lastname>,<phone>,<email>,<checkin>,<checkout>
When Call POST method for create booking
Then Check if status code is 201
Examples:
|firstname|lastname|phone|email|checkin|checkout|
|'Sub'|'Kri'|'90955534311'|'abc@gmail.com'|'2026-02-20'|'2026-02-21'|
|'SubhalakshmiVenkat'|'Kri'|'9095553431123'|'abc@gmail.com'|'2026-02-20'|'2026-02-21'|
|'Sub'|'Venkadakrishnansvk'|'9095553431123'|'abc@gmail.com'|'2026-02-20'|'2026-02-21'|
|'Sub'|'Kri'|'909555343112345678901'|'abc@gmail.com'|'2026-02-20'|'2026-02-21'|

@negative
Scenario Outline: Create Booking
Given Create request payload by passing <firstname>,<lastname>,<phone>,<email>,<checkin>,<checkout>
When Call POST method for create booking
Then Check if status code is 400
And Validate the error response message
Examples:
|firstname|lastname|phone|email|checkin|checkout|
|'SK'|'Kri'|'9095553431123'|'abc@gmail.com'|'2026-02-20'|'2026-02-21'|
|'Sub'|'Ki'|'9095553431123'|'abc@gmail.com'|'2026-02-20'|'2026-02-21'|
|'Sub'|'Krish'|'9095553431123'|'abcgmail.com'|'2026-02-20'|'2026-02-21'|
|'Sub'|'Krish'|'9095553431'|'abc@gmail.com'|'2026-02-20'|'2026-02-21'|

