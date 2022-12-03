package org.cristiancmello;

public class Ball {
    private boolean hasBeenThrown;
    private Position position;
    private Direction direction;
    private Speed speed;

    public void throwFrom(Position initialPosition, Direction direction, Speed speed) {
        this.position = initialPosition;
        this.direction = direction;
        this.speed = speed;

        hasBeenThrown = true;
    }

    public boolean hasBeenThrown() {
        return hasBeenThrown;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void ride() {
        if (!hasBeenThrown) throw new BallCannotRideException("No side because The Ball never Thrown");

        position.incX();
    }
}
