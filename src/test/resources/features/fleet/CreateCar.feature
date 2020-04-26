@create_car
Feature: Create a car
  As user , I want to be able to add new cars

  Scenario: Add new car
    Given user is on the landing page
    When user logs in as a sales manager
    Then user navigates to "Fleet" and "Vehicles"
    And user click on create car button
    Then user creates a car with following info:
      | License Plate | Driver    | Location   | Model Year | Color |
      | SDET          | Pro Racer | Rome,Italy | 2020       | Black |
    And user verifies that car info is displayed:
      | License Plate | Driver    | Location   | Model Year | Color |
      | SDET          | Pro Racer | Rome,Italy | 2020       | Black |


    @create_car_ddt
  Scenario Outline: Add new car
    Given user is on the landing page
    When user logs in as a sales manager
    Then user navigates to "Fleet" and "Vehicles"
    And user click on create car button
    Then user creates a car with following info:
      | License Plate   | Driver   | Location   | Model Year   | Color   |
      | <license plate> | <driver> | <location> | <model_year> | <color> |
    And user verifies that car info is displayed:
      | License Plate   | Driver   | Location   | Model Year   | Color   |
      | <license plate> | <driver> | <location> | <model_year> | <color> |

    Examples: cars test date
      | license plate | driver    | location | model_year | color |
      | 000           | Pro Racer | Rome     | 2020       | Black |
      | 007           | Aston     | England  | 2020       | Black |
