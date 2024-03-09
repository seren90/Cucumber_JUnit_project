Feature: Cucumber Data Tables implementation practices


  Scenario: List of fruits and vegetables I like
    Then user should see below list
      | orange     |
      | apple      |
      | kiwi       |
      | strawberry |
      | tomato     |
      | pear       |
      | eggplant   |

    #To beautify the pipes above
      #Windows: control + option + L (Strg + Alt + L)
      #MAC: command + alt + L

  Scenario: List the type of pets we love
    Then I will share my favorites
      | Kangal   |
      | Husky    |
      | Munchkin |
      | Golden   |

  Scenario: Officer reads data about driver
    Then officer is able to see any data he wants
      | name    | Jane       |
      | surname | Doe        |
      | age     | 29         |
      | address | somewhere  |
      | state   | CA         |
      | zipcode | 99999      |
      | phone   | 111-111-11 |


  Scenario: User should be able to see all 12 months in months
  dropdown
    Given User is on the dropdowns page of practice tool
    Then User should see below info in month dropdown
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |