Feature: Reorder Previous Orders


 @Reorder
  Scenario: Verify the functionality to reorder previous orders
    Given User navigates to luma url "https://magento.softwaretestingboard.com/"
    Then User should see title "Home Page" and Luma logo should be present
    And  user clicks on sign in button
    Then user enter email address "reorderprevious@gmail.com"
    And  user enter password "1234Abcd$"
    Then user clicks on login in button

    Then user clicks on the upper right corner dropdown
    And  user clicks on My Account

    Then user clicks on the reorder link associated with a specific order that needs to be reordered.
    Then user clicks on proceed to checkout button
    When user selects a shipping method and clicks on next
    And  user clicks on place order
    Then user should sees thanks message "Thank you for your purchase!"

