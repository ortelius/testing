Feature: Verify Application Details functionality

  Rule : User is required credentials

    Background: Login into Ortelius application using valid credentials
      Given User is navigate to Login Page
      When User is entered username in username text box
      And User is entered password in password text box
      And User click on login button
      Then User is able to view Home page

    Scenario Outline: Modify Details tab
      When User is opened "<Name>" version
      And User is click on Edit button in details tab
      And User is modified "<Full Domain>" value in Full Domain Dropdown
      And User is modified "<Name>" value in Name text box
      And User is modified "<Description>" value in Description text box
      And User is modified "<Change Request Data Source>" value in Change Request Data Source Dropdown
      And User is modified "<Pre-Action>" value in Pre Action Dropdown
      And User is modified "<Post-Action>" value in Post Action Dropdown
      And User is modified "<Custom-Action>" value in Custom Action Dropdown
      And User is modified "<Successfull Deployment Template>" value in Successfull Deployment Template Dropdown
      And User is modified "<Failed Deployment Template>" value in Failed Deployment Template Dropdown
      And User click on Save button
      Then User is able to see updated "<Full Domain>" value in Full Domain Dropdown
      Then User is able to see updated "<Name>" value in Name text box
      Then User is able to see updated "<Description>" value in Description text box
      Then User is able to see updated "<Change Request Data Source>" value in Change Request Data Source Dropdown
      Then User is able to see updated "<Pre-Action>" value in Pre Action Dropdown
      Then User is able to see updated "<Post-Action>" value in Post Action Dropdown
      Then User is able to see updated "<Custom-Action>" value in Custom Action Dropdown
      Then User is able to see updated "<Successfull Deployment Template>" value in Successfull Deployment Template Dropdown
      Then User is able to see updated "<Failed Deployment Template>" value in Failed Deployment Template Dropdown

      Examples:
        | Full Domain                                             | Name               | Description | Change Request Data Source | Pre-Action | Post-Action | Custom-Action | Successfull Deployment Template | Failed Deployment Template |
        | GLOBAL.Ortelius.Online Store Company.Hipster Store.Prod | Automation Testing | Auto222    |                            | GLOBAL.dir | GLOBAL.dir  | GLOBAL.dir    | GLOBAL.DeploySuccess            | GLOBAL.DeploySuccess       |

