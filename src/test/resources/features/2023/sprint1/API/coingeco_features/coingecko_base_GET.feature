#Author
#Date
#Description

Feature: Get general request from https://api.coingecko.com/api/v3/exchange_rates

  @api
  Scenario: GET request from coingecko
    Given user sent get request to "/api/v3/exchange_rates" endpoint
    Then status code should be 200
    And content type is "application/json; charset=utf-8"
