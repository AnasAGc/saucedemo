@UI
Feature: SauceDemo Checkout

  @UI
  Scenario: Complete checkout successfully
    Given I am on the SauceDemo login page
    When  I login with valid credentials username <user> & password <Password>
    When I add one product to the cart
    And I proceed to checkout
    And I fill the checkout form with first name <FirstName>, last name <lastName>, and zip <postalcode>
    And I finish the order
    Then I should see the success message "Thank you for your order!
	
	Examples:
	| user			|	Password		|	FirstName		|	lastName	|	postalcode	|
	| standard_user |	secret_sauce	|	Anas			|	AbuGhalieh	| 	1000		|