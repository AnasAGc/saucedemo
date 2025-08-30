Feature: Books API Tests

  Scenario: Get list of books
    When I request the list of books
    Then I should receive a list of books

  Scenario: Create a new order
    When I create a new order
    Then The order should be created successfully

  Scenario: Delete the order
    When I delete the order
    Then The order should be deleted successfully
