Feature: Convert arabic numeral to roman numeral
  Scenario: User should be able to convert arabic numerals to romal numerals
    Given user wants to convert 14 to roman numerals
    When user enters 14
    Then 14 is converted to "XIV"