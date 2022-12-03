package org.cristiancmello;

public class Position {
    private double x;

    public Position(double initialPositionX) {
        this.x = initialPositionX;
    }

    public void incX() {
        x = x + 1;
    }

    public double getX() {
        return x;
    }

    public void decX() {
        x = x - 1;
    }
}
