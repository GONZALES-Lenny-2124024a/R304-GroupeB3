package fr.univamu.iut.game;

import fr.univamu.iut.game.characters.charactersTypes.Healer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the Healer class
 */
public class HealerTest {
    @Test
    public void shouldCriticalAttack() throws InterruptedException {
        Healer cPlayer = new Healer("Lenny");
        Healer ePlayer = new Healer("Enemy");

        cPlayer.attack(ePlayer, 0.02);
        assertEquals(ePlayer.getLife(), 78);
    }

    @Test
    public void shouldSpecialAttack() throws InterruptedException {
        Healer cPlayer = new Healer("Lenny");
        Healer ePlayer = new Healer("Enemy");

        cPlayer.attack(ePlayer, 0.12);
        assertEquals(ePlayer.getLife(), 100);
    }

    @Test
    public void shouldBasicAttack() throws InterruptedException {
        Healer cPlayer = new Healer("Lenny");
        Healer ePlayer = new Healer("Enemy");

        cPlayer.attack(ePlayer, 0.5);
        assertEquals(ePlayer.getLife(), 94);
    }

    @Test
    public void shouldGetName() {
        Healer p = new Healer("Lenny");
        assertEquals(p.getName(), "Lenny");
    }

    @Test
    public void shouldGetXp() {
        Healer p = new Healer("Lenny");
        assertEquals(p.getXp(), 0);
    }

    @Test
    public void shouldGetLevel() {
        Healer p = new Healer("Lenny");
        assertEquals(p.getLevel(), 1);
    }

    @Test
    public void shouldGetXpNecessary() {
        Healer p = new Healer("Lenny");
        assertEquals(p.getXpNecessary(), 10);
    }

    @Test
    public void shouldGetDamage() {
        Healer p = new Healer("Lenny");
        assertEquals(p.getDamage(), 8);
    }

    @Test
    public void shouldGetDefence() {
        Healer p = new Healer("Lenny");
        assertEquals(p.getDefence(), 2);
    }

    @Test
    public void shouldGetLife() {
        Healer p = new Healer("Lenny");
        assertEquals(p.getLife(), 100);
    }

    @Test
    public void shouldGetHeal() {
        Healer p = new Healer("Lenny");
        assertEquals(p.getHeal(), 20);
    }

    @Test
    public void shouldGetDamageInFight() {
        Healer p = new Healer("Lenny");
        assertEquals(p.getDamageInFight(), 0);
    }

    @Test
    public void shouldSetName() {
        Healer p = new Healer("Lenny");
        p.setName("otherName");
        assertEquals(p.getName(), "otherName");
    }

    @Test
    public void shouldSetXp() {
        Healer p = new Healer("Lenny");
        p.setXp(1);
        assertEquals(p.getXp(), 1);
    }

    @Test
    public void shouldSetLevel() {
        Healer p = new Healer("Lenny");
        p.setLevel(2);
        assertEquals(p.getLevel(), 2);
    }

    @Test
    public void shouldSetXpNecessary() {
        Healer p = new Healer("Lenny");
        p.setXpNecessary(100);
        assertEquals(p.getXpNecessary(), 100);
    }

    @Test
    public void shouldSetDamage() {
        Healer p = new Healer("Lenny");
        p.setDamage(100);
        assertEquals(p.getDamage(), 100);
    }

    @Test
    public void shouldSetDefence() {
        Healer p = new Healer("Lenny");
        p.setDefence(100);
        assertEquals(p.getDefence(), 100);
    }

    @Test
    public void shouldSetLife() {
        Healer p = new Healer("Lenny");
        p.setLife(200);
        assertEquals(p.getLife(), 200);
    }

    @Test
    public void shouldSetHeal() {
        Healer p = new Healer("Lenny");
        p.setHeal(100);
        assertEquals(p.getHeal(), 100);
    }

    @Test
    public void shouldSetDamageInFight() {
        Healer p = new Healer("Lenny");
        p.setDamageInFight(200);
        assertEquals(p.getDamageInFight(), 200);
    }
}
