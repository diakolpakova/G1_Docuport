Feature:

  Background:

Given Establish the database connection

@db
Scenario: verify users has unique IDs
When Execute query to get all IDs from users
Then verify all users has unique ID




