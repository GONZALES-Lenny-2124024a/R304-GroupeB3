package fr.univamu.iut.exceptions;

public class EmptyNameException extends Exception{
    public EmptyNameException() {
        super("The name entered is empty");
    }
}
