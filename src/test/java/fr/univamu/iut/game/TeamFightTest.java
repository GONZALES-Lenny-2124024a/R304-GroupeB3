package fr.univamu.iut.game;

import fr.univamu.iut.exceptions.EmptyNameForPlayerTeamException;
import fr.univamu.iut.game.characters.CharactersTeam;
import fr.univamu.iut.game.characters.charactersTypes.Mage;
import fr.univamu.iut.game.fight.TeamFight;
import fr.univamu.iut.game.reward.TeamFightRewardLevel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the TeamFight class
 */
public class TeamFightTest {
    @Test
    public void shouldGetLegendaryReward() throws EmptyNameForPlayerTeamException {
        TeamFight fight = new TeamFight(new CharactersTeam("LennyTeam"), new CharactersTeam("EnemyTeam"));
        assertEquals(fight.getRewardLevel(0.03), TeamFightRewardLevel.LEGENDARY.getReward());
    }
    @Test
    public void shouldGetEpicReward() throws EmptyNameForPlayerTeamException {
        TeamFight fight = new TeamFight(new CharactersTeam("LennyTeam"), new CharactersTeam("EnemyTeam"));
        assertEquals(fight.getRewardLevel(0.08), TeamFightRewardLevel.EPIC.getReward());
    }
    @Test
    public void shouldGetRareReward() throws EmptyNameForPlayerTeamException {
        TeamFight fight = new TeamFight(new CharactersTeam("LennyTeam"), new CharactersTeam("EnemyTeam"));
        assertEquals(fight.getRewardLevel(0.3), TeamFightRewardLevel.RARE.getReward());
    }

    @Test
    public void shouldGetCommoneward() throws EmptyNameForPlayerTeamException {
        TeamFight fight = new TeamFight(new CharactersTeam("LennyTeam"), new CharactersTeam("EnemyTeam"));
        assertEquals(fight.getRewardLevel(1), TeamFightRewardLevel.COMMON.getReward());
    }

    @Test
    public void shouldWin() throws InterruptedException,EmptyNameForPlayerTeamException {
        //Creation of the enemy team
        Mage mageEnemy = new Mage("Enemy");
        CharactersTeam teamEnemy = new CharactersTeam("EnemyTeam");
        teamEnemy.addCharacter(mageEnemy);

        //Creation of the player team
        Mage magePlayer = new Mage("Player");
        magePlayer.setDamage(200);
        CharactersTeam teamPlayer = new CharactersTeam("LennyTeam");
        teamPlayer.addCharacter(magePlayer);

        TeamFight fight = new TeamFight(teamPlayer, teamEnemy);
        assertEquals(fight.run(), "win");
    }

    @Test
    public void shouldDefeat() throws InterruptedException,EmptyNameForPlayerTeamException {
        //Creation of the player team
        Mage magePlayer = new Mage("Player");
        CharactersTeam teamPlayer = new CharactersTeam("LennyTeam");
        teamPlayer.addCharacter(magePlayer);

        //Creation of the enemy team
        Mage mageEnemy = new Mage("Enemy");
        mageEnemy.setDamage(200);
        CharactersTeam teamEnemy = new CharactersTeam("Enemy");
        teamEnemy.addCharacter(mageEnemy);

        TeamFight fight = new TeamFight(teamPlayer, teamEnemy);
        assertEquals(fight.run(), "defeat");
    }

    @Test
    public void shouldGetRandomCharacter() throws EmptyNameForPlayerTeamException {
        Mage mage = new Mage("Player");

        CharactersTeam teamPlayer = new CharactersTeam("LennyTeam");
        teamPlayer.addCharacter(mage);
        CharactersTeam teamEnemy = new CharactersTeam("Enemy");
        teamEnemy.addCharacter(mage);

        TeamFight fight = new TeamFight(teamPlayer, teamEnemy);

        assertEquals(fight.getRandomCharacter(teamPlayer), mage);
    }
}
