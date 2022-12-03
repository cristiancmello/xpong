package org.cristiancmello;

public class Ball {
    private Position position;

    private Direction direction;

    private Speed speed;

    private BallStatus ballStatus;

    public Ball() {
        this.ballStatus = BallStatus.STOPPED;
    }

    public void throwFrom(Position initialPosition, Direction direction, Speed speed) {
        this.position = initialPosition;
        this.direction = direction;
        this.speed = speed;

        ballStatus = BallStatus.THROWN;
    }

    public boolean hasBeenThrown() {
        return ballStatus == BallStatus.THROWN;
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

    public void changeDirection(Direction direction) {
        if (!hasBeenStopped()) throw new RuntimeException("Cannot change direction without stop");

        this.direction = direction;
    }

    public boolean hasBeenStopped() {
        return ballStatus == BallStatus.STOPPED;
    }

    public boolean hasBeenRolling() {
        return ballStatus == BallStatus.ROLLING;
    }

    public void roll() {
        if (!hasBeenThrown()) throw new BallCannotRollException("Cannot roll because never has been thrown");

        ballStatus = BallStatus.ROLLING;

        if (direction == Direction.RIGHT) {
            position.incX();
        } else if (direction == Direction.LEFT) {
            position.decX();
        }

    }

    public void stop() {
        ballStatus = BallStatus.STOPPED;
    }
}
