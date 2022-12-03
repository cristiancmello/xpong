package org.cristiancmello;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class PongTests {
    /* MinPong: despreze regras, a ideia de jogo em si, pense apenas na parte "física", das colisões, a bola */
    /*
        1.
           Ball: *
           Action 'throwFrom(initialPosition, direction, speed)'
           ?      hasBeenThrown
    */
    @Test
    void givenBall_whenBallThrowFromWithInitialPositionDirectionSpeed_thenHasBeenThrown() {
        var ball = new Ball();
        var initialPosition = new Position(1.0);
        var direction = Direction.RIGHT;
        var speed = new Speed();

        ball.throwFrom(initialPosition, direction, speed);

        assertThat(ball.hasBeenThrown()).isEqualTo(true);
        assertThat(ball.getPosition()).isEqualTo(initialPosition);
        assertThat(ball.getDirection()).isEqualTo(direction);
        assertThat(ball.getSpeed()).isEqualTo(speed);
    }

    @Test
    void givenBall_whenAskRideWithoutThrown_thenExceptionNoRide() {
        var ball = new Ball();

        assertThrows(BallCannotRideException.class, ball::ride, "No can Ride because The Ball never thrown");
    }

    @Test
    void givenBallThrown_whenAskRideRightDirection_thenShouldRideRightDirection() {
        var ball = new Ball();
        var initialPositionX = 1.0;
        var initialPosition = new Position(initialPositionX);
        var direction = Direction.RIGHT;
        var speed = new Speed();

        ball.throwFrom(initialPosition, direction, speed);

        assertThat(ball.getPosition().getX()).isEqualTo(initialPositionX);

        ball.ride();

        assertThat(ball.getPosition().getX()).isGreaterThan(initialPositionX);
    }
}