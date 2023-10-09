Feature: As user I want to be able to login
  Scenario: Login as a default user
    Given user is on the login page
    When Logging in as a default user
    Then user should verify that title is a Conduit
