package com.mik.bowlingkata;

public class Game {
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pin) {
        rolls[currentRoll++] = pin;
    }

    public int score() {
        int score = 0;
        for (int i = 0; i < 20; i++) {
            score += rolls[i];
        }
        return score;
    }
}
