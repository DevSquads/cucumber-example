Feature: Google translate

  Scenario Outline: Translate from English to arabic
    Given Browser is opened and on Google translate
    When Type "<text>"
    Then Should translate into "<arabicText>"


    Examples:
      | text              | arabicText     |
      | software Engineer | مهندس برمجيات  |
      | automated testing | الاختبار الآلي |