Feature: Convert fahrenheit to celcius
  Scenario: User should be able to convert fahrenheit to celcius
    Given the user want to convert 100 fahrenheit to celcius
    When the user enters 100 fahrenheit
    Then fahrenheit is converted to 37.7777