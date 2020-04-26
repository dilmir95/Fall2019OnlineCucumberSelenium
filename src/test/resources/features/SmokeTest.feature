@smoke_test1
Feature: Smoke Test

  Scenario Outline: go to <module> and verify title is: <title>
    Given user is on the landing page
    When user logs in as "<user_type>"
    And user navigates to "<tab>" and "<module>"
    Then user verifies that page title is "<title>"

    Examples:
      | user_type     | tab        | module          | title                                                              |
      | sales manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
      | sales manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
      | sales manager | Customers  | Accounts        | All - Accounts - Customers                                         |
      | sales manager | Customers  | Contacts        | All - Contacts - Customers                                         |
      | sales manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
      | sales manager | System     | Jobs            | All - Jobs - System                                                |


