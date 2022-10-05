Feature: Rate a movie
  Scenario: User should be able to rate a movie
    Given The user want to rate a movie five starts
    When The user clicks five starts on a movie
    Then The users rating is set to five stars