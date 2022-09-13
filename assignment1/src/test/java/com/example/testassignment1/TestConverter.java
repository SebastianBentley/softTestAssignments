package com.example.testassignment1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestConverter {

    Converter converter = new Converter();


    @Test
    public void testFahrenheitToCelcius(){
        //arrange
        double excpected = 37.7777;
        //act
        double actual = converter.fahrenheitToCelcius(100);
        //assert
        assertEquals(excpected, actual, 0.001);
    }

    @Test
    public void testFahrenheightNotANumberAsInput(){
        assertThrows(NumberFormatException.class, () -> converter.fahrenheitToCelcius(Double.valueOf("hej")));
    }


    @Test
    public void testCelciusToFahrenheit(){
        double expected = 212;
        double actual = converter.celciousToFahrenheit(100);
        assertEquals(expected, actual);
    }

    @Test
    public void testCelciusNotANumberAsInput(){
        assertThrows(NumberFormatException.class, () -> converter.celciousToFahrenheit(Double.valueOf("hej")));
    }

    @Test
    public void testFourteenArabicToRomanXIV() {
        String expected = "XIV";
        String actual = converter.convertArabicToRoman(14);
        assertEquals(expected, actual);
    }

    @Test
    public void testArabicToRomanNumberLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> converter.convertArabicToRoman(-1));
    }

    @Test
    public void testArabicToRomanNumberHigherThan4000() {
        assertThrows(IllegalArgumentException.class, () -> converter.convertArabicToRoman(5000));
    }


}
