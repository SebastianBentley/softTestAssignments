package com.example.testassignment2;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Honestly, don't think I have this Cucumber thing quite right.
public class StepsDefinition {
    String result;

    @Given("^there is a String \"([^\"]*)\"$")
    public void there_is_a_String(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        arg1 = "aBc";
    }

    @When("^the reverse string method is called with \"([^\"]*)\" as parameter$")
    public void the_reverse_string_method_is_called_with_as_parameter(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        result = BootlegStringUtils.reverseString("aBc");
    }

    @Then("^the method returns \"([^\"]*)\"$")
    public void the_method_returns(String arg1) throws Exception {
        result = BootlegStringUtils.reverseString("aBc");
        assertEquals("cBa", result);
    }


    @When("^the lowercase method is called with \"([^\"]*)\" as parameter$")
    public void the_lowercase_method_is_called_with_as_parameter(String arg1) throws Exception {
        String expected = "abc";
        String actual = BootlegStringUtils.lowercaseString("aBc");
        assertEquals(expected, actual);
    }









}
