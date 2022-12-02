package org.cristiancmello;

public class Ball {
    private int positionX;
    private int finalPositionX;
    private int initialPositionX;

    public void go(int initialPositionX) {
        this.initialPositionX = initialPositionX;
        this.finalPositionX = 1;
        this.positionX = finalPositionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getInitialPositionX() {
        return initialPositionX;
    }

    public int getFinalPositionX() {
        return finalPositionX;
    }
}