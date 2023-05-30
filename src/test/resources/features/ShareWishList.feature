Feature: Share Wish List


@share
Scenario: User shares a wish list via email
  Given User navigates to luma url "https://magento.softwaretestingboard.com/"
  Then User should see title "Home Page" and Luma logo should be present
  And  user clicks on sign in button
  Then user enter email address "reorderprevious@gmail.com"
  And  user enter password "1234Abcd$"
  Then user clicks on login in button

  Then user clicks on the upper right corner dropdown
  And  user clicks on My Account
  Then user clicks on Go to Wish List link
  Then user clicks on Share Wish List link
  Then user enters email Address "qwerty@test.com"
  And  type a message "this is my wish list"
  And user clicks on Share Wish List button
  Then user gets a confirmation message "Your wish list has been shared."