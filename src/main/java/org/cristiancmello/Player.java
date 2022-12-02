package org.cristiancmello;

public class Player {
    private int score;

    public int getScores() {
        return score;
    }

    public void score(int point) {
        score += point;
    }
}