@screen

Feature: As a logged in use I can change my password

  Scenario: Change password successfully
    Given I successfully login
    When I click on Preferences button
    And I input current password
    And I input new password
    And I confirm the new password
    And Click on Save button
    Then I should see "Your password has been successfully changed." message
    And I close the Preferences window
    And I logout
    And I successfully login
    #And I can relogin with new credentials
