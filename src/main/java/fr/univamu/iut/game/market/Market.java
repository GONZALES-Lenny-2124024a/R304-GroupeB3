package fr.univamu.iut.game.market;

/**
 * Market which contains all the characters that the user can buy
 */
public enum Market {
    ARCHER(200),
    HEALER(100),
    MAGE(75);

    private final int price;
    Market(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
