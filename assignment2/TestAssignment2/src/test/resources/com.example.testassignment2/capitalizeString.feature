Feature: capitalize a String
  Scenario: User should be able to convert "aBc" to "ABC"
    Given there is a String "aBc"
    When the reverse string method is called with "aBc" as parameter
    Then the method returns "ABC"