Feature: Verify Login Scenario functionality

  Rule : User is required credentials

    Scenario: Verify Login functionality

      Given User is navigate to Login Page
      When User is entered username in username text box
      And User is entered password in password text box
      And User click on login button
      Then User is able to view Home page

