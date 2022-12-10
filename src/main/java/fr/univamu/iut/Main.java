package fr.univamu.iut;

import fr.univamu.iut.exceptions.EmptyNameForPlayerTeamException;
import fr.univamu.iut.game.Game;

/**
 * Main class which begin a game
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, EmptyNameForPlayerTeamException {
        Game game = new Game();
        game.run();
    }
}