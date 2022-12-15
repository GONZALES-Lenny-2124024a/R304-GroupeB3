package fr.univamu.iut.game.timer;

import fr.univamu.iut.game.Game;

/**
 *
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
