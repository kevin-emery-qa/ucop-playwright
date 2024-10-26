Feature: I should be able to create an account to apply
  Scenario: I can successfully create a new account to apply
    Given The login page has loaded and I see the button to apply
    When I click the button to create an account
    Then I see the form to create a new account
    When I submit the form to create a new account
    Then I am on the term level selection page
    # When I select the latest Fall semester
    #  I select that I am a first year student