package fr.univamu.iut;

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
}
