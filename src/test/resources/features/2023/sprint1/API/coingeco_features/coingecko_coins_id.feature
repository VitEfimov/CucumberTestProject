#Author
#Date
#Description

Feature: Get general request from https://api.coingecko.com/api/v3/coins/bitcoin

  @api
  Scenario Outline: GET request from coingecko with parameter
    Given user sent get request to "/api/v3/coins/" "<parameter>" endpoint
    Then status code in case2 should be 200
    And content type in case2 is "application/json; charset=utf-8"

    Examples:
      | parameter  |
      | bitcoin    |
      | blockstack |
      | apecoin    |