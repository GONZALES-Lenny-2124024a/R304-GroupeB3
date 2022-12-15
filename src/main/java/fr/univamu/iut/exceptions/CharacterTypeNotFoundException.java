package fr.univamu.iut.exceptions;

/**
 * Throw this exception when the character type entered doesn't exist
 * @author LennyGonzales
 */
public class CharacterTypeNotFoundException extends Exception{
    public CharacterTypeNotFoundException() {
        super("The character type entered doesn't exist");
    }
}
