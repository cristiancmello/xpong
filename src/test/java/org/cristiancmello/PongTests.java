package org.cristiancmello;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PongTests {
    @Test
    void givenBall_whenAskDefaultStatus_thenBeStopped() {
        var ball = new Ball();

        assertThat(ball.hasBeenStopped()).isTrue();
        assertThat(ball.hasBeenThrown()).isFalse();
        assertThat(ball.hasBeenRolling()).isFalse();
    }

    @Test
    void givenBall_whenBallThrowFromWithInitialPositionDirectionSpeed_thenHasBeenThrown() {
        var ball = new Ball();
        var initialPosition = new Position(1.0);
        var direction = Direction.RIGHT;
        var speed = new Speed();

        ball.throwFrom(initialPosition, direction, speed);

        assertThat(ball.hasBeenThrown()).isTrue();
        assertThat(ball.hasBeenStopped()).isFalse();
        assertThat(ball.hasBeenRolling()).isFalse();
        assertThat(ball.getPosition()).isEqualTo(initialPosition);
        assertThat(ball.getDirection()).isEqualTo(direction);
        assertThat(ball.getSpeed()).isEqualTo(speed);
    }

    @Test
    void givenBall_whenBallRollWithoutThrown_thenExceptionNoRoll() {
        var ball = new Ball();

        assertThatExceptionOfType(BallCannotRollException.class)
            .isThrownBy(ball::roll)
            .withMessage("Cannot roll because never has been thrown");
    }

    @Test
    void givenBallThrown_whenBallRollRightDirection_thenShouldRollingRightDirection() {
        var ball = new Ball();
        var initialPositionX = 1.0;
        var initialPosition = new Position(initialPositionX);
        var direction = Direction.RIGHT;
        var speed = new Speed();

        ball.throwFrom(initialPosition, direction, speed);

        assertThat(ball.getPosition().getX()).isEqualTo(initialPositionX);

        ball.roll();

        assertThat(ball.hasBeenRolling()).isTrue();
        assertThat(ball.hasBeenStopped()).isFalse();
        assertThat(ball.hasBeenThrown()).isFalse();
        assertThat(ball.getPosition().getX()).isGreaterThan(initialPositionX);
    }

    @Test
    void givenBallThrown_whenBallRollLeftDirection_thenShouldRollingLeftDirection() {
        var ball = new Ball();
        var initialPositionX = 1.0;
        var initialPosition = new Position(initialPositionX);
        var direction = Direction.LEFT;
        var speed = new Speed();

        ball.throwFrom(initialPosition, direction, speed);

        assertThat(ball.getPosition().getX()).isEqualTo(initialPositionX);

        ball.roll();

        assertThat(ball.hasBeenRolling()).isTrue();
        assertThat(ball.hasBeenStopped()).isFalse();
        assertThat(ball.hasBeenThrown()).isFalse();
        assertThat(ball.getPosition().getX()).isLessThan(initialPositionX);
    }

    @Test
    void givenBallThrown_whenChangeDirectionWhileRollingWithoutStop() {
        var ball = new Ball();
        var initialPositionX = 1.0;
        var initialPosition = new Position(initialPositionX);
        var direction = Direction.RIGHT;
        var speed = new Speed();

        ball.throwFrom(initialPosition, direction, speed);
        ball.roll();

        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> {
                ball.changeDirection(Direction.LEFT);
            }).withMessage("Cannot change direction without stop");

        assertThat(ball.getDirection()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void givenBallThrown_whenRollAndStopped_thenStopped() {
        var ball = new Ball();
        var initialPositionX = 1.0;
        var initialPosition = new Position(initialPositionX);
        var direction = Direction.RIGHT;
        var speed = new Speed();

        ball.throwFrom(initialPosition, direction, speed);
        ball.roll();
        ball.stop();

        assertThat(ball.hasBeenStopped()).isTrue();
        assertThat(ball.hasBeenThrown()).isFalse();
        assertThat(ball.hasBeenRolling()).isFalse();
    }

    @Test
    void givenBallThown_whenChangeDirectionToLeft_thenDirectionIsLeft() {
        var ball = new Ball();
        var initialPositionX = 1.0;
        var initialPosition = new Position(initialPositionX);
        var direction = Direction.RIGHT;
        var speed = new Speed();

        ball.throwFrom(initialPosition, direction, speed);
        ball.roll();
        ball.stop();

        ball.changeDirection(Direction.LEFT);

        assertThat(ball.getDirection()).isEqualTo(Direction.LEFT);
    }

    @Test
    void givenBallThown_whenChangeDirectionToRight_thenDirectionIsRight() {
        var ball = new Ball();
        var initialPositionX = 1.0;
        var initialPosition = new Position(initialPositionX);
        var direction = Direction.LEFT;
        var speed = new Speed();

        ball.throwFrom(initialPosition, direction, speed);
        ball.roll();
        ball.stop();

        ball.changeDirection(Direction.RIGHT);

        assertThat(ball.getDirection()).isEqualTo(Direction.RIGHT);
    }
}