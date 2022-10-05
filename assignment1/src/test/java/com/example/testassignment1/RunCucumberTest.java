package com.example.testassignment1;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/com.example.testassignment1/convertFahrenheitToCelcius.feature",
                "src/test/resources/com.example.testassignment1/convertCelciusToFahrenheit.feature",
                "src/test/resources/com.example.testassignment1/convertArabicToRoman.feature",
                 "src/test/resources/com.example.testassignment1/ratingFeature.feature"})
public class RunCucumberTest {


}
