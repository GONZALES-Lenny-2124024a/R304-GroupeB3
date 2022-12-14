package fr.univamu.iut.game.equipments;

/**
 * Enum to store names of an equipment
 * @author LennyGonzales
 */
public enum EquipmentName {
    SNAKE(10, 1),
    SHADOW(40, 4),
    DAEMON(100, 12),
    ANGEL(200, 25);

    private final int price;
    private final int points;

    EquipmentName(int price, int points) {
        this.price = price;
        this.points = points;
    }

    /**
     * Get the price of this equipment associated to the name
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Get the points attributed by this equipment associated to the name
     * @return the points
     */
    public int getPoints() {
        return points;
    }
}
