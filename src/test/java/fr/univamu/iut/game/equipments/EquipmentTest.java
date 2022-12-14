package fr.univamu.iut.game.equipments;

import fr.univamu.iut.game.equipments.Equipment;
import fr.univamu.iut.game.equipments.EquipmentName;
import fr.univamu.iut.game.equipments.EquipmentType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
