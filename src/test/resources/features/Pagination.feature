Feature: Navigation through Paginated Data
  As a user,I want to navigate through paginated data
  So that I can view different pages of the data

  @regression
  Scenario:Verify pagination navigation
    When user navigates to luma url "https://magento.softwaretestingboard.com/"
    Then user should see title "Home Page" and luma logo should be present

    When I click on the Men category
    Then I click on Top
    Then I see the Top page displayed with tile "Tops"

    And  I click on the 'PageNext' link
    Then I should be on the next page of the results and i should see "Items 13-24 of 48"

    And  I click on the 'PagePrevious' link
    Then I should be back on the previous page and i should see "Items 1-12 of 48"

    When I repeat: Click on the Next link until reaching the last page with title "Items 37-48 of 48"
    Then I repeat: Click on the previous link until reaching the first page with title "Items 1-12 of 48"

