package fr.univamu.iut.game.equipments;

import fr.univamu.iut.game.equipments.EquipmentType;

/**
 * Represents an equipment
 */
public class Equipment {
    private EquipmentType equipmentType;
    private EquipmentName equipmentName;

    public Equipment(EquipmentType equipmentType, EquipmentName equipmentName) {
        this.equipmentType = equipmentType;
        this.equipmentName = equipmentName;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public EquipmentName getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(EquipmentName equipmentName) {
        this.equipmentName = equipmentName;
    }
}
