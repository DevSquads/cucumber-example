Feature: DevSquads website
  Scenario Outline: check existence of first photo on the Team page
    Given Browser is opened
    When I visit "<website>"
    Then Should find "<answer>"


    Examples:
      | website                | answer        |
      | https://devsquads.com/ | What we offer |