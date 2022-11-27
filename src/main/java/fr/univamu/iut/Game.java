package fr.univamu.iut;

import fr.univamu.iut.market.Market;

import java.util.Random;
import java.util.Scanner;

public class Game<T extends Character> {

    Scanner input;
    CharactersTeam<T> enemyTeam;
    CharactersTeam<T> playerTeam;
    boolean endGame;
    Random rand;

    public Game() {
        input = new Scanner(System.in);
        endGame = false;
        rand = new Random();
        enemyTeam = new CharactersTeam<>("EnemyTeam");
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
        System.out.println(new Archer("Player1"));
        System.out.println(new Mage("Player1"));
        System.out.println(new Healer("Player1"));
    }

    /**
     * Allows the user to choose his first character
     */
    public void chooseFirstCharacter() {
        switch(input.nextLine().toLowerCase()) {
            case "archer" -> playerTeam.addCharacter((T) new Archer("Player1"));
            case "healer" ->playerTeam.addCharacter((T) new Healer("Player1"));
            default -> playerTeam.addCharacter((T) new Mage("Player1"));
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
        for (int nbPlayer = 0; nbPlayer < playerTeam.getSize(); ++nbPlayer) {   // The enemy team have the same number as the player team
            name = "Enemy" + (nbPlayer + 1);
            switch (rand.nextInt(3)) {
                case 0 -> enemy = new Archer(name);
                case 1 -> enemy = new Mage(name);
                case 2 -> enemy = new Healer(name);
            }
            player = playerTeam.getSpecificCharacter(nbPlayer); // Get a player in the player team

            // Coefficient between 0.3 and 1.15 for the attributs (Damage and Defense)
            enemy.setDamage((int) (player.getDamage() * (rand.nextDouble() * (1.15 - 0.3) + 0.3)));
            enemy.setDefence((int) (player.getDefence() * rand.nextDouble() * (1.15 - 0.3) + 0.3));

            enemyTeam.addCharacter((T) enemy);
        }
    }

    /**
     * Supports the fight between player team and enemy team
     * @throws InterruptedException
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
        for (Market item : Market.values()) {
            output.append(item + " : " + item.getPrice() + '\n');
        }
        System.out.println(output);
    }

    /**
     * Verify if the user have enough gold and it takes away the gold
     * @param characterEnum
     * @return true if the character have enough gold, else false
     */
    public boolean buyCharacter(Market characterEnum) {
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
                if(buyCharacter(Market.ARCHER)) { playerTeam.addCharacter((T) new Archer("Player" + (playerTeam.getSize() + 1))); }
                break;

            case "mage":
                if(buyCharacter(Market.MAGE)) { playerTeam.addCharacter((T) new Mage("Player" + (playerTeam.getSize() + 1))); }
                break;

            case "healer":
                if(buyCharacter(Market.HEALER)) { playerTeam.addCharacter((T) new Healer("Player" + (playerTeam.getSize() + 1))); }
                break;
        }
    }

    /**
     * The game menu
     * @throws InterruptedException
     */
    public void gameMenu() throws InterruptedException {
        endGame = false;
        while(!endGame) {
            System.out.println("Fight | Market | Profile | Quit");  // Presents the game's pages
            switch(input.nextLine().toLowerCase()) {
                case "fight" -> fightMode();
                case "market" -> marketMode();
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
