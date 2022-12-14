package fr.univamu.iut.game.equipments;

import fr.univamu.iut.game.equipments.EquipmentType;

/**
 * Class representing an equipment.
 * @author LennyGonzales
 */
public class Equipment {
    private EquipmentType equipmentType;
    private EquipmentName equipmentName;

    public Equipment(EquipmentType equipmentType, EquipmentName equipmentName) {
        this.equipmentType = equipmentType;
        this.equipmentName = equipmentName;
    }

    /**
     * Get the type of the equipment
     * @return his type
     */
    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    /**
     * Set the type of the equipment
     * @param equipmentType the new type
     */
    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    /**
     * Get the name of the equipment
     * @return his name
     */
    public EquipmentName getEquipmentName() {
        return equipmentName;
    }

    /**
     * Set the name of the equipment
     * @param equipmentName the new name
     */
    public void setEquipmentName(EquipmentName equipmentName) {
        this.equipmentName = equipmentName;
    }
}
