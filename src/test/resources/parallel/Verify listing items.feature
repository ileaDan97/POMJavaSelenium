Feature: Verify listing items on HomePage

  Background:
    When User is already logged in to the application
    Then Verify that the user is on homepage

  Scenario: Verify listing items are displayed on HomePage
    Then Check items are displayed on HomePage
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    And Number of products from HomePage should be 6

    Scenario: Add an item to the cart
      Given Click on the add to cart button on Home Page
      When Click on the shopping cart icon
      Then Verify that the product is displayed on the shopping cart