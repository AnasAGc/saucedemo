Feature: SauceDemo Checkout

  Scenario: Complete checkout successfully
    Given I am on the SauceDemo login page
    When I login with valid credentials
    And I add one product to the cart
    And I proceed to checkout
    And I fill the checkout form with first name, last name, and zip
    And I finish the order
    Then I should see the success message "Thank you for your order!"
