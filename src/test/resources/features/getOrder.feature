@GetOrder
Feature: Validate Get Order Feature
  I want to get a PayPal order using this feature

  Scenario Outline: Validate Get Order with valid details
    Given I got access token form PayPal api
    When I get order from Paypal api
    Then I verify the "<status_code>"

    Examples: 
      | status_code |
      |         200 |
