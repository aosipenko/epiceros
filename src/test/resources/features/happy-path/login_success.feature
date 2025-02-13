Feature: Successful login tests

  Background:
    Given Reset active sessions

  Scenario: Validate basic login form
    Given I load login page
    When I open login form
    Then I can see USERNAME element in Login Form
    Then I can see PASSWORD element in Login Form
    Then I can see FORGOT_PASSWORD element in Login Form
    Then I can see REGISTER_USER element in Login Form

  Scenario: Successful login
    Given I load login page
    When I open login form
    And I set username to "qa_interview@mailinator.com"
    And I set password to "testtest1"
    And I press LOGIN_BUTTON element in Login Form
    Then User Home Page is loaded
    When I close history modal
    And I open side menu
    Then I select ACCOUNT_PROFILE option in side menu
    And User Profile page is loaded
    And User profile contains:
      | User name  | qa_interview@mailinator.com |
      | E-Mail     | qa_interview@mailinator.com |
      | First name | Katrin                      |

  Scenario: Validate basic login form
    Given I load login page
    When I open login form
    And I set username to "qa_interview@mailinator.com"
    And I set password to "testtest1"
    Then Password value is "masked" and equal to "testtest1"
    And I press SHOW_PASSWORD element in Login Form
    Then Password value is "not masked" and equal to "testtest1"
