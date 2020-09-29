package com.mik.bowlingkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
    private Game g;

    @BeforeEach
    public void beforeEachTest() throws Exception {
        this.g = new Game();
    }

    public void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            g.roll(pins);
        }
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }
    private void rollStrike() {
        g.roll(10);
    }

    @Test
    @DisplayName("Test with all rolls zero")
    public void testWithAllZeros() throws Exception {
        rollMany(20, 0);
        int expected = 0;
        int actual = g.score();
        assertEquals(expected, actual, () -> "expected " + expected + " but received " + actual);
    }

    @Test
    @DisplayName("Test with all one in the roll")
    public void testAllOnes() throws Exception {
        this.rollMany(20, 1);
        int expected = 20;
        int actual = g.score();
        assertEquals(expected, actual, () -> "expected " + expected + " but received " + actual);
    }

    @Test
    @DisplayName("Test with one spare")
    public void testWithOneSpare() {
        rollSpare();
        g.roll(3);
        rollMany(17, 0);
        int expected = 16;
        int actual = g.score();
        assertEquals(expected, actual, () -> "expected " + expected + " but received " + actual);
    }
    @Test
    @DisplayName("Test with one strike")
    public void testWithOneStrike() {
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(16,0);
        int expected = 24;
        int actual = g.score();
        assertEquals(expected, actual, () -> "expected " + expected + " but received " + actual);
    }

}