Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Change language of the site
    Given User opens '<url>' page
    And User clicks choose country icon
    And User select country '<country>'
    And User clicks update preferences button
    Then User checks that the inscription SHOPPING FROM: is changed on '<inscription>'
    Examples:
      | url                         | country | inscription   |
      | https://www.asos.com/women/ | Germany | EINKAUFEN AUS |
      | https://www.asos.com/men/   | Italy   | ACQUISTA DA   |

  Scenario Outline: Check  search results page
    Given User opens '<url>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User checks that search page contains '<search title>'
    Examples:
    |url                            |keyword              |search title       |
    |https://www.asos.com/men/      |Timberland boots     |"Timberland boots" |
    |https://www.asos.com/women/    |Cucumber             |"Cucumber"         |

    Scenario Outline: Check  sorting of search results
      Given User opens '<url>' page
      And User checks search field visibility
      When User makes search by keyword '<keyword>'
      And User clicks search button
      And User selects sort price high to low
      And User checks that first product is most expensive
      Examples:
        |url                         |keyword     |
        |https://www.asos.com/women/ |Dr Martens  |
        |https://www.asos.com/men/   |Timberland  |

  Scenario Outline: Add product to saved page
    Given User opens '<url>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User adds first product to saved page
    And User opens saved page
    And User checks that product contains on saved page
    Examples:
      | url                        | keyword    |
      |https://www.asos.com/women/ |Dr Martens  |
      |https://www.asos.com/men/   |Dr Martens  |
      |https://www.asos.com/women/ |adidas      |
      |https://www.asos.com/men/   |adidas      |
      |https://www.asos.com/women/ |Dr Martens  |
      |https://www.asos.com/men/   |Dr Martens  |

    Scenario Outline: Check entry in the e-mail field (positive and negative)
      Given User opens '<url>' page
      And User clicks sign-up button
      And User checks that sign-up page is open
      And User checks that entered '<email>' is valid or displays an '<error>'

      Examples:
        | url                        | email           |error       |
        |https://www.asos.com/women/ | smolenkov@gmail |            |
        |https://www.asos.com/men/   | @               |Email fail! |
        |https://www.asos.com/women/ | just@example    |            |
        |https://www.asos.com/men/   | 1@@1            |Email fail! |

  Scenario Outline: Check  adding product into the cart
    Given User opens '<url>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And User checks that product page is opens
    And User clicks on addToCart button
    And User checks that count of product in cart is '<count>'
    Examples:
      |url                         |keyword     | count |
      |https://www.asos.com/women/ |Sunglasses  |1      |
      |https://www.asos.com/men/   |Sunglasses  |1      |

  Scenario Outline: Сhecking if a product has been removed from the cart
    Given User opens '<url>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And User checks that product page is opens
    And User clicks on addToCart button
    And User checks that count of product in cart is '<count>'
    And User clicks on cart icon
    And User clicks on delete product button
    And User checks that cart is empty
    Examples:
      |url                         |keyword     |count |
      |https://www.asos.com/women/ |Sunglasses  |1     |
      |https://www.asos.com/men/   |Sunglasses  |1     |

  Scenario Outline: Change of currency in product cards
    Given User opens '<url>' page
    And User clicks choose country icon
    And User select country '<country>'
    And User select currency '<currency>'
    And User clicks update preferences button
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User checks that prefix in price equals '<prefix>'
    Examples:
      | url                         | country | currency |keyword |prefix|
      | https://www.asos.com/women/ | Japan   | USD      |cap     |$     |
      | https://www.asos.com/men/   | Japan   | GBP      |cap     |£     |

  Scenario Outline: Checking broken inner links
    Given User opens '<url>' page
    And User clicks marketplace link
    And User checks that all links on page isn't broken
    Examples:
      | url                         |
      | https://www.asos.com/women/ |


