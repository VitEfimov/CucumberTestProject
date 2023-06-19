#Author
#Date
#Description

Feature: POST and DELETE new user on demoQA

  @demoqa
  Scenario: POST request from demoQA
    Given user parameters "Jimmyyeuruui Bzjeck" and "PasswordJI7&"
    When user sent post request to "https://demoqa.com/Account/v1/User" endpoint
    Then status code 201
    And content type "application/json; charset=utf-8"
    And userName should be equal "userName"
    And extract userId


  @demoqa
  Scenario: GenerateToken based on body
    Given user parameters "Jimmyyeuruui Bzjeck" and "PasswordJI7&"
    When user sent post request to "https://demoqa.com/Account/v1/GenerateToken" endpoint
    Then status code 200
    And content type "application/json; charset=utf-8"
    And extract userToken


  @demoqa
  Scenario: Assert authorization
    Given user parameters "Jimmyyeuruui Bzjeck" and "PasswordJI7&"
    When user sent post request to "https://demoqa.com/Account/v1/Authorized" endpoint
    Then status code 200
    And content type "application/json; charset=utf-8"



  @demoqa
  Scenario: POST user - User exists!
    Given user parameters "Jimmyyeuruui Bzjeck" and "PasswordJI7&"
    When user sent post request to "https://demoqa.com/Account/v1/User" endpoint
    Then status code 406
    And content type "application/json; charset=utf-8"
    And message "User exists!" should be appear


  @demoqa
  Scenario: GET user
    Given user sent get request with userToken, path param UUID, userID to "https://demoqa.com/Account/v1/{UUID}" endpoint
#    Then status code 200


  @demoqa
  Scenario: DELETE user
    Given user sent delete req with userToken, path param UUID, userID to "https://demoqa.com/Account/v1/{UUID}" endpoint
#    Then status code 204





