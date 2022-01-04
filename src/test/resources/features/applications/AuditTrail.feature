Feature: Verify Key Value Configuration functionality

  Rule : User is required valid credentials

    Background: Login into Ortelius application using valid credentials
      Given User is navigate to Login Page
      When User is entered username in username text box
      And User is entered password in password text box
      And User click on login button
      Then User is able to view Home page
      When User is open "1" Record from application table

    Scenario Outline: Update value in Audit Trail
      When User is enter "<Message>" value in message in Audit Trail text box
      And User is click on Add Message button in Audit Trail tab
      Then User is able to see "<Message>" value in Event details tab

      Examples:
        | Message |
        | Testing |