package fr.univamu.iut.game.characters;

import fr.univamu.iut.exceptions.RandomValueNotBetween0And1Exception;
import fr.univamu.iut.game.characters.charactersTypes.Archer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for the Archer class
 * @author LennyGonzales
 */
public class ArcherTest {


    @Test
    public void shouldCriticalAttack() throws InterruptedException, RandomValueNotBetween0And1Exception {
        Archer cPlayer = new Archer("Lenny");
        Archer ePlayer = new Archer("Enemy");

        cPlayer.attack(ePlayer, 0.02);
        assertEquals(ePlayer.getLife(), 60);
    }

    @Test
    public void shouldSpecialAttack() throws InterruptedException, RandomValueNotBetween0And1Exception {
        Archer cPlayer = new Archer("Lenny");
        Archer ePlayer = new Archer("Enemy");

        cPlayer.attack(ePlayer, 0.12);
        assertEquals(ePlayer.getLife(), 75);
    }

    @Test
    public void shouldBasicAttack() throws InterruptedException, RandomValueNotBetween0And1Exception {
        Archer cPlayer = new Archer("Lenny");
        Archer ePlayer = new Archer("Enemy");

        cPlayer.attack(ePlayer, 0.5);
        assertEquals(ePlayer.getLife(), 90);
    }

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
    public void shouldGetDamageEquipments() {
        Archer p = new Archer("Lenny");
        assertEquals(p.getDamageEquipments(), 0);
    }

    @Test
    public void shouldGetDefenceEquipments() {
        Archer p = new Archer("Lenny");
        assertEquals(p.getDefenceEquipments(), 0);
    }

    @Test
    public void shouldGetDamageWithEquipments() {
        Archer p = new Archer("Lenny");
        assertEquals(p.getDamageWithEquipments(), 15);
    }

    @Test
    public void shouldGetDefenceWithEquipments() {
        Archer p = new Archer("Lenny");
        assertEquals(p.getDefenceWithEquipments(), 5);
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

    @Test
    public void shouldSetDamageWithEquipments() {
        Archer p = new Archer("Lenny");
        p.setDamageEquipments(10);
        assertEquals(p.getDamageWithEquipments(), 25);
    }

    @Test
    public void shouldSetDefenceWithEquipments() {
        Archer p = new Archer("Lenny");
        p.setDefenceEquipments(10);
        assertEquals(p.getDefenceWithEquipments(), 15);
    }

    @Test
    public void shouldSetDamageEquipments() {
        Archer p = new Archer("Lenny");
        p.setDamageEquipments(10);
        assertEquals(p.getDamageEquipments(), 10);
    }

    @Test
    public void shouldSetDefenceEquipments() {
        Archer p = new Archer("Lenny");
        p.setDefenceEquipments(10);
        assertEquals(p.getDefenceEquipments(), 10);
    }

    @Test
    public void shouldThrowRandomValueNotBetween0And1Exception() {
        Archer archerPlayer = new Archer("Lenny");
        Archer archerEnemy = new Archer("Enemy");
        assertThrows(RandomValueNotBetween0And1Exception.class, () -> archerPlayer.attack(archerEnemy, -1));
        assertThrows(RandomValueNotBetween0And1Exception.class, () -> archerPlayer.attack(archerEnemy, 2));
    }
}
