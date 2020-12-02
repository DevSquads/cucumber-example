Feature: DevSquads website
  Scenario: check existence of About us section
    Given I visit "https://devsquads.com/"
    Then Should find a section title containing "About us"
