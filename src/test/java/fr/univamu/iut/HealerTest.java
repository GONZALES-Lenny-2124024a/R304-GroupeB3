package fr.univamu.iut;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HealerTest {

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
}
