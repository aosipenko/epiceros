Feature: Failed Login Tests

  Background:
    Given Reset active sessions

  Scenario Outline: Login with bad password or username
    Given I load login page
    When I open login form
    And I set username to <username>
    And I set password to <password>
    And I press LOGIN_BUTTON element in Login Form
    Then I can see LOGIN_ERROR element in Login Form
    Examples:
      | username                       | password   |
      | "qa_interview@mailinator.com"  | "testest"  |
      | "qa_interview1@mailinator.com" | "testest1" |

  Scenario Outline: Login disabled for missing credentials
    Given I load login page
    When I open login form
    And I set username to <username>
    And I set password to <password>
    Then I can see LOGIN_BUTTON element is DISABLED in Login Form
    Examples:
      | username                      | password   |
      | "qa_interview@mailinator.com" | ""         |
      | ""                            | "testest1" |
      | ""                            | ""         |