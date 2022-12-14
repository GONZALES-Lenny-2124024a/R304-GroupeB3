package fr.univamu.iut.game.characters;

import fr.univamu.iut.exceptions.EmptyNameForCharactersTeamException;
import fr.univamu.iut.game.characters.charactersTypes.Archer;
import fr.univamu.iut.game.characters.CharactersTeam;
import fr.univamu.iut.game.characters.charactersTypes.Mage;
import fr.univamu.iut.game.characters.Character;
import fr.univamu.iut.game.equipments.Equipment;
import fr.univamu.iut.game.equipments.EquipmentName;
import fr.univamu.iut.game.equipments.EquipmentType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the characters team class
 */
public class CharactersTeamTest {
    @Test
    public void shouldThrowExceptionEmptyNameForCharactersTeam() {
        assertThrows(EmptyNameForCharactersTeamException.class, () -> new CharactersTeam(""));
    }
    @Test
    public void shouldGetName() throws EmptyNameForCharactersTeamException {
        CharactersTeam team = new CharactersTeam("LennyTeam");
        assertEquals(team.getName(), "LennyTeam");
    }

    @Test
    public void shouldSetName() throws EmptyNameForCharactersTeamException {
        CharactersTeam team = new CharactersTeam("LennyTeam");
        team.setName("OtherName");
        assertEquals(team.getName(), "OtherName");
    }

    @Test
    public void shouldGetGold() throws EmptyNameForCharactersTeamException {
        CharactersTeam team = new CharactersTeam("LennyTeam");
        assertEquals(team.getGold(), 0);
    }

    @Test
    public void shouldSetGold() throws EmptyNameForCharactersTeamException {
        CharactersTeam team = new CharactersTeam("LennyTeam");
        team.setGold(100);
        assertEquals(team.getGold(), 100);
    }

    @Test
    public void shouldGetSpecificCharacter() throws EmptyNameForCharactersTeamException {
        Mage p = new Mage("Lenny");
        CharactersTeam team = new CharactersTeam("LennyTeam");
        team.addCharacter(p);
        assertEquals(team.getSpecificCharacter(0), p);
    }

    @Test
    public void shouldAddACharacter() throws EmptyNameForCharactersTeamException {
        Mage p = new Mage("Lenny");
        CharactersTeam team = new CharactersTeam("LennyTeam");
        team.addCharacter(p);
        assertEquals(team.getSpecificCharacter(0), p);
    }

    @Test
    public void shouldGetSize() throws EmptyNameForCharactersTeamException {
        Mage p = new Mage("Lenny");
        CharactersTeam team = new CharactersTeam("LennyTeam");
        team.addCharacter(p);
        assertEquals(team.getSize(), 1);
    }

    @Test
    public void shouldDelCharacter() throws EmptyNameForCharactersTeamException {
        Mage p = new Mage("Lenny");
        CharactersTeam team = new CharactersTeam("LennyTeam");
        team.addCharacter(p);
        team.delCharacter(p);
        assertEquals(team.getSize(), 0);
    }

    @Test
    public void shouldGetCharacters() throws EmptyNameForCharactersTeamException {
        Mage p = new Mage("Lenny");
        List<Character> listCharacters = new ArrayList<>();
        listCharacters.add(p);

        CharactersTeam team = new CharactersTeam("LennyTeam");
        team.addCharacter(p);
        assertEquals(team.getCharacters(), listCharacters);
    }

    @Test
    public void shouldSetCharacters() throws EmptyNameForCharactersTeamException {
        Mage p = new Mage("Lenny");
        List<Character> listCharacters = new ArrayList<>();
        listCharacters.add(p);

        CharactersTeam team = new CharactersTeam("LennyTeam");
        team.addCharacter(new Archer("archer"));
        team.setCharacters(listCharacters);

        assertEquals(team.getCharacters(), listCharacters);
    }

    @Test
    public void testGetEquipments() throws EmptyNameForCharactersTeamException {
        CharactersTeam team = new CharactersTeam("LennyTeam");
        List<Equipment> equipment = new ArrayList<>();
        assertEquals(equipment, team.getEquipments());
    }

    @Test
    public void testSetEquipments() throws EmptyNameForCharactersTeamException {
        CharactersTeam team = new CharactersTeam("LennyTeam");
        List<Equipment> equipment = new ArrayList<>();
        equipment.add(new Equipment(EquipmentType.ARMOR, EquipmentName.SNAKE));
        equipment.add(new Equipment(EquipmentType.WEAPON, EquipmentName.SHADOW));
        team.setEquipments(equipment);
        assertEquals(equipment, team.getEquipments());
    }

    @Test
    public void testAddEquipments() throws EmptyNameForCharactersTeamException {
        CharactersTeam team = new CharactersTeam("LennyTeam");
        Equipment equipment = new Equipment(EquipmentType.ARMOR, EquipmentName.ANGEL);

        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(equipment);

        team.addEquipment(equipment);
        assertEquals(equipmentList, team.getEquipments());
    }
}