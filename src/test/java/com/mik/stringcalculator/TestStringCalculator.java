package com.mik.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
    @DisplayName("Test with comma separated two numbers in the string")
    public void testWithCommaSeparatedTwoNumbers() {
        int expected = 3;
        int actual = calculator.add("1,2");
        assertEquals(expected, actual, () -> "should return " + expected + " but returned " + actual);
    }

    @Test
    @DisplayName("Test with comma separated multiple numbers in the string")
    public void testWithCommaSeparatedMultipleNumbers() {
        int expected = 6;
        int actual = calculator.add("1,2,3");
        assertEquals(expected, actual, () -> "should return " + expected + " but returned " + actual);
    }

    @Test
    @DisplayName("Test with comma separated multiple numbers with new line command in the string")
    public void testWithCommaAndNewLineSeparatedMultipleNumbers() {
        int expected = 6;
        int actual = calculator.add("1,2\n3");
        assertEquals(expected, actual, () -> "should return " + expected + " but returned " + actual);
    }

    @Test
    @DisplayName("Test with custom delimiter in the string")
    public void testWithCustomDelimiter() {
        int expected = 3;
        int actual = calculator.add("//;\n1;2");
        assertEquals(expected, actual, () -> "should return " + expected + " but returned " + actual);
    }

    @Test
    @DisplayName("Test with negative number in the string")
    public void testWithNegativeNumber() {
        try {
            calculator.add("1,-2,3,-4");
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("Negatives not allowed: [-2, -4]", ex.getMessage());
        }

    }

}
