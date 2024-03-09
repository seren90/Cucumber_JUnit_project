Feature:  Some of the general functionality verifications


  Scenario: Dropdown options verification
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user sees below options under product dropdown
      | MoneyCog   |
      | Familybea  |
      | Screenable |

  Scenario: Payment options verification
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user sees Visa as enabled payment option
    Then user sees Mastercard as enabled payment option
    Then user sees American Express as enabled payment option


  Scenario: Order placement scenario
    Given user is already logged in to The Web table app
    When user is on the Order page
    And user enters Quantity "2"
    Then  user clicks to the calculate button
    And user enters customer name "Jane Doe"
    And user enters street "7 th Street"
    And user enters city "New York"
    And user enters state "New York"
    And user enters zip "99999"
    And user selects payment option "American Express"
    And user enters credit card number "1111222233334444"
    And user enters expiration date"12/25"
    And user clicks to process order button
    Then user should see "Jane Doe" in the first row of the web table

  @wip
  Scenario Outline: Order placement scenario
    Given user is already logged in to The Web table app
    When user is on the Order page
    And user enters Quantity "<quantity>"
    Then  user clicks to the calculate button
    And user enters customer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zip "<zip>"
    And user selects payment option "<payment>"
    And user enters credit card number "<cardNumber>"
    And user enters expiration date"<expirationDate>"
    And user clicks to process order button
    Then user should see "<expectedName>" in the first row of the web table

    Examples:
      | quantity | customerName | street      | city | state | zip   | payment | cardNumber       | expirationDate | expectedName |
      | 3        | John Doe     | s7th street | NY   | NY    | 99999 | Visa    | 1111222233334444 | 12/25          | John Doe     |
      | 3        | Seren Sila   | s7th street | NY   | NY    | 99999 | Visa    | 1111222233334444 | 12/25          | Seren Sila   |
      | 3        | Cihan Sila   | s7th street | NY   | NY    | 99999 | Visa    | 1111222233334444 | 12/25          | Cihan Sila   |
     # | 3        | Rüzgar Sila  | s7th street | NY   | NY    | 99999 | Visa    | 1111222233334444 | 12/25          | Rüzgar Sila  |


