@CreateOrder
Feature: Validate Create Order Feature
  I want to create a PayPal order using this feature

  Scenario Outline: Validate Create Order with valid detail
    Given I got access token form PayPal api
    When I set currency code as "<currency_code>" and value is "<currency_value>"
    Then I verify the status as CREATED

    Examples: 
      | currency_code | currency_value |
      | USD           |         500.00 |