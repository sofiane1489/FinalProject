Feature: ascending and descending test


  @sanity
  Scenario: check the functionality of set ascending and descending button
    When user navigates to luma url "https://magento.softwaretestingboard.com/"
    Then user should see title "Home Page" and luma logo should be present

    When user navigate to men category
    And  user click on top
    Then user click on the dropdown button sort by and select price
    Then  user click on set descending direction
    Then user should see "Lando Gym Jacket" at the top of the list
