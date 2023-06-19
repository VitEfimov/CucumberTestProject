#Author
#Date
#Description

Feature: Get general request from https://api.coingecko.com/api/v3/coins/bitcoin/market_chart/range?vs_currency=usd&from=1652839012&to=1652925412

  @api
  Scenario: GET request from coingecko with parameters
    Given user sent get request case3 to "/api/v3/coins/bitcoin/market_chart/range?vs_currency=usd&from=1652839012&to=1652925412" endpoint
    Then status code in case3 should be 200
    And content type in case3 is "application/json; charset=utf-8"