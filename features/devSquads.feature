Feature: DevSquads website
  Scenario: check existence of first photo on the Team page
    Given Browser is opened and on DevSquads website
    When Hover over about tab
    And Click on Teams
    Then Should find Amr Elssamadisy