package org.cristiancmello;

public class Referee {
    private PlayingArea playingArea;

    private Player playerTurnToReceiveBall;

    private boolean gameStarted;

    public void giveScoreToPlayer(Player player) {
        player.score(1);
    }

    public void watchPlayingArea(PlayingArea playingArea) {
        this.playingArea = playingArea;
    }

    public boolean ballCrossesL4() {
        var ball = playingArea.getBall();

        return ball.getPositionX() == playingArea.getL4PositionX();
    }

    private boolean ballCrossesL2() {
        var ball = playingArea.getBall();

        return ball.getPositionX() == playingArea.getL2PositionX();
    }

    public void watchGame() {
        if (ballCrossesL4()) {
            giveScoreToPlayer(playingArea.getPlayerOne());
            playerTurnToReceiveBall = playingArea.getPlayerOne();
        } else if (ballCrossesL2()) {
            giveScoreToPlayer(playingArea.getPlayerTwo());
            playerTurnToReceiveBall = playingArea.getPlayerTwo();
        }
    }

    public void startGame() {
        gameStarted = true;

        playerTurnToReceiveBall = playingArea.getPlayerOne();

        throwBall();
    }

    public Player getPlayerTurnToReceiveBall() {
        return playerTurnToReceiveBall;
    }

    public boolean didGameStart() {
        return gameStarted;
    }

    public void throwBall() {
        var ball = playingArea.getBall();

        ball.go(playingArea.midPositionX());
    }
}