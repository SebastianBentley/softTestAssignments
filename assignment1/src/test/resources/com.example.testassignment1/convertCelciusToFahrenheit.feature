Feature: Convert Celcius to Fahrenheit
  Scenario: User should be able to convert Celcius to Fahrenheit
    Given the user want to convert 10 celcius to fahrenheit
    When the user enters 10 celcius
    Then celcius is converted to 50