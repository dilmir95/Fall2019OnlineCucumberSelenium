@activities
Feature: Create calendar event
  As a user, I want to be able to create calendar events.


  Scenario: Create calendar event as sales manager
    Given user is on the landing page
    When user logs in as a sales manager
    And user navigates to "Activities" and "Calendar Events"
    Then user clicks on create calendar event
    And user enters "Sprint RetroSpective" as title and "Sprint Details" as description and click save and close
    Then verify that title info is "Sprint RetroSpective" and description info is "Sprint Details"

  @calendar_event_data
  Scenario: Create calendar event as sales manager with data table
    Given user is on the landing page
    When user logs in as a sales manager
    And user navigates to "Activities" and "Calendar Events"
    Then user clicks on create calendar event
    And user enters new calendar event information:
      | title       | SprintRetrospective |
      | description | Sprint details      |
    Then user verifies new calendar event was created
      | title       | SprintRetrospective |
      | description | Sprint details      |




