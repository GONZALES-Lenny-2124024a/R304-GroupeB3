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
}
