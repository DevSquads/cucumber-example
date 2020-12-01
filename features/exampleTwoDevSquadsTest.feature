Feature: DevSquads website
  Scenario Outline: check existence of first photo on the Team page
    Given Browser is opened and on "<website>"
    When Hover over about tab
    And Click on Teams
    Then Should find "<answer>"


    Examples:
      | website                | answer          |
      | https://devsquads.com/ | Amr Elssamadisy |