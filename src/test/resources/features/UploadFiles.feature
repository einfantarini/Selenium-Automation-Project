@Test
Feature: Upload Single File
  Scenario: User upload single file through upload button
    When the user uploads single file
    Then the file should be uploaded successfully


  Scenario: User upload multiple through upload button
    When the user uploads multiple file
    Then the files should be uploaded successfully
