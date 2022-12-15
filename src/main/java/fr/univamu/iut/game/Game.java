package fr.univamu.iut.game;

import fr.univamu.iut.exceptions.CharacterTypeNotFoundException;
import fr.univamu.iut.exceptions.EmptyNameForCharactersTeamException;
import fr.univamu.iut.game.characters.*;
import fr.univamu.iut.game.characters.Character;
import fr.univamu.iut.game.characters.factory.CharacterFactory;
import fr.univamu.iut.game.fight.TeamFight;
import fr.univamu.iut.game.characters.charactersTypes.CharactersEnum;
import fr.univamu.iut.game.market.Market;
import fr.univamu.iut.game.timer.EndGameTimerThread;

import java.util.Random;
import java.util.Scanner;

/**
 * Supports a game
 * @param <T> accepts types of character (Mage, Healer, Archer)
 * @author LennyGonzales
 */
public class Game<T extends Character> {

    private Scanner input;
    private CharactersTeam<T> enemyTeam;
    private CharactersTeam<T> playerTeam;
    private boolean endGame;
    private Random rand;
    private CharacterFactory<T> characterFactory;
    private Market<T> market;
    private int stageFight;
    private TeamFight<T> fight;
    private Thread endGameTimerThread;
    private boolean endTimer;
    private final int END_TIME_SECONDS = 180;


    public Game() throws EmptyNameForCharactersTeamException {
        input = new Scanner(System.in);
        endGame = false;
        rand = new Random();
        enemyTeam = new CharactersTeam<>("EnemyTeam");
        characterFactory = new CharacterFactory<>();
        stageFight = 1;
        endTimer = false;
    }

    /**
     * Creation of the player team
     */
    public void teamCreation() {
        while(true) {   // As long as the player's team name is empty, ask to enter a name
            System.out.print("Enter the name of your team : ");
            try {
                playerTeam = new CharactersTeam<>(input.nextLine());
                break;  // The player's team name isn't empty
            } catch (EmptyNameForCharactersTeamException e) {
                e.printStackTrace();
            }
        }
        market = new Market<>(playerTeam, input);
    }

    /**
     * Show the description of each character (name, skills, damage, ...)
     * @throws CharacterTypeNotFoundException when the character type entered doesn't exist
     */
    public void showCharactersDescription() throws CharacterTypeNotFoundException {
        for(CharactersEnum charactersEnum : CharactersEnum.values()) {
            System.out.println(characterFactory.createCharacter(charactersEnum.toString(), "Player1"));
        }
        System.out.println("Enter a type of character : ");
    }

    /**
     * Allows the user to choose his first character
     * @throws CharacterTypeNotFoundException when the character type entered doesn't exist
     */
    public void chooseFirstCharacter() throws CharacterTypeNotFoundException {
        String inputCharacter = input.nextLine().toLowerCase();
        playerTeam.addCharacter((T) characterFactory.createCharacter(inputCharacter, "Player1"));
    }

    /**
     * Create the enemy team for the fight
     * @throws CharacterTypeNotFoundException when the character type entered doesn't exist
     */
    public void creationEnemyTeam() throws CharacterTypeNotFoundException {
        Character enemy = null;
        Character player;
        String name;
        int numCharacter;
        for (int nbPlayer = 0; nbPlayer < playerTeam.getSize(); ++nbPlayer) {   // The enemy team have the same number as the player team
            name = "Enemy" + (nbPlayer + 1);
            numCharacter = rand.nextInt(CharactersEnum.values().length);
            enemy = characterFactory.createCharacter(CharactersEnum.values()[numCharacter].toString(), name);

            player = playerTeam.getSpecificCharacter(nbPlayer); // Get a player in the player team

            // Coefficient between 0.3 and 1.15 for the attributes (Damage and Defense)
            enemy.setDamage((int) (player.getDamage() * (rand.nextDouble() * (1.15 - 0.3) + 0.3)));
            enemy.setDamageEquipments((int) (player.getDamageEquipments() * (rand.nextDouble() * (1.15 - 0.3) + 0.3)));
            enemy.setDefence((int) (player.getDefence() * rand.nextDouble() * (1.15 - 0.3) + 0.3));
            enemy.setDefenceEquipments((int) (player.getDefenceEquipments() * (rand.nextDouble() * (1.15 - 0.3) + 0.3)));

            enemyTeam.addCharacter((T) enemy);
        }
    }

    /**
     * Supports the fight between player team and enemy team
     * @throws InterruptedException it's for Thread.sleep(250) in the mage special attack's method
     * @throws CharacterTypeNotFoundException when the character type entered doesn't exist
     */
    public void fightMode() throws InterruptedException, CharacterTypeNotFoundException {
        creationEnemyTeam();
        System.out.println("\n----------- Stage " + stageFight + " -----------");
        if(fight == null) { // Allows to user only one instance of teamFight
            fight = new TeamFight<>(playerTeam, enemyTeam);
        }
        if (fight.run().equals("defeat")) { // If the player loses, the game stops
            endGame = true;
        }
        ++stageFight;
    }

    /**
     * Creation of the player team with his first character
     * @throws CharacterTypeNotFoundException when the character type entered doesn't exist
     */
    public void introduction() throws CharacterTypeNotFoundException {
        teamCreation();
        showCharactersDescription();
        chooseFirstCharacter();
    }

    /**
     * Verify if the timer is over
     * @return true - if the timer is over | else, false
     */
    public boolean verifyEndGameTimer() {
        if (endTimer){
            System.out.println("More than " + END_TIME_SECONDS + " seconds have passed ! Do you want to keep playing? Yes | No");
            if(input.nextLine().equalsIgnoreCase("no")) {
                return true;
            }
            startEndGameTimerThread();
            endTimer = false;
        }
        return false;
    }

    /**
     * Send the game menu to the user and ask him to choose a mode
     * @throws InterruptedException it's for Thread.sleep(250) in the mage special attack's method
     * @throws CharacterTypeNotFoundException when the character type entered doesn't exist
     */
    public void gameMenu() throws InterruptedException, CharacterTypeNotFoundException {
        endGame = false;

        while(!endGame) {
            if(verifyEndGameTimer()) { break; }
            System.out.println("\nFight (1) | Market (2) | Profile (3) | Quit (4)");  // Presents the game's pages
            System.out.println("Enter a mode : ");
            switch(input.nextLine().toLowerCase()) {
                case "fight", "1" -> fightMode();
                case "market", "2" -> market.marketMode();
                case "profile", "3" -> System.out.println(playerTeam);    // Show the player team
                case "quit", "4" -> endGame = true;
            }
        }
    }

    /**
     * Set the timer status
     * @param endTimer true if the timer is over | else, false
     */
    public void setEndTimer(boolean endTimer) {
        this.endTimer = endTimer;
    }

    /**
     * Start the timer thread
     */
    public void startEndGameTimerThread() {
        endGameTimerThread = new Thread(new EndGameTimerThread(this, END_TIME_SECONDS));  // Start the Timer
        endGameTimerThread.start();
    }

    /**
     * Runs the game
     * @throws InterruptedException it's for Thread.sleep(250) in the mage special attack's method
     * @throws CharacterTypeNotFoundException when the character type entered doesn't exist
     */
    public void run() throws InterruptedException, CharacterTypeNotFoundException {
        introduction();
        startEndGameTimerThread();
        gameMenu();
    }
}
