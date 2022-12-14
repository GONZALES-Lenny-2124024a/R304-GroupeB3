package fr.univamu.iut.game;

import fr.univamu.iut.exceptions.EmptyNameForPlayerTeamException;
import fr.univamu.iut.game.characters.*;
import fr.univamu.iut.game.characters.Character;
import fr.univamu.iut.game.characters.charactersTypes.Archer;
import fr.univamu.iut.game.characters.charactersTypes.Healer;
import fr.univamu.iut.game.characters.charactersTypes.Mage;
import fr.univamu.iut.game.characters.factory.CharacterFactory;
import fr.univamu.iut.game.fight.TeamFight;
import fr.univamu.iut.game.characters.charactersTypes.CharactersEnum;
import fr.univamu.iut.game.market.Market;

import java.util.Random;
import java.util.Scanner;

/**
 * Supports a game
 * @param <T> accepts types of character (Mage, Healer, Archer)
 */
public class Game<T extends Character> {

    private Scanner input;
    private CharactersTeam<T> enemyTeam;
    private CharactersTeam<T> playerTeam;
    private boolean endGame;
    private Random rand;
    private CharacterFactory characterFactory;
    private Market market;


    public Game() throws EmptyNameForPlayerTeamException {
        input = new Scanner(System.in);
        endGame = false;
        rand = new Random();
        enemyTeam = new CharactersTeam<>("EnemyTeam");
        characterFactory = new CharacterFactory();
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
            } catch (EmptyNameForPlayerTeamException e) {
                e.printStackTrace();
            }
        }
        playerTeam.setGold(1000);   //--------------------------------------------
        market = new Market(playerTeam, input);
    }

    /**
     * Show the description of each character (name, skills, damage, ...)
     */
    public void showCharactersDescription() {
        System.out.println("Choose your class from : " + '\n');
        for(CharactersEnum charactersEnum : CharactersEnum.values()) {
            System.out.println(characterFactory.createCharacter(charactersEnum.toString(), "Player1"));
        }
    }

    /**
     * Allows the user to choose his first character
     */
    public void chooseFirstCharacter() {
        String inputCharacter = input.nextLine().toLowerCase();
        for(CharactersEnum charactersEnum : CharactersEnum.values()) {
            if((charactersEnum.toString().toLowerCase()).equals(inputCharacter)) {
                playerTeam.addCharacter((T) characterFactory.createCharacter(charactersEnum.toString(), "Player1"));
            }
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
     * Create the enemy team for the fight
     */
    public void creationEnemyTeam() {
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
            enemy.setDefence((int) (player.getDefence() * rand.nextDouble() * (1.15 - 0.3) + 0.3));

            enemyTeam.addCharacter((T) enemy);
        }
    }

    /**
     * Supports the fight between player team and enemy team
     * @throws InterruptedException it's for Thread.sleep(250) in the mage special attack's method
     */
    public void fightMode() throws InterruptedException {
        creationEnemyTeam();
        TeamFight fight = new TeamFight(playerTeam, enemyTeam);
        if (fight.run().equals("defeat")) { // If the player loses, the game stops
            endGame = true;
        }
    }

    /**
     * Presents the market's items
     */
    public static void presentationMarket() {
        StringBuilder output = new StringBuilder();
        for (CharactersEnum item : CharactersEnum.values()) {
            output.append(item + " : " + item.getPrice() + '\n');
        }
        System.out.println(output);
    }

    /**
     * Verify if the user have enough gold, it takes away the gold
     * @param characterEnum Market which contains all the characters that the user can buy
     * @return true if the character have enough gold, else false
     */
    public boolean buyCharacter(CharactersEnum characterEnum) {
        if (playerTeam.getGold() < characterEnum.getPrice()) {
            System.out.println("You don't have enough gold !");
            return false;
        }
        playerTeam.setGold(playerTeam.getGold() - characterEnum.getPrice());
        return true;
    }

    /**
     * Allows the user to buy new characters
     */
    public void marketMode() {
        presentationMarket();
        System.out.println("Enter the name of the character that you want to buy :");

        switch (input.nextLine().toLowerCase()) {
            case "archer":
                if(buyCharacter(CharactersEnum.ARCHER)) { playerTeam.addCharacter((T) new Archer("Player" + (playerTeam.getSize() + 1))); }
                break;

            case "mage":
                if(buyCharacter(CharactersEnum.MAGE)) { playerTeam.addCharacter((T) new Mage("Player" + (playerTeam.getSize() + 1))); }
                break;

            case "healer":
                if(buyCharacter(CharactersEnum.HEALER)) { playerTeam.addCharacter((T) new Healer("Player" + (playerTeam.getSize() + 1))); }
                break;
        }
    }

    /**
     * The game menu
     * @throws InterruptedException it's for Thread.sleep(250) in the mage special attack's method
     */
    public void gameMenu() throws InterruptedException {
        endGame = false;
        while(!endGame) {
            System.out.println("\nFight | Market | Profile | Quit");  // Presents the game's pages
            switch(input.nextLine().toLowerCase()) {
                case "fight" -> fightMode();
                case "market" -> market.marketMode();
                case "profile" -> System.out.println(playerTeam);    // Show the player team
                case "quit" -> endGame = true;
            }
        }
    }

    public void run() throws InterruptedException {
        introduction();
        gameMenu();
    }
}
