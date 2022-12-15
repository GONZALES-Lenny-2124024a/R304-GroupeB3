package fr.univamu.iut.exceptions;

/**
 * Throw this exception when the random value isn't between 0 and 1
 * @author LennyGonzales
 */
public class RandomValueNotBetween0And1Exception extends Exception{
    public RandomValueNotBetween0And1Exception() { super("The random value isn't between 0 and 1"); }
}
