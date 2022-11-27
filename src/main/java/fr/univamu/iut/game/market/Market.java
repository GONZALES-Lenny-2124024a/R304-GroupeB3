package fr.univamu.iut.game.market;

public enum Market {
    ARCHER(200),
    HEALER(100),
    MAGE(75);

    private int price;
    Market(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
