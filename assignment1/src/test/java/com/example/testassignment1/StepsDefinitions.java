package com.example.testassignment1;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepsDefinitions {
    private double celcius;
    private double result;
    private double fahrenheit;
    private int arabic;
    private String roman;
    private Converter converter;
    private Integer rating;
    private double ratingAverange;
    private User user;
    private Movie movie;

    @Given("^the user want to convert (\\d+) celcius to fahrenheit$")
    public void the_user_want_to_convert_celcius_to_fahrenheit(int arg1) throws Exception {
        converter = new Converter();
    }

    @When("^the user enters (\\d+) celcius$")
    public void the_user_enters_celcius(int arg1) throws Exception {
        celcius = 10.0;
    }

    @Then("^celcius is converted to (\\d+)$")
    public void celcius_is_converted_to(int arg1) throws Exception {
        result = converter.celciousToFahrenheit(celcius);
        assertEquals(arg1, result);
    }


    @Given("^the user want to convert (\\d+) fahrenheit to celcius$")
    public void the_user_want_to_convert_fahrenheit_to_celcius(int arg1) throws Exception {
        converter = new Converter();
    }

    @When("^the user enters (\\d+) fahrenheit$")
    public void the_user_enters_fahrenheit(int arg1) throws Exception {
        fahrenheit = 100;
    }

    @Then("^fahrenheit is converted to (\\d+)\\.(\\d+)$")
    public void fahrenheit_is_converted_to(int arg1, int arg2) throws Exception {
        result = converter.fahrenheitToCelcius(fahrenheit);
        assertEquals(37.777, result, 0.001);
    }
    @Given("^user wants to convert (\\d+) to roman numerals$")
    public void user_wants_to_convert_to_roman_numerals(int arg1) throws Exception {
        converter = new Converter();
    }

    @When("^user enters (\\d+)$")
    public void user_enters(int arg1) throws Exception {
        arabic = 14;
    }

    @Then("^(\\d+) is converted to \"([^\"]*)\"$")
    public void is_converted_to(int arg1, String arg2) throws Exception {
        roman = converter.convertArabicToRoman(arabic);
        assertEquals("XIV", roman);
    }

    @Given("^The user want to rate a movie five starts$")
    public void the_user_want_to_rate_a_movie_five_starts() throws Exception {
        user = new User();
        movie = new Movie("Titanic");
    }

    @When("^The user clicks five starts on a movie$")
    public void the_user_clicks_five_starts_on_a_movie() throws Exception {
        user.rateMovie(movie, 5);
    }

    @Then("^The movies rating for the user is five stars$")
    public void the_movies_rating_is_set() throws Exception {
        assertEquals(movie.getRating(), 5);
    }


}
