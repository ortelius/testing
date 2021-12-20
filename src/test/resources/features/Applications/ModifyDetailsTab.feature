Feature: Verify Application Details functionality

  Rule : User is required credentials

    Background: Login into Ortelius application using valid credentials

      Given User is navigate to Login Page
      When User is entered "automation" username in username text box
      And User is entered "Welcome@123" password in password text box
      And User click on login button
      Then User is able to view Home page

    Scenario Outline: Modify Details tab

      When User is opened "<Name>" version
      And User is click on Edit button in details tab
      And User is modified below values in Details tab

        | Full Domain                                             | Name | Description | Change Request Data Source | Pre-Action | Post-Action | Custom-Action | Successfull Deployment Template | Failed Deployment Template |
        | GLOBAL.Ortelius.Online Store Company.Hipster Store.Prod |      | Auto1345    |                            |            |             |               |                                 |                            |

      And User click on Save button
      Then User is able to see updated "<Full Domain>" value in Full Domain Dropdown
      Then User is able to see updated "<Description>" value in Description text box

      Examples:
        | Full Domain                                             | Name               | Description | Change Request Data Source | Pre-Action | Post-Action | Custom-Action | Successfull Deployment Template | Failed Deployment Template |
        | GLOBAL.Ortelius.Online Store Company.Hipster Store.Prod | Automation Testing | Auto1345    |                            |            |             |               |                                 |                            |
