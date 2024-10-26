Feature: In state first year student should have all campuses available
  Scenario: Select the latest Fall semester, first year student
    Given I am applying with a new account and I have reached the term selection page
    When I select the latest Fall semester
    And I select the "Transfer" application level
    #  I select that I am a first year student