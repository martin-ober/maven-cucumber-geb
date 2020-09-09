Feature: Foobar

  Scenario: Navigate to Foobar
    Given I'm at the index page
    When I click 'Foobar'
    Then I see the foobar page

  Scenario: Foobar
    Given I'm at the foobar page
    When I enter foobar 1.0
    Then I see the foobar submit page
    And I see on page foobar submit the value foobar for foo
    And I see on page foobar submit the value 1.0 for bar