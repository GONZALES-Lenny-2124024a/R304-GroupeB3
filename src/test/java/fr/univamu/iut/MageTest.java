package fr.univamu.iut;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MageTest {
    @Test
    public void shouldGetName() {
        Mage p = new Mage("Lenny");
        assertEquals(p.getName(), "Lenny");
    }

    @Test
    public void shouldGetXp() {
        Mage p = new Mage("Lenny");
        assertEquals(p.getXp(), 0);
    }

    @Test
    public void shouldGetLevel() {
        Mage p = new Mage("Lenny");
        assertEquals(p.getLevel(), 1);
    }

    @Test
    public void shouldGetXpNecessary() {
        Mage p = new Mage("Lenny");
        assertEquals(p.getXpNecessary(), 10);
    }

    @Test
    public void shouldGetDamage() {
        Mage p = new Mage("Lenny");
        assertEquals(p.getDamage(), 10);
    }

    @Test
    public void shouldGetDefence() {
        Mage p = new Mage("Lenny");
        assertEquals(p.getDefence(), 7);
    }


    @Test
    public void shouldGetLife() {
        Mage p = new Mage("Lenny");
        assertEquals(p.getLife(), 100);
    }

    @Test
    public void shouldSetName() {
        Mage p = new Mage("Lenny");
        p.setName("otherName");
        assertEquals(p.getName(), "otherName");
    }

    @Test
    public void shouldSetXp() {
        Mage p = new Mage("Lenny");
        p.setXp(1);
        assertEquals(p.getXp(), 1);
    }

    @Test
    public void shouldSetLevel() {
        Mage p = new Mage("Lenny");
        p.setLevel(2);
        assertEquals(p.getLevel(), 2);
    }

    @Test
    public void shouldSetXpNecessary() {
        Mage p = new Mage("Lenny");
        p.setXpNecessary(100);
        assertEquals(p.getXpNecessary(), 100);
    }

    @Test
    public void shouldSetDamage() {
        Mage p = new Mage("Lenny");
        p.setDamage(100);
        assertEquals(p.getDamage(), 100);
    }

    @Test
    public void shouldSetDefence() {
        Mage p = new Mage("Lenny");
        p.setDefence(100);
        assertEquals(p.getDefence(), 100);
    }

    @Test
    public void shouldSetLife() {
        Mage p = new Mage("Lenny");
        p.setLife(200);
        assertEquals(p.getLife(), 200);
    }
}
