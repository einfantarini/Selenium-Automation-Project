@Test
Feature: Upload Single File
  Scenario: User upload single file through upload button
    When the user uploads single file
    Then the file should be uploaded successfully