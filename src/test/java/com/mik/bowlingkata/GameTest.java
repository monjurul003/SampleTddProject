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

    @Test
    @DisplayName("Test with all rolls zero")
    public void testGame() throws Exception {
        rollMany(20, 0);
        assertEquals(0, g.score(), () -> "expected 0 but got something else");
    }

    @Test
    @DisplayName("Test with all one in the roll")
    public void testAllOnes() throws Exception {
        this.rollMany(20, 1);
        assertEquals(20, g.score(), () -> "expected 20 but got something else");
    }

    @Test
    @Disabled
    @DisplayName("Test with one spare")
    public void testWithOneSpare() {
        g.roll(5);
        g.roll(5); //spare
        g.roll(3);
        rollMany(17, 0);
        int expected = 16;
        int actual = g.score();
        assertEquals(16, actual, () -> "expected " + expected + " but received " + actual);
    }

}