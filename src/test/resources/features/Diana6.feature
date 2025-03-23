Feature: Verify Unique User IDs in Database

  Background:
    Given Establish the database connection

    @smoke
    Scenario: verify users has unique IDs

    When Execute query to get all IDs from users
    Then verify all users has unique ID




