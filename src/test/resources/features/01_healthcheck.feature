Feature: HealthCheck for Hotel Booking

@healthcheck
@positive
Scenario: Healthcheck API
Given Call Healthcheck API
Then Response should be 200