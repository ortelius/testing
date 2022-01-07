Feature: Verify Key Value Configuration functionality in Application Module

  Rule : User is required valid credentials

    Background: Login into Ortelius application using valid credentials
      Given User is navigate to Login Page
      When User is entered username in username text box
      And User is entered password in password text box
      And User click on login button
      Then User is able to view Home page
      When User is open "1" Record from application table

    Scenario Outline: Add Key and Value in Key Value Configuration Table
      When User is click on Add button in Key value configuration tab
      And User is entered "<Name>" value in Name text box in Key value configuration tab
      And User is entered "<Value>" value in Value text box in Key value configuration tab
      And User is click on Save button in Key value configuration tab
     # Then User is able to see "<Name>" and "<Value>" in Key value configuration table

      Examples:
        | Name   | Value   |
        | Name19 | Value19 |

    Scenario Outline: Delete All Key and Value in Key Value Configuration Table
      When <actor> is select all key and value check box
      And <actor> is click on Delete button in Key value configuration table
      And <actor> is click on Save button in Key value configuration tab
      Then <actor> is verify empty table in Key value configuration table
      Examples:
        | actor |
        | User  |
