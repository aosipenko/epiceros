Feature: Navigation login tests

  Background:
    Given Reset active sessions

  Scenario: Validate basic login form
    Given I load login page
    When I open login form
    And I press FORGOT_PASSWORD element in Login Form
    Then I can see BACK_TO_LOGIN element in Login Form
    Then I can see USERNAME element in Login Form

  Scenario: Validate basic login form
    Given I load login page
    When I open login form
    And I press REGISTER_USER element in Login Form
    Then I can see REGISTRATION_HEADER element in Registration Form
