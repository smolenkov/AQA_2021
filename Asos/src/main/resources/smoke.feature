Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Change language of the site
    Given User opens '<url>' page
    And User clicks choose country icon
    And User select country '<country>'
    Then User checks that the inscription SHOPPING FROM: is changed on '<inscription>'
    Examples:
      | url                         | country | inscription     |
      | https://www.asos.com/women/ | Germany | EINKAUFEN AUS |
      | https://www.asos.com/men/   | Italy   | ACQUISTA DA   |

  Scenario Outline: Check the search results page
    Given User opens '<url>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User check that search page contains '<search title>'
    Examples:
    |url                            |keyword              |search title       |
    |https://www.asos.com/men/      |Timberland boots     |"Timberland boots" |
    |https://www.asos.com/women/    |Cucumber             |"Cucumber"         |

    Scenario Outline: Check the sorting of search results
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
      | url                        | keyword |
      |https://www.asos.com/women/ |Dr Martens  |
      |https://www.asos.com/men/   |Dr Martens  |

    Scenario Outline: Check entry in the e-mail field
      Given User opens '<url>' page
      And User click sign-up button
      And User check that sign-up page is open
      And User check that entered '<email>' is valid or displays an '<error>'

      Examples:
        | url                        | email           |error       |
        |https://www.asos.com/women/ | smolenkov@gmail |            |
        |https://www.asos.com/men/   | @               |Email fail! |
        |https://www.asos.com/women/ | just@example    |            |
        |https://www.asos.com/men/   | 1@@1            |Email fail! |

  Scenario Outline: Check the sorting of search results
    Given User opens '<url>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User click on first product
    And User check that product page is opens
    And User click on addToCart button
    And User check that product is into the cart
    Examples:
      |url                         |keyword     |
      |https://www.asos.com/women/ |Sunglasses  |
      |https://www.asos.com/men/   |Sunglasses  |
