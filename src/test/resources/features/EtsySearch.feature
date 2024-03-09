@etsyPage
Feature: Etsy search functionality
  Agile Story: User should be able to type any keyword and see relevant information

  Scenario: Etsy Title Verification
    Given user is on the homepage
    Then user should see title is as expected
    #Expected title: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

  Scenario: Etsy Search Functionality Title Verification (without parameterization)
    Given user is on the homepage
    When User types Wooden Spoon in the search box
    And User clicks search button
    Then User sees Wooden Spoon is in the title


  Scenario: Etsy Search Functionality Title Verification (with parameterization)
      Given user is on the homepage
      When User types "Wooden Spoon" in the search box
      And User clicks search button
      Then User sees "Wooden spoon - Etsy DE" is in the title