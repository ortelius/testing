Feature: Verify Application Details functionality

  Rule : User is required credentials

    Background: Login into Ortelius application using valid credentials

      Given User is navigate to Login Page
      When User is entered "automation" username in username text box
      And User is entered "Welcome@123" password in password text box
      And User click on login button
      Then User is able to view Home page

    Scenario: Modify Details tab

      When User is opened "Hipster Store;July 4th Sale;4 - Testing" version
      And User is click on Edit button in details tab
      And User is modified below values in Details tab

        | Full Domain | Name | Description | Change Request Data Source | Pre-Action               | Post-Action              | Custom-Action            | Successfull Deployment Template | Failed Deployment Template |
        |             |      |             |                            | GLOBAL.GKE_ResizeCluster | GLOBAL.GKE_ResizeCluster | GLOBAL.GKE_ResizeCluster |                                 |                            |

      And User click on Save button
      Then User is able to see updated values in details tab

        | Full Domain | Name | Description | Change Request Data Source | Pre-Action               | Post-Action              | Custom-Action            | Successfull Deployment Template | Failed Deployment Template |
        |             |      |             |                            | GLOBAL.GKE_ResizeCluster | GLOBAL.GKE_ResizeCluster | GLOBAL.GKE_ResizeCluster |                                 |                            |


