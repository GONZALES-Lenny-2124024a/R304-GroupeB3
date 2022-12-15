package fr.univamu.iut.exceptions;

/**
 * Throw this exception when the player's team name is empty
 * @author LennyGonzales
 */
public class EmptyNameForCharactersTeamException extends Exception{
    public EmptyNameForCharactersTeamException() {
        super("The name entered is empty");
    }
}
