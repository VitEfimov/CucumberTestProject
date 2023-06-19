#Author
#Date
#Description

Feature: Get general request from http://api.zippopotam.us/{country}/{postal-code}

  @api@zip
  Scenario: GET request from zippopotam with parameters
    Given send get request to "http://api.zippopotam.us/{country}/{postal-code}", country is "us", postal code is 22102
    Then status code is 200
    Then post code is "22102"
    And  country is "United States"
    And place name is "Mc Lean"
    And  state is "Virginia"