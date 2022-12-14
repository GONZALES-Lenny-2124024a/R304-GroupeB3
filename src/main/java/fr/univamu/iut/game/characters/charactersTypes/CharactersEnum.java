package fr.univamu.iut.game.characters.charactersTypes;


/**
 * Enum to store characters and their respective prices
 * @author LennyGonzales
 */
public enum CharactersEnum {
    ARCHER(200), // Archer character with price of 200
    HEALER(100), // Healer character with price of 100
    MAGE(75); // Mage character with price of 75

    private final int price; // Store the character's price
    CharactersEnum(int price) {
        this.price = price;
    }

    /**
     * Retrieve the character's price
     *
     * @return int price of the character
     */
    public int getPrice() {
        return price;
    }
}
