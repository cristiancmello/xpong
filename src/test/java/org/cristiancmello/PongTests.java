package org.cristiancmello;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PongTests {
    private Player playerOne;

    private Player playerTwo;

    private PlayingArea playingArea;

    private Ball ball;

    private Referee referee;

    @BeforeEach
    public void setup() {
        playerOne = new Player();
        playerTwo = new Player();
        playingArea = new PlayingArea();
        ball = new Ball();
        referee = new Referee();

        playingArea.receivePlayer(playerOne);
        playingArea.receivePlayer(playerTwo);
        playingArea.receiveBall(ball);

        referee.watchPlayingArea(playingArea);
    }

    @Test
    void whenBallCrossesPlayerTwoCoveredArea_thenPlayerOneScore() {
        ball.setPositionX(playingArea.getL4PositionX());

        referee.watchGame();

        assertThat(playerOne.getScores()).isEqualTo(1);
    }

    @Test
    void whenBallCrossesPlayerOneCoveredArea_thenPlayerTwoScore() {
        ball.setPositionX(playingArea.getL2PositionX());

        referee.watchGame();

        assertThat(playerTwo.getScores()).isEqualTo(1);
    }

    @Test
    void whenRefereeStartGame_thenGetStartedGameFlag() {
        // Autoriza o árbitro...preciso saber que isso vai acontecer
        referee.startGame();

        assertThat(referee.didGameStart()).isEqualTo(true);
    }

    @Test
    void whenRefereeStartGame_thenPlayerTurnOfPlayerOne() {
        referee.startGame();

        assertThat(referee.getPlayerTurnToReceiveBall()).isEqualTo(playerOne);
    }

    @Test
    void whenBallIsThrownAfterRefereeStartGame_thenBallThrownFromMidTopPosition() {
        referee.startGame();

        assertThat(ball.getInitialPositionX()).isEqualTo(playingArea.midPositionX());
    }

    @Test
    void whenStartGameAndRefereeWatchGame_thenBallThrownToPlayerOneSideAndPlayerTwoScore() {
        referee.startGame();

        referee.watchGame();

        assertThat(playerTwo.getScores()).isEqualTo(1);
    }

    @Test
    void whenPlayerTwoScore_thenPlayerTwoReceiveBall() {
        referee.startGame();

        ball.setPositionX(playingArea.getL2PositionX());
        referee.watchGame();

        assertThat(referee.getPlayerTurnToReceiveBall()).isEqualTo(playerTwo);
    }

    @Test
    void whenPlayerTwoScoreAndPlayerOneScore_thenPlayerOneReceiveBall() {
        referee.startGame();

        ball.setPositionX(playingArea.getL2PositionX());
        referee.watchGame();

        ball.setPositionX(playingArea.getL4PositionX());
        referee.watchGame();

        assertThat(referee.getPlayerTurnToReceiveBall()).isEqualTo(playerOne);
    }
}
