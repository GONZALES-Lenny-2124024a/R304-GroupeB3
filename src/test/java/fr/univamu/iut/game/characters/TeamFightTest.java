package fr.univamu.iut.game.characters;

import fr.univamu.iut.exceptions.EmptyNameForCharactersTeamException;
import fr.univamu.iut.game.characters.charactersTypes.Archer;
import fr.univamu.iut.game.characters.charactersTypes.Mage;
import fr.univamu.iut.game.fight.TeamFight;
import fr.univamu.iut.game.reward.TeamFightRewardLevel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the TeamFight class
 * @author LennyGonzales
 */
public class TeamFightTest<T extends Character> {
    @Test
    public void shouldGetLegendaryReward() throws EmptyNameForCharactersTeamException {
        TeamFight<T> fight = new TeamFight<>(new CharactersTeam<>("LennyTeam"), new CharactersTeam<>("EnemyTeam"));
        assertEquals(fight.getRewardLevel(0.03), TeamFightRewardLevel.LEGENDARY.getReward());
    }

    @Test
    public void shouldGetEpicReward() throws EmptyNameForCharactersTeamException {
        TeamFight<T> fight = new TeamFight<>(new CharactersTeam<>("LennyTeam"), new CharactersTeam<>("EnemyTeam"));
        assertEquals(fight.getRewardLevel(0.08), TeamFightRewardLevel.EPIC.getReward());
    }

    @Test
    public void shouldGetRareReward() throws EmptyNameForCharactersTeamException {
        TeamFight<T> fight = new TeamFight<>(new CharactersTeam<>("LennyTeam"), new CharactersTeam<>("EnemyTeam"));
        assertEquals(fight.getRewardLevel(0.3), TeamFightRewardLevel.RARE.getReward());
    }

    @Test
    public void shouldGetCommonReward() throws EmptyNameForCharactersTeamException {
        TeamFight<T> fight = new TeamFight<>(new CharactersTeam<>("LennyTeam"), new CharactersTeam<>("EnemyTeam"));
        assertEquals(fight.getRewardLevel(1), TeamFightRewardLevel.COMMON.getReward());
    }

    @Test
    public void shouldWin() throws InterruptedException, EmptyNameForCharactersTeamException {
        //Creation of the enemy team
        T mageEnemy = (T) new Mage("Enemy");
        CharactersTeam<T> teamEnemy = new CharactersTeam<>("EnemyTeam");
        teamEnemy.addCharacter(mageEnemy);

        //Creation of the player team
        T magePlayer = (T) new Mage("Player");
        magePlayer.setDamage(200);
        CharactersTeam<T> teamPlayer = new CharactersTeam<>("LennyTeam");
        teamPlayer.addCharacter(magePlayer);

        TeamFight<T> fight = new TeamFight<>(teamPlayer, teamEnemy);
        assertEquals(fight.run(), "win");
    }

    @Test
    public void shouldDefeat() throws InterruptedException, EmptyNameForCharactersTeamException {
        //Creation of the player team
        T magePlayer = (T) new Mage("Player");
        CharactersTeam<T> teamPlayer = new CharactersTeam<>("LennyTeam");
        teamPlayer.addCharacter(magePlayer);

        //Creation of the enemy team
        T mageEnemy = (T) new Mage("Enemy");
        mageEnemy.setDamage(200);
        CharactersTeam<T> teamEnemy = new CharactersTeam<>("Enemy");
        teamEnemy.addCharacter(mageEnemy);

        TeamFight<T> fight = new TeamFight(teamPlayer, teamEnemy);
        assertEquals(fight.run(), "defeat");
    }

    @Test
    public void shouldGetRandomCharacter() throws EmptyNameForCharactersTeamException {
        T mage = (T) new Mage("Player");

        CharactersTeam<T> teamPlayer = new CharactersTeam<>("LennyTeam");
        teamPlayer.addCharacter(mage);
        CharactersTeam<T> teamEnemy = new CharactersTeam<>("Enemy");
        teamEnemy.addCharacter(mage);

        TeamFight<T> fight = new TeamFight<>(teamPlayer, teamEnemy);

        assertEquals(fight.getRandomCharacter(teamPlayer, (int)(Math.random()*teamEnemy.getCharacters().size())), mage);
    }


    @Test
    public void shouldAttackEndFight() throws InterruptedException, EmptyNameForCharactersTeamException {
        CharactersTeam<T> teamPlayer = new CharactersTeam<>("LennyTeam");
        CharactersTeam<T> teamEnemy = new CharactersTeam<>("Enemy");

        T player1 = (T) new Archer("Player1");
        T enemy1 = (T) new Archer("Enemy1");
        teamPlayer.addCharacter(player1);
        teamEnemy.addCharacter(enemy1);

        TeamFight<T> teamFight = new TeamFight<>(teamPlayer, teamEnemy);
        boolean result = teamFight.attack(teamPlayer, teamEnemy);
        assertFalse(result);
    }

    @Test
    public void shouldAttackDontEndFight() throws InterruptedException, EmptyNameForCharactersTeamException {
        CharactersTeam<T> teamPlayer = new CharactersTeam<>("LennyTeam");
        CharactersTeam<T> teamEnemy = new CharactersTeam<>("Enemy");

        T player1 = (T) new Archer("Player1");
        T enemy1 = (T) new Archer("Enemy1");
        enemy1.setLife(1);
        teamPlayer.addCharacter(player1);
        teamEnemy.addCharacter(enemy1);

        TeamFight<T> teamFight = new TeamFight<>(teamPlayer, teamEnemy);
        boolean result = teamFight.attack(teamPlayer, teamEnemy);
        assertTrue(result);
    }
}
