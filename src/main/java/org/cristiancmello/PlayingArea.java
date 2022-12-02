package org.cristiancmello;

public class PlayingArea {
    private Player playerOne;
    private Player playerTwo;

    private Ball ball;


    public void receivePlayer(Player player) {
        if (playerOne == null) {
            playerOne = player;
        } else if (playerTwo == null) {
            playerTwo = player;
        }
    }

    public void receiveBall(Ball ball) {
        this.ball = ball;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public int getL2PositionX() {
        return 1;
    }

    public int getL4PositionX() {
        return 4;
    }

    public Ball getBall() {
        return ball;
    }


    public int midPositionX() {
        return 2;
    }
}