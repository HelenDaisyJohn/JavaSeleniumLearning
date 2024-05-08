
@tag
Feature: Purchase the order from the Ecoomerse website
  I want to use this template for my feature file
  Background:
  Given: I landed on Ecommerce page

  @tag2
  Scenario Outline: Positive scenarios of the Submitting order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order	
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage
    Examples: 
      | name  										| password 			 | productName  	 |
      | helendaisy.john@gmail.com |     Helen#1989 | ADIDAS ORIGINAL |
      