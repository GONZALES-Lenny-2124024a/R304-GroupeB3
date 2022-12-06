package fr.univamu.iut.game;

import fr.univamu.iut.game.Archer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArcherTest {
    @Test
    public void shouldGetName() {
        Archer p = new Archer("Lenny");
        assertEquals(p.getName(), "Lenny");
    }

    @Test
    public void shouldGetXp() {
        Archer p = new Archer("Lenny");
        assertEquals(p.getXp(), 0);
    }

    @Test
    public void shouldGetLevel() {
        Archer p = new Archer("Lenny");
        assertEquals(p.getLevel(), 1);
    }

    @Test
    public void shouldGetXpNecessary() {
        Archer p = new Archer("Lenny");
        assertEquals(p.getXpNecessary(), 10);
    }

    @Test
    public void shouldGetDamage() {
        Archer p = new Archer("Lenny");
        assertEquals(p.getDamage(), 15);
    }

    @Test
    public void shouldGetDefence() {
        Archer p = new Archer("Lenny");
        assertEquals(p.getDefence(), 5);
    }


    @Test
    public void shouldGetLife() {
        Archer p = new Archer("Lenny");
        assertEquals(p.getLife(), 100);
    }

    @Test
    public void shouldGetDamageInFight() {
        Archer p = new Archer("Lenny");
        assertEquals(p.getDamageInFight(), 0);
    }

    @Test
    public void shouldSetName() {
        Archer p = new Archer("Lenny");
        p.setName("otherName");
        assertEquals(p.getName(), "otherName");
    }

    @Test
    public void shouldSetXp() {
        Archer p = new Archer("Lenny");
        p.setXp(1);
        assertEquals(p.getXp(), 1);
    }

    @Test
    public void shouldSetLevel() {
        Archer p = new Archer("Lenny");
        p.setLevel(2);
        assertEquals(p.getLevel(), 2);
    }

    @Test
    public void shouldSetXpNecessary() {
        Archer p = new Archer("Lenny");
        p.setXpNecessary(100);
        assertEquals(p.getXpNecessary(), 100);
    }

    @Test
    public void shouldSetDamage() {
        Archer p = new Archer("Lenny");
        p.setDamage(100);
        assertEquals(p.getDamage(), 100);
    }

    @Test
    public void shouldSetDefence() {
        Archer p = new Archer("Lenny");
        p.setDefence(100);
        assertEquals(p.getDefence(), 100);
    }

    @Test
    public void shouldSetLife() {
        Archer p = new Archer("Lenny");
        p.setLife(200);
        assertEquals(p.getLife(), 200);
    }

    @Test
    public void shouldSetDamageInFight() {
        Archer p = new Archer("Lenny");
        p.setDamageInFight(200);
        assertEquals(p.getDamageInFight(), 200);
    }
}
