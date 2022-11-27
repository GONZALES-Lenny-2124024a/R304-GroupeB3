package fr.univamu.iut;

import java.util.Random;
import java.util.Scanner;

public class Game<T extends Character> {

    Scanner input;
    CharactersTeam<T> playerTeam;
    boolean endGame;

    public Game() {
        input = new Scanner(System.in);
        endGame = false;
    }

    /**
     * Creation of the player team
     */
    public void teamCreation() {
        System.out.print("Enter the name of your team : ");
        playerTeam = new CharactersTeam<>(input.nextLine());
    }

    /**
     * Show the description of each character (name, skills, damage, ...)
     */
    public void showCharactersDescription() {
        System.out.println("Choose your class from : " + '\n');
        System.out.println(new Archer("Character1"));
        System.out.println(new Mage("Character1"));
        System.out.println(new Healer("Character1"));
    }

    /**
     * Allows the user to choose his first character
     */
    public void chooseFirstCharacter() {
        switch(input.nextLine().toLowerCase()) {
            case "archer" -> playerTeam.addCharacter((T) new Archer("Character1"));
            case "healer" ->playerTeam.addCharacter((T) new Healer("Character1"));
            default -> playerTeam.addCharacter((T) new Mage("Character1"));
        }
    }

    /**
     * Creation of the player team with his first character
     */
    public void introduction() {
        teamCreation();
        showCharactersDescription();
        chooseFirstCharacter();
    }

    /**
     * The game menu
     * @throws InterruptedException
     */
    public void gameMenu() {
        endGame = false;
        while(!endGame) {
            System.out.println("Profile | Quit");  // Presents the game's pages
            switch(input.nextLine().toLowerCase()) {
                case "profile" -> System.out.println(playerTeam);    // Show the player team
                case "quit" -> endGame = true;
            }
        }
    }

    public void run() {
        introduction();
        gameMenu();
    }
}
