@view_calendar_events
Feature: View all calendar events
  As user, I want to be able to see all calendar events as a table

  Scenario: User Permissions
    Given user is on the landing page
    When user logs in as a sales manager
    When user navigates to "Activities" and "Calendar Events"
    Then view per page menu should have following options
      | 10  |
      | 25  |
      | 50  |
      | 100 |