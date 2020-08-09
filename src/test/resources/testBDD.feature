Feature: This is a test feature

  Scenario: Verify A/B Testing page
    Given I click on A/B Testing link

    Then I check that AB header is displayed as expected
    And I check that AB paragraph is displayed as expected

  Scenario: Verify Add Remove Elements page
    Given I click on Add/Remove Elements link

    Then I check that AddRemoveElements page header is displayed as expected
    And I check that Delete button appears when Add Element button is clicked
