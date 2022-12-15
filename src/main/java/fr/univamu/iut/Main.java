package fr.univamu.iut;

import fr.univamu.iut.exceptions.CharacterTypeNotFoundException;
import fr.univamu.iut.exceptions.EmptyNameForCharactersTeamException;
import fr.univamu.iut.game.Game;

/**
 * Main class which begin a game
 * @author LennyGonzales
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, EmptyNameForCharactersTeamException, CharacterTypeNotFoundException {
        Game game = new Game();
        game.run();
    }
}