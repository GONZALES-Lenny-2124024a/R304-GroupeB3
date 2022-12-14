package fr.univamu.iut.game.fight;

import fr.univamu.iut.game.reward.TeamFightRewardLevel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the TeamFightRewardLevel enumerator
 */
public class TeamFightRewardLevelTest {
    @Test
    public void shouldGetLegendaryReward() {
        assertEquals(TeamFightRewardLevel.LEGENDARY.getReward(), 150);
    }

    @Test
    public void shouldGetEpicReward() {
        assertEquals(TeamFightRewardLevel.EPIC.getReward(), 75);
    }

    @Test
    public void shouldGetRareReward() {
        assertEquals(TeamFightRewardLevel.RARE.getReward(), 25);
    }

    @Test
    public void shouldGetCommonReward() {
        assertEquals(TeamFightRewardLevel.COMMON.getReward(), 10);
    }
}
