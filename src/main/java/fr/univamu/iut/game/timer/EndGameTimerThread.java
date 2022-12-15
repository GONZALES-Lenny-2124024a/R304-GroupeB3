package fr.univamu.iut.game.timer;

import fr.univamu.iut.game.Game;

/**
 * A timer which send a message to the user and ask him if he want to leave the game or not
 * @author LennyGonzales
 */
public class EndGameTimerThread extends Thread{
    private final Game game;
    private final int endTimeSeconds;

    public EndGameTimerThread(Game game, int endTimeSeconds) {
        this.game = game;
        this.endTimeSeconds = endTimeSeconds;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(endTimeSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        game.setEndTimer(true);
    }
}
