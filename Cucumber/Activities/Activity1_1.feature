@activity1_1
Feature: "First Test"

  @SmokeTest
  Scenario: Opening a web page using selenium
    Given User is on Google Home Page
    When User types in Cheese and hits ENTER
    Then Show hom many search results were shown
    And Close the browser

  