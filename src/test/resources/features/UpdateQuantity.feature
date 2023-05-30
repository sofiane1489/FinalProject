Feature: Update Quantity


@update
Scenario: User updates the quantity of an item

  Given user navigates to luma url "https://magento.softwaretestingboard.com/"
  Then user should see title "Home Page" and luma logo should be present

  And  user hover over Gear category and clicks on Watches
  Then user clicks on item Dash Digital Watch
  And  user update the quantity to "3"
  Then user clicks on Add To Cart button
  Then the updated quantity "3" should be displayed in the shopping cart