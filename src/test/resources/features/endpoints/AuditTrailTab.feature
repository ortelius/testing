Feature: Verify Audit Trail Tab functionality in Endpoint Module

  Rule : User is required valid credentials

    Background: Login into Ortelius application using valid credentials
      Given User is navigate to Login Page
      When User is entered username in username text box
      And User is entered password in password text box
      And User click on login button
      Then User is able to view Home page

    Scenario Outline: Create a new Endpoint and Update Audit Trail Details
      When User is click on Endpoints button in Endpoint details tab
      And User is click on Add button in Endpoint details tab
      And User is select "<Full Domain>" value from Full Domain list box
      And User is enter "<Name>" value in Name text box
      And User is enter "<Description>" value in Description text box
      And User is select "<Endpoint Operating System>" value from Endpoint Operating System list box
      And User is select "<Endpoint Types>" value from Endpoint Types list box
      And User is enter "<Hostname>" value in Hostname text box
      And User is select "<Protocal>" value from Protocal list box
      And User is enter "<SSH Port Number>" value in SSH Port Number text box
      And User is enter "<Base Directory>" value in Base Directory text box
      And User is select "<Credential>" value from Credential list box
      And User is select "<Ping Failure Template>" value from Ping Failure Template list box
      And User is click on Save button in Endpoint details tab

      #Update Audit Trail Message
      When User is enter "Testing" value in message in Audit Trail text box
      And User is click on Add Message button in Audit Trail tab
      Then User is able to see "Testing" value in Event details tab

      #Move to Endpoint tab
      And User is click on Endpoints button in Endpoint details tab
      And User is select "All" value from Show entry list box
      Then User is able to see "<Name>" value Endpoint Table

      # Delete EndPoint
      When User is able to filter "<Name>" on Endpoints table
      And User is select "1" checkbox on Endpoints table
      And User is click on Delete button in Endpoint details tab
      And User is click on Ok button in Delete confirmation pop up in Endpoint details tab
      Then User is able to see "No matching records found" word in Endpoints table

      Examples:
        | Full Domain                          | Name | Description      | Endpoint Operating System | Endpoint Types            | Hostname | Protocal | SSH Port Number | Base Directory | Credential    | Ping Failure Template |
        | GLOBAL.Ortelius.Online Store Company |      | Test-Description | Windows                   | GLOBAL.Application Server | Test     | ssh      | 22              | Temp           | None Required | GLOBAL.DeploySuccess  |