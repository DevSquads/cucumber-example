Feature: DevSquads website
  Scenario: check existence of first photo on the Team page
    Given Browser is opened
    When I visit "https://devsquads.com/"
    Then Should find "What we offer"
