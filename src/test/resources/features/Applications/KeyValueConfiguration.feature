Feature: Verify Key Value Configuration functionality

  Rule : User is required valid credentials

    Background: Login into Ortelius application using valid credentials
      Given User is navigate to Login Page
      When User is entered username in username text box
      And User is entered password in password text box
      And User click on login button
      Then User is able to view Home page
      When User is opened "Automation Testing" version

    Scenario Outline: Modify Key Value Configuration tab
      When User is click on Add button in Key value configuration tab
      And User is entered "<Name>" value in Name text box in Key value configuration tab
      And User is entered "<Value>" value in Value text box in Key value configuration tab
      And User is click on Save button in Key value configuration tab
      Then User is able to see "<Name>" and "<Value>" in Key value configuration table

      Examples:
        | Name  | Value  |
        | Name1 | Value1 |




