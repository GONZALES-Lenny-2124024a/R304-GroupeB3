package fr.univamu.iut.game;

import fr.univamu.iut.game.characters.Archer;
import fr.univamu.iut.game.characters.CharactersTeam;
import fr.univamu.iut.game.characters.Mage;
import fr.univamu.iut.game.characters.Character;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTeamTest {
    @Test
    public void shouldGetName() {
        CharactersTeam team = new CharactersTeam("LennyTeam");
        assertEquals(team.getName(), "LennyTeam");
    }

    @Test
    public void shouldSetName() {
        CharactersTeam team = new CharactersTeam("LennyTeam");
        team.setName("OtherName");
        assertEquals(team.getName(), "OtherName");
    }

    @Test
    public void shouldGetGold() {
        CharactersTeam team = new CharactersTeam("LennyTeam");
        assertEquals(team.getGold(), 0);
    }

    @Test
    public void shouldSetGold() {
        CharactersTeam team = new CharactersTeam("LennyTeam");
        team.setGold(100);
        assertEquals(team.getGold(), 100);
    }

    @Test
    public void shouldGetSpecificCharacter() {
        Mage p = new Mage("Lenny");
        CharactersTeam team = new CharactersTeam("LennyTeam");
        team.addCharacter(p);
        assertEquals(team.getSpecificCharacter(0), p);
    }

    @Test
    public void shouldAddACharacter() {
        Mage p = new Mage("Lenny");
        CharactersTeam team = new CharactersTeam("LennyTeam");
        team.addCharacter(p);
        assertEquals(team.getSpecificCharacter(0), p);
    }

    @Test
    public void shouldGetSize() {
        Mage p = new Mage("Lenny");
        CharactersTeam team = new CharactersTeam("LennyTeam");
        team.addCharacter(p);
        assertEquals(team.getSize(), 1);
    }

    @Test
    public void shouldDelCharacter() {
        Mage p = new Mage("Lenny");
        CharactersTeam team = new CharactersTeam("LennyTeam");
        team.addCharacter(p);
        team.delCharacter(p);
        assertEquals(team.getSize(), 0);
    }

    @Test
    public void shouldGetCharacters() {
        Mage p = new Mage("Lenny");
        List<Character> listCharacters = new ArrayList<>();
        listCharacters.add(p);

        CharactersTeam team = new CharactersTeam("LennyTeam");
        team.addCharacter(p);
        assertEquals(team.getCharacters(), listCharacters);
    }

    @Test
    public void shouldSetCharacters() {
        Mage p = new Mage("Lenny");
        List<Character> listCharacters = new ArrayList<>();
        listCharacters.add(p);

        CharactersTeam team = new CharactersTeam("LennyTeam");
        team.addCharacter(new Archer("archer"));
        team.setCharacters(listCharacters);

        assertEquals(team.getCharacters(), listCharacters);
    }
}