package fr.univamu.iut.reward;

public enum TeamFightRewardLevel {
    COMMON(10),
    RARE(25),
    EPIC(75),
    LEGENDARY(150);

    private int reward;

    TeamFightRewardLevel(int reward) {
        this.reward = reward;
    }

    public int getReward() { return reward; }
}
