Feature: Google translate
  Scenario: Translate from English to arabic
    Given Browser is opened and on Google
    When Search for translate
    And Type Software Engineer
    Then Should translate into Arabic