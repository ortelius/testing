Feature: Verify Ortelius Application functionality

  Rule : User is required credentials

    Scenario Outline: Verify Login functionality

      Given User is navigate to Login Page
      When User is entered "<username>" username in username text box
      And User is entered "<password>" password in password text box
      And User click on login button
      Then User is able to view Home page

      Examples:
      |username|password|
      |automation|Welcome@123|