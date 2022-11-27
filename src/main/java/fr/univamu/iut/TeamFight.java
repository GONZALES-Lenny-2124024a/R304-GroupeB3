package fr.univamu.iut;

import fr.univamu.iut.reward.TeamFightRewardLevel;

import java.util.Iterator;

public class TeamFight<T extends Character> {
    private CharactersTeam<T> playerTeam;
    private CharactersTeam<T> enemyTeam;

    public TeamFight(CharactersTeam<T> playerTeam, CharactersTeam<T> enemyTeam) {
        this.playerTeam = playerTeam;
        this.enemyTeam = enemyTeam;
    }

    /**
     * Return the level of the reward
     */
    public int getRewardLevel() {
        double randValue = Math.random();
        if (randValue <= 0.03) { // 3% chance to have a legendary reward
            return TeamFightRewardLevel.LEGENDARY.getReward();
        } else if ((randValue <= 0.08) && (randValue > 0.03)) { // 5% chance to have a epic reward
            return TeamFightRewardLevel.EPIC.getReward();
        } else if ((randValue <= 0.3) && (randValue > 0.08)) { // 22% chance to have a rare reward
            return TeamFightRewardLevel.RARE.getReward();
        } else {    // 70% chance to have a common reward
            return TeamFightRewardLevel.COMMON.getReward();
        }
    }

    /**
     * Give a reward to the player (gold, xp)
     */
    public void giveReward() {
        int rewardLevel = getRewardLevel();

        Iterator<T> it = playerTeam.getCharacters().iterator();
        while(it.hasNext()) {   // Give xp to characters
            T character = (T) it.next();
            character.setXp(character.getXp() + rewardLevel);
        }
        playerTeam.setGold(playerTeam.getGold() + rewardLevel); // Give gold to the user
        System.out.println("You have received " + rewardLevel + " golds.");
    }

    /**
     * Get a random character from a team
     * @param team
     * @return a character
     */
    public T getRandomCharacter(CharactersTeam<T> team) {
        return team.getCharacters().get((int)Math.random()*team.getCharacters().size());
    }

    /**
     * A team (attackingTeam) attack another team (victimTeam)
     * @param attackingTeam
     * @param victimTeam
     * @return
     * @throws InterruptedException
     */
    public boolean attack(CharactersTeam<T> attackingTeam, CharactersTeam<T> victimTeam) throws InterruptedException {
        for (T attackingCharacter : attackingTeam.getCharacters()) {
            T victimCharacter = getRandomCharacter(victimTeam);
            attackingCharacter.attack(victimCharacter);

            if (victimCharacter.getLife() <= 0) {
                victimTeam.delCharacter(victimCharacter);
                System.out.println(victimCharacter.getName() + " was killed !");

                if(victimTeam.getSize() == 0) { // Verify if there is still a opponent
                    System.out.println(attackingTeam.getName() + " won !");
                    return true;    // The fight is over
                }
            }
        }
        return false;   //The fight isn't over
    }

    /**
     * Supports the fight between two teams
     * @return
     * @throws InterruptedException
     */
    public String run() throws InterruptedException {
        while (true) {
            // Player team attack
            if(attack(playerTeam,enemyTeam)) {
                playerTeam.getCharacters().forEach((T p) -> p.setLife(100));
                giveReward();
                return "win";
            }
            // Enemy team attack
            if(attack(enemyTeam,playerTeam)) {
                return "defeat";
            }
        }
    }
}
