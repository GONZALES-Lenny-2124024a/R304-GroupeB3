package fr.univamu.iut.game.market;

import fr.univamu.iut.exceptions.EmptyNameForCharactersTeamException;
import fr.univamu.iut.game.characters.Character;
import fr.univamu.iut.game.characters.CharactersTeam;
import fr.univamu.iut.game.characters.charactersTypes.CharactersEnum;
import fr.univamu.iut.game.equipments.EquipmentName;
import fr.univamu.iut.game.equipments.EquipmentType;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the Market class
 * @author LennyGonzales
 */
public class MarketTest<T extends Character> {
    @Test
    public void shouldReturnTheRightType() throws EmptyNameForCharactersTeamException {
        CharactersTeam<T> playerTeam = new CharactersTeam<>("LennyTeam");
        Market<T> market = new Market<>(playerTeam, new Scanner(System.in));

        EquipmentType equipmentWeapon = EquipmentType.WEAPON;
        EquipmentType resultWeapon = market.presentEquipmentName(equipmentWeapon.toString().toLowerCase());
        assertEquals(resultWeapon, equipmentWeapon);

        EquipmentType equipmentArmor = EquipmentType.ARMOR;
        EquipmentType resultArmor = market.presentEquipmentName(equipmentArmor.toString().toLowerCase());
        assertEquals(resultArmor, equipmentArmor);
    }

    @Test
    public void shouldBuyCharacterWithEnoughGold() throws EmptyNameForCharactersTeamException {
        CharactersTeam<T> charactersTeam = new CharactersTeam<>("LennyTeam");
        charactersTeam.setGold(CharactersEnum.ARCHER.getPrice());
        Market<T> market = new Market<>(charactersTeam, new Scanner(System.in));
        market.buyCharacter("archer");

        assertEquals(charactersTeam.getSize(), 1);
        assertEquals(charactersTeam.getGold(), 0);
    }

    @Test
    public void shouldBuyCharacterWithoutEnoughGold() throws EmptyNameForCharactersTeamException {
        CharactersTeam<T> charactersTeam = new CharactersTeam<>("LennyTeam");
        Market<T> market = new Market<>(charactersTeam, new Scanner(System.in));
        market.buyCharacter("archer");

        assertEquals(charactersTeam.getSize(), 0);
        assertEquals(charactersTeam.getGold(), 150);
    }

    @Test
    public void shouldDecreasePlayerTeamGoldsTest() throws EmptyNameForCharactersTeamException {
        CharactersTeam<T> charactersTeam = new CharactersTeam<>("LennyTeam");
        charactersTeam.setGold(200);
        Market<T> market = new Market<>(charactersTeam, new Scanner(System.in));
        market.decreasePlayerTeamGolds(100);
        assertEquals(100 , charactersTeam.getGold());
    }

    @Test
    public void shouldBuyEquipmentWithEnoughGold() throws EmptyNameForCharactersTeamException {
        CharactersTeam<T> charactersTeam = new CharactersTeam<>("LennyTeam");
        charactersTeam.setGold(EquipmentName.ANGEL.getPrice());


        Market<T> market = new Market<>(charactersTeam, new Scanner(System.in));
        market.buyEquipment(EquipmentType.ARMOR, EquipmentName.ANGEL.toString().toLowerCase());

        assertEquals(charactersTeam.getEquipments().size(), 1);
        assertEquals(charactersTeam.getGold(), 0);
    }

    @Test
    public void shouldBuyEquipmentWithoutEnoughGold() throws EmptyNameForCharactersTeamException {
        CharactersTeam<T> charactersTeam = new CharactersTeam<>("LennyTeam");
        Market<T> market = new Market<>(charactersTeam, new Scanner(System.in));
        market.buyCharacter("archer");

        assertEquals(charactersTeam.getSize(), 0);
        assertEquals(charactersTeam.getGold(), 150);
    }
}
