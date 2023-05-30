Feature: search bar feature
  As a user
  I want to search for products
  So that I can find what I need


  Background:
    Given user navigates to luma url "https://magento.softwaretestingboard.com/"
    Then user should see title "Home Page" and luma logo should be present

  @smoke
  Scenario: Searching for a product

    And i type  product name "bag for men" in the search bar
    Then i should get the search result "Search results for: 'bag for men'"