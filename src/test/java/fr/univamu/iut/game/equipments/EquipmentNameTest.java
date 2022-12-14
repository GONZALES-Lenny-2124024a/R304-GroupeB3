package fr.univamu.iut.game.equipments;

import fr.univamu.iut.game.equipments.EquipmentName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EquipmentNameTest {

    @Test
    public void testEquipmentNameGetPrice() {
        assertEquals(10, EquipmentName.SNAKE.getPrice());
        assertEquals(40, EquipmentName.SHADOW.getPrice());
        assertEquals(100, EquipmentName.DAEMON.getPrice());
        assertEquals(200, EquipmentName.ANGEL.getPrice());
    }

    @Test
    public void testEquipmentNameGetPoints() {
        assertEquals(1, EquipmentName.SNAKE.getPoints());
        assertEquals(4, EquipmentName.SHADOW.getPoints());
        assertEquals(12, EquipmentName.DAEMON.getPoints());
        assertEquals(25, EquipmentName.ANGEL.getPoints());
    }
}
