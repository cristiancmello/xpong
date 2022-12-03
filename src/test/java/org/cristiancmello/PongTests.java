package org.cristiancmello;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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
        var initialPosition = new Position();
        var direction = new Direction();
        var speed = new Speed();

        ball.throwFrom(initialPosition, direction, speed);

        assertThat(ball.hasBeenThrown()).isEqualTo(true);
        assertThat(ball.getPosition()).isEqualTo(initialPosition);
        assertThat(ball.getDirection()).isEqualTo(direction);
        assertThat(ball.getSpeed()).isEqualTo(speed);
    }
}
