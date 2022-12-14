package fr.univamu.iut.game.reward;

/**
 * Reward enumerator that contains all the rewards' level that the player can get after winning a team fight
 * @author LennyGonzales
 */
public enum TeamFightRewardLevel {
    COMMON(10),
    RARE(25),
    EPIC(75),
    LEGENDARY(150);

    private final int reward;

    TeamFightRewardLevel(int reward) {
        this.reward = reward;
    }

    /**
     * Get the number of golds to give to the player team and the number of experience to give to the characters of the player team
     * @return the reward
     */
    public int getReward() { return reward; }
}
