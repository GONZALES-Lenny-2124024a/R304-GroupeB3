package fr.univamu.iut.game.equipments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Equipment class
 * @author LennyGonzales
 */
public class EquipmentTest {

    @Test
    public void testGetEquipmentType() {
        Equipment equipment = new Equipment(EquipmentType.ARMOR, EquipmentName.SNAKE);
        assertEquals(EquipmentType.ARMOR, equipment.getEquipmentType());
    }

    @Test
    public void testSetEquipmentType() {
        Equipment equipment = new Equipment(EquipmentType.ARMOR, EquipmentName.SNAKE);
        equipment.setEquipmentType(EquipmentType.WEAPON);
        assertEquals(EquipmentType.WEAPON, equipment.getEquipmentType());
    }

    @Test
    public void testGetEquipmentName() {
        Equipment equipment = new Equipment(EquipmentType.ARMOR, EquipmentName.SNAKE);
        assertEquals(EquipmentName.SNAKE, equipment.getEquipmentName());
    }

    @Test
    public void testSetEquipmentName() {
        Equipment equipment = new Equipment(EquipmentType.ARMOR, EquipmentName.SNAKE);
        equipment.setEquipmentName(EquipmentName.SHADOW);
        assertEquals(EquipmentName.SHADOW, equipment.getEquipmentName());
    }
}
