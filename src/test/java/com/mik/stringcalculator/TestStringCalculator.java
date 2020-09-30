package com.mik.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStringCalculator {
    StringCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("Test with empty string")
    public void testWithEmptyString() {
        int expected = 0;
        int actual = calculator.add("");
        assertEquals(expected, actual, () -> "should return " + expected + " but returned " + actual);
    }

    @Test
    @DisplayName("Test with single number in the string")
    public void testWithOneNumber() {
        int expected = 1;
        int actual = calculator.add("1");
        assertEquals(expected, actual, () -> "should return " + expected + " but returned " + actual);
    }
    @Test
    @DisplayName("Test with comma separated two number in the string")
    public void testWithTwoCommaSeparatedNumber() {
        int expected = 3;
        int actual = calculator.add("1,2");
        assertEquals(expected, actual, () -> "should return " + expected + " but returned " + actual);
    }

}
