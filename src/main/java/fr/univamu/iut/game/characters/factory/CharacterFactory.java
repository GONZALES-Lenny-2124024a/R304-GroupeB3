package fr.univamu.iut.game.characters.factory;

import fr.univamu.iut.game.characters.charactersTypes.Archer;
import fr.univamu.iut.game.characters.Character;
import fr.univamu.iut.game.characters.charactersTypes.Healer;
import fr.univamu.iut.game.characters.charactersTypes.Mage;

public class CharacterFactory<T extends Character> {
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
