#Author
#Date
#Description
  Feature: create csv file
    @ui
    Scenario: create csv file with general payload
      Given user on a main google page
      When user send key in a search box "Mockaroo"
      And user click first "Mockaroo" link
      Then user on main page of "Mockaroo"

    Scenario: create csv file with general payload
      Given user on a main Mockaroo page
      When user send key in a search box "Mockaroo"
      And user click first "Mockaroo" link
      Then user on main page of "Mockaroo"