package fr.univamu.iut.game.characters;

import fr.univamu.iut.exceptions.CharacterTypeNotFoundException;
import fr.univamu.iut.game.characters.charactersTypes.Archer;
import fr.univamu.iut.game.characters.charactersTypes.Healer;
import fr.univamu.iut.game.characters.charactersTypes.Mage;
import fr.univamu.iut.game.characters.factory.CharacterFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the CharacterFactory class
 * @author LennyGonzales
 */
public class CharacterFactoryTest {
    @Test
    public void shouldReturnArcher() throws CharacterTypeNotFoundException  {
        CharacterFactory characterFactory = new CharacterFactory();
        assertTrue(characterFactory.createCharacter("archer", "Lenny") instanceof Archer);
    }

    @Test
    public void shouldReturnHealer() throws CharacterTypeNotFoundException {
        CharacterFactory characterFactory = new CharacterFactory();
        assertTrue(characterFactory.createCharacter("healer", "Lenny") instanceof Healer);
    }

    @Test
    public void shouldReturnMage() throws CharacterTypeNotFoundException {
        CharacterFactory characterFactory = new CharacterFactory();
        assertTrue(characterFactory.createCharacter("mage", "Lenny") instanceof Mage);
    }

    @Test
    public void shouldReturnNull() {
        CharacterFactory characterFactory = new CharacterFactory();
        assertThrows(CharacterTypeNotFoundException.class, () -> characterFactory.createCharacter("UnknownType", "Lenny"));
    }
}
