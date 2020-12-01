Feature: Google translate

  Scenario Outline: Translate from English to arabic
    Given Browser is opened
    When I visit "<website>"
    And Type "<text>"
    Then Should translate into "<arabicText>"


    Examples:
     | website                     | text              | arabicText   |
     |https://translate.google.com/| software Engineer | مهندس برمجيات|
     |https://translate.google.com/| automated testing | الاختبار الآلي |