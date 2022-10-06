Feature: lowercase a String
  Scenario: User should be able to convert "aBc" to "abc"
    Given there is a String "aBc"
    When the lowercase method is called with "aBc" as parameter
    Then the method returns "abc"