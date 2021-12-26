Feature: Verify Endpoint functionality

  Rule : User is required valid credentials

    Background: Login into Ortelius application using valid credentials
      Given User is navigate to Login Page
      When User is entered username in username text box
      And User is entered password in password text box
      And User click on login button
      Then User is able to view Home page

    Scenario Outline: Fill All details in Endpoint Details tab
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
      And User is click on Endpoints button in Endpoint details tab
      Then User is able to see "<Name>" value Endpoint Table

      Examples:
        | Full Domain                          | Name | Description      | Endpoint Operating System | Endpoint Types            | Hostname | Protocal | SSH Port Number | Base Directory | Credential    | Ping Failure Template |
        | GLOBAL.Ortelius.Online Store Company |      | Test-Description | Windows                   | GLOBAL.Application Server | Test     | ssh      | 22              | Temp           | None Required | GLOBAL.DeploySuccess  |