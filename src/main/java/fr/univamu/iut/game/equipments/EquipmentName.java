package fr.univamu.iut.game.equipments;

public enum EquipmentName {
    SNAKE(10, 1),
    SHADOW(40, 4),
    DAEMON(100, 12),
    ANGEL(200, 25);

    private int price;
    private int points;

    EquipmentName(int price, int points) {
        this.price = price;
        this.points = points;
    }

    public int getPrice() {
        return price;
    }

    public int getPoints() {
        return points;
    }
}
