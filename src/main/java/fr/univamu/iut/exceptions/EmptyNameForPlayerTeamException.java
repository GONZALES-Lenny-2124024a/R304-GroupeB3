package fr.univamu.iut.exceptions;

/**
 * Throw this exception when the player's team name is empty
 */
public class EmptyNameForPlayerTeamException extends Exception{
    public EmptyNameForPlayerTeamException() {
        super("The name entered is empty");
    }
}
