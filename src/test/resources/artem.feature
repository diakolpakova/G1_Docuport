Feature: Advisor Cannot Create Client Without Required Fields

  @AA
  Scenario: As Advisor create a new client wit empty first and last name inputs
    Given Advisor is logged in
    Then user clicks "Clients" on "left navigation Page"
    When  on "Clients" page user clicks "Create tne client" dropdown > "Personal"
    When create new client window popped up user clicks "create new user" checkbox
    Then user fills out all required fields except first and last name
    And user clicks save
    Then an error message should be displayed
    And validate that user was not created
