Feature: Search a product and add to cart


  @PlaceOrder
  Scenario Outline: Add a product to cart and find where added product is right
    Given User search a product <Name> and check actual name of product
    Then Add more number of same product
    And Click on add to cart
    Then Go to basket
    And Click on proceed to checkout
    Then Validate the product name on cart page
    And Validate Apply and Place Order button is displayed

    Examples:
    | Name |
    | Tom  |


