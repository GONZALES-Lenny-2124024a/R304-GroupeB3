package fr.univamu.iut.game.fight;

import fr.univamu.iut.game.characters.Character;
import fr.univamu.iut.game.characters.CharactersTeam;
import fr.univamu.iut.game.reward.TeamFightRewardLevel;

import java.util.*;

/**
 * Supports the fight between two characters team
 * @param <T> accepts types of character (Mage, Healer, Archer)
 * @author LennyGonzales
 */
public class TeamFight<T extends Character> {
    private CharactersTeam<T> playerTeam;
    private CharactersTeam<T> enemyTeam;
    private List<T> charactersList;

    public TeamFight(CharactersTeam<T> playerTeam, CharactersTeam<T> enemyTeam) {
        this.playerTeam = playerTeam;
        this.enemyTeam = enemyTeam;
        charactersList = playerTeam.getCharacters();
    }

    /**
     * Get the level of the reward
     * @param randValue a int between 0 (inclusive) and 1 (inclusive)
     * @return the reward level
     */
    public int getRewardLevel(double randValue) {
        if (randValue <= 0.03) { // 3% chance to have a legendary reward
            return TeamFightRewardLevel.LEGENDARY.getReward();
        } else if (randValue <= 0.08) { // 5% chance to have an epic reward
            return TeamFightRewardLevel.EPIC.getReward();
        } else if (randValue <= 0.3) { // 22% chance to have a rare reward
            return TeamFightRewardLevel.RARE.getReward();
        } else {    // 70% chance to have a common reward
            return TeamFightRewardLevel.COMMON.getReward();
        }
    }

    /**
     * Give a reward to the player (gold, xp)
     */
    public void giveReward() {
        int rewardLevel = getRewardLevel(Math.random());

        Iterator<T> it = playerTeam.getCharacters().iterator();
        T character;
        while(it.hasNext()) {   // Give xp to characters
            character = (T) it.next();
            character.setXp(character.getXp() + rewardLevel);
        }
        playerTeam.setGold(playerTeam.getGold() + rewardLevel); // Give gold to the user
        System.out.println("You have received " + rewardLevel + " golds.");
    }

    /**
     * Get a random character from a team
     * @param team characters team
     * @return a random character from a team
     */
    public T getRandomCharacter(CharactersTeam<T> team) {
        return team.getCharacters().get((int)(Math.random()*team.getCharacters().size()));
    }

    /**
     * A team (attackingTeam) attack another team (victimTeam)
     * @param attackingTeam (characters team which attack)
     * @param victimTeam (characters team which attack)
     * @return if the fight is over or not
     * @throws InterruptedException it's for Thread.sleep(250) in the mage special attack's method
     */
    public boolean attack(CharactersTeam<T> attackingTeam, CharactersTeam<T> victimTeam) throws InterruptedException {
        for (T attackingCharacter : attackingTeam.getCharacters()) {
            T victimCharacter = getRandomCharacter(victimTeam);
            attackingCharacter.attack(victimCharacter, Math.random());

            if (victimCharacter.getLife() <= 0) {
                victimTeam.delCharacter(victimCharacter);
                System.out.println(victimCharacter.getName() + " was killed !");

                if(victimTeam.getSize() == 0) { // Verify if there is still an opponent
                    System.out.println(attackingTeam.getName() + " won !");
                    return true;    // The fight is over
                }
            }
        }
        return false;   //The fight isn't over
    }

    /**
     * Sort the list with the Bubble sort
     */
    public void rankingBubbleSort() {
        int sizeList = charactersList.size();
        T playerSwap;
        for(int x = 0; x < sizeList; x++) {
            for (int y = 1; y < (sizeList - x); y++) {
                if (charactersList.get(y - 1).getDamageInFight() < charactersList.get(y).getDamageInFight()) {
                    //swap elements
                    playerSwap = charactersList.get(y - 1);
                    charactersList.set((y - 1), charactersList.get(y));
                    charactersList.set(y, playerSwap);
                }
            }
        }
    }

    /**
     * Sort a list and print it
     */
    public void ranking() {
        rankingBubbleSort();
        System.out.println("\nDamage ranking :");
        charactersList.forEach(character -> System.out.println(character.getName() + " : " + character.getDamageInFight()));
    }

    /**
     * Supports the fight between two teams
     * @return if the user won or not
     * @throws InterruptedException it's for Thread.sleep(250) in the mage special attack's method
     */
    public String run() throws InterruptedException {
        while (true) {
            // Player team attack
            if(attack(playerTeam,enemyTeam)) {
                playerTeam.getCharacters().forEach((T p) -> p.setLife(100));
                giveReward();
                ranking();
                charactersList.forEach(character -> character.setDamageInFight(0));
                return "win";
            }
            // Enemy team attack
            if(attack(enemyTeam,playerTeam)) {
                return "defeat";
            }
        }
    }
}
