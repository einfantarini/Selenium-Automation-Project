@GUITest
Feature: GUI Elements on Home Page
  Scenario Outline: Enter details in Name and Email fields
    Given the browser is on the homepage
    When I enter "<name>" in Name field
    When I enter "<mail id>" in the Email field
    When I enter "<phone number>" in the phone number field
    When I enter "<Address>" in the address field
    Then the fields should display the entered values

    Examples:
      | name     | mail id                 | phone number | Address      |
      | Rini     | e.infantarini@gmail.com | 1234567890   | ABC123       |
      | Eric     | eric@gmail.com          | 23123452     | BNVGB234     |
      | Michelle | mike@gmail.com          | 2123424      | GHFTV street |
