Feature: Search and Place the order for Products

  Scenario Outline: Search experience for product search in both home and offer page
    Given User is on GreenCart landing page
    When User searched with Shortname <Name> and extract actual name of product
    Then User go and search for <Name> shortname in offers page
    And validate product name in offers page matches with landing page

    Examples:
    | Name |
    | Tom |
    | Beet |