Feature: HealthCheck for Hotel Booking

@healthcheck
Scenario: Healthcheck API
Given Call Healthcheck API
Then Response should be 200