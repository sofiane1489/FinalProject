Feature: Verify Product Zoom Functionality

  @zoom
  Scenario: Verify the zoom functionality on the product details page
    Given User navigates to luma url "https://magento.softwaretestingboard.com/"
    Then User should see title "Home Page" and Luma logo should be present
    When User clicks on the Men category
    And User clicks on Top
    When user clicks on product name Sparta Gym Tank

    And User hovers over the product image and clicks
    When user clicks on zoom-in button and verifies the image is zoomed-in
