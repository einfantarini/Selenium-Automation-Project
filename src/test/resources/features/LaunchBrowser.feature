Feature:Launch the browser
  Scenario: Open the test automation practice website
Given I open the chrome browser
  When  I navigate to the "https://testautomationpractice.blogspot.com/"
  Then  the browser should display homepage
