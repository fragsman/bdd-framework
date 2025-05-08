Feature: Short Selenium Tests for AskOmCdh page

  #I will make it fail on purpose just to see a failure on the report
  @smoke
  Scenario: Store link functionality
    Given user selects the "Store" link
    Then user should see in the search title "ShoeXXX"

  @smoke
  Scenario: Men link functionality
    Given user selects the "Men" link
    Then user should see in the search title "Men"

  @smoke
  Scenario: Search functionality using Selenium Actions
    Given user selects the "Men" link
    And user performs a special search for "Shoes"
    Then user should see in the search results '“Shoes”'

  @smoke
  #This is test is meant to show soft assert, where one assertion passes and the other fails
  Scenario: Women link functionality
    Given user selects the "Women" link
    Then user should see in "Women" in page title and "W1men" in current navigation page

