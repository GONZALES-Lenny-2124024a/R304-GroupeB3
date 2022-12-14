package fr.univamu.iut.game.characters.factory;

import fr.univamu.iut.game.characters.charactersTypes.Archer;
import fr.univamu.iut.game.characters.Character;
import fr.univamu.iut.game.characters.charactersTypes.Healer;
import fr.univamu.iut.game.characters.charactersTypes.Mage;

/**
 * Creates a Character with a given type and name.
 * @param <T> The type of the Character.
 * @author LennyGonzales
 */
public class CharacterFactory<T extends Character> {
    /**
     * Creates a Character with the given type and name.
     * @param characterType The type of the Character.
     * @param nameCharacter The name of the Character.
     * @return The character's type with the given name.
     */
    public T createCharacter(String characterType, String nameCharacter) {
        T character = null;
        switch (characterType.toLowerCase()) {
            case "archer" -> character = (T) new Archer(nameCharacter);
            case "healer" -> character =  (T) new Healer(nameCharacter);
            case "mage" -> character =  (T) new Mage(nameCharacter);
        }
        return character;
    }
}
