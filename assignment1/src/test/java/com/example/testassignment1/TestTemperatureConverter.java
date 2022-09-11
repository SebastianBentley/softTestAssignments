package com.example.testassignment1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestTemperatureConverter {

    Converter converter = new Converter();


    @Test
    public void testFahrenheitToCelcius(){
        //arrange
        double excpected = 37.77777777777778;
        //act
        double actual = converter.fahrenheitToCelcius(100);
        //assert
        assertEquals(excpected, actual);
    }

    @Test
    public void testCelciusToFahrenheit(){
        double expected = 212;
        double actual = converter.celciousToFahrenheit(100);
        assertEquals(expected, actual);
    }

    @Test
    public void testArabicToRoman() {
        String expected = "XIV";
        String actual = converter.convertArabicToRoman(14);
        assertEquals(expected, actual);
    }


}
