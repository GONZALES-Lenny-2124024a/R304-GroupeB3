package fr.univamu.iut.game.characters.charactersTypes;

/**
 * Market which contains all the characters that the user can buy
 */
public enum CharactersEnum {
    ARCHER(200),
    HEALER(100),
    MAGE(75);

    private final int price;
    CharactersEnum(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
