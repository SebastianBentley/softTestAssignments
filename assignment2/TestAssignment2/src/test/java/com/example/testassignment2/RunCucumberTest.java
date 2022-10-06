package com.example.testassignment2;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/com.example.testassignment2/capitalizeString.feature",
                "src/test/resources/com.example.testassignment2/lowercaseString.feature",
                "src/test/resources/com.example.testassignment2/reverseString.feature"})
public class RunCucumberTest {}