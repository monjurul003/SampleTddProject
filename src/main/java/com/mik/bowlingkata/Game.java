package com.mik.bowlingkata;

public class Game {
    private int score = 0;
    public static int temp(){
        return 0;
    }

    public void roll(int pin) {
        score += pin;
    }

    public int score() {
        return score;
    }
}
