
Feature: GUI Elements on Home Page
  Scenario Outline: Enter details in Name and Email fields
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

Scenario Outline: Select Gender Radio Button
    When I select "<gender>" Gender radio button
    Then the "<gender>" radio should be selected

    Examples:
    |gender|
    | Male |
    |Female|

  Scenario Outline: Check Days from checkboxes
      When I select "<Days>" Days checkbox
      Then the "<Days>" checkbox should be selected
      Examples:
      |Days     |
      |sunday   |
      |monday   |
      |tuesday  |
      |wednesday|
      |thursday |
      |friday   |
      |saturday |

    Scenario Outline:  Select Country from DropDown
      When I select "<Country>" from country dropdown
      Then  the "<Country>" should be selected

      Examples:
      |Country       |
      |United States |
      |Canada        |
      |United Kingdom|
      |Germany       |
      |France        |
      |Australia     |
      |Japan         |
      |China         |
      |Brazil        |
      |India         |


      Scenario Outline: Select Colors from Color field
        When I select "<Colors>" from color list
        Then the Colors should be highlighted

        Examples:
        |Colors|
        |Red   |
        |Blue  |
        |Green |
        |Yellow|
        |White |
        |Green |

Scenario: Enter dates using DataTables
  When I enter the Date in the date text field
  | Date1     | Date2     | FromDate   | ToDate     |
  |10/27/1987 |29/09/2014 | 23/10/1985 | 24/08/1999 |

