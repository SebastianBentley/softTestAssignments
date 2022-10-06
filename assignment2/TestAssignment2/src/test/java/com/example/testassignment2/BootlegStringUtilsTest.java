package com.example.testassignment2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BootlegStringUtilsTest {

    @Test
    public void testReverseStringSmall() {
        //arrange
        String expected = "cBa";
        //act
        String actual = BootlegStringUtils.reverseString("aBc");
        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void testReverseSpecialCharacters() {
        String expected = "2-.,";
        String actual = BootlegStringUtils.reverseString(",.-2");
        assertEquals(expected, actual);
    }

    @Test
    public void testReverseLongString() {
        String expected = "poiuytrewqlkjhgfdsamnbvcxzpoiuytrewqlkjhgfdsamnbvcxzpoiuytrewqlkjhgfdsamnbvcxzpoiuytrewqlkjhgfdsamnbvcxz";
        String actual = BootlegStringUtils.reverseString("zxcvbnmasdfghjklqwertyuiopzxcvbnmasdfghjklqwertyuiopzxcvbnmasdfghjklqwertyuiopzxcvbnmasdfghjklqwertyuiop");
        assertEquals(expected, actual);
    }

    @Test
    public void testReverseEmptyString() {
        String expected = "";
        String actual = BootlegStringUtils.reverseString("");
        assertEquals(expected, actual);
    }

    @Test
    public void testUpperCaseSmallString() {
        String expected = "HEJ";
        String actual = BootlegStringUtils.capitalizeString("hej");
        assertEquals(expected, actual);
    }

    @Test
    public void testUpperCaseSmallSpecialCharacters() {
        String expected = "HEJ,.";
        String actual = BootlegStringUtils.capitalizeString("hej,.");
        assertEquals(expected, actual);
    }

    @Test
    public void testUpperCaseLargeString() {
        String expected = "HEJMEDDIGJEGHEDDERKAJHEJMEDDIGJEGHEDDERKAJHEJMEDDIGJEGHEDDERKAJ";
        String actual = BootlegStringUtils.capitalizeString("hejmeddigjeghedderkajhejmeddigjeghedderkajhejmeddigjeghedderkaj");
        assertEquals(expected, actual);
    }

    @Test
    public void testUpperCaseEmptyString() {
        String expected = "";
        String actual = BootlegStringUtils.capitalizeString("");
        assertEquals(expected, actual);
    }

    @Test
    public void testUpperCaseWeirdString() {
        String expected = "ABCD";
        String actual = BootlegStringUtils.capitalizeString("AbCd");
        assertEquals(expected, actual);
    }

    @Test
    public void testLowerCaseSmallString() {
        String expected = "hej";
        String actual = BootlegStringUtils.lowercaseString("HEJ");
        assertEquals(expected, actual);
    }

    @Test
    public void testLowerCaseSmallSpecialCharacters() {
        String expected = "hej,.";
        String actual = BootlegStringUtils.lowercaseString("HEJ,.");
        assertEquals(expected, actual);
    }

    @Test
    public void testLowerCaseLargeString() {
        String expected = "hejmeddigjeghedderkajhejmeddigjeghedderkajhejmeddigjeghedderkaj";
        String actual = BootlegStringUtils.lowercaseString("HEJMEDDIGJEGHEDDERKAJHEJMEDDIGJEGHEDDERKAJHEJMEDDIGJEGHEDDERKAJ");
        assertEquals(expected, actual);
    }

    @Test
    public void testLowerCaseEmptyString() {
        String expected = "";
        String actual = BootlegStringUtils.lowercaseString("");
        assertEquals(expected, actual);

    }

    @Test
    public void testLowerCaseWeirdString() {
        String expected = "abcd";
        String actual = BootlegStringUtils.lowercaseString("AbCd");
        assertEquals(expected, actual);

    }

}
