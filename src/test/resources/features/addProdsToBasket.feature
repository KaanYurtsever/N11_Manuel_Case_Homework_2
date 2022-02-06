Feature: Add products to the basket

  @addtobasket
  Scenario: Add wanted products to the basket
    Given User opens the browser and goes to the home page and search the product "aphone"
    When User adds products to the basket and increases cheapest product quantity
    Then User continues as guest and pays with wrong card number then fail