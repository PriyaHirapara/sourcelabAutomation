Feature: login scenario
@Test
  Scenario: User should able to login successfully
    Given User is on home page
    When User enter valid credentials
    And User click on Login button
    Then User should be able to login successfully
@invalid
  Scenario Outline: user should not able to login with invalid credentials
    Given  User is on home page
    When user enter "<username>"
    And user type <"password>"
  And user click on Login
    Then user should notable to login successfully and error message display
  Examples:
    | username | password |
    | Admin    | 123      |
    | ashsa    | admin123 |
    |          |          |
    | parul    | Mahi2012 |
    |          | admin123 |
    | Admin    |          |
