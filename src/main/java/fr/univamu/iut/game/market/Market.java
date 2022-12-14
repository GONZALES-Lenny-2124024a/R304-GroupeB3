package fr.univamu.iut.game.market;

import fr.univamu.iut.game.characters.Character;
import fr.univamu.iut.game.characters.charactersTypes.CharactersEnum;
import fr.univamu.iut.game.characters.factory.CharacterFactory;
import fr.univamu.iut.game.characters.CharactersTeam;
import fr.univamu.iut.game.equipments.Equipment;
import fr.univamu.iut.game.equipments.EquipmentName;
import fr.univamu.iut.game.equipments.EquipmentType;

import java.util.Scanner;

/**
 * Supports the market
 * @param <T> accepts types of character
 * @author LennyGonzales
 */
public class Market<T extends Character> {

    private CharactersTeam<T> playerTeam;
    private Scanner input;
    private StringBuilder output;

    public Market(CharactersTeam<T> playerTeam, Scanner input) {
        this.playerTeam = playerTeam;
        this.input = input;
        output = new StringBuilder();
    }

    /**
     * Ask the user what category of products he wants to buy
     */
    public void marketMode() {
        System.out.println("Characters | Equipments");
        System.out.println("Enter a category :");
        switch (input.nextLine().toLowerCase()) {
            case "characters":
                presentationItemsInCategory(CharactersEnum.values());
                break;
            case "equipments":
                presentationItemsInCategory(EquipmentType.values());
                break;
        }
    }

    /**
     * Presents a category's items
     * @param enumerator a list of enumerator value associated to a type of category
     */
    public void presentationItemsInCategory(Enum<?>[] enumerator) {
        if(enumerator[0] instanceof CharactersEnum) {
            presentCharactersEnum();
            System.out.println("Enter the name of the character that you want to buy :");
            buyCharacter(input.nextLine().toLowerCase());;
        } else if (enumerator[0] instanceof EquipmentType) {
            buyEquipment(presentEquipmentType(), input.nextLine().toLowerCase());
        }
    }

    /**
     * Presents the characters enumerator to the user
     */
    public void presentCharactersEnum() {
        for (CharactersEnum charactersEnum : CharactersEnum.values()) {
            System.out.println(charactersEnum.toString() + " - Price : " + charactersEnum.getPrice());
        }
    }

    /**
     * Presents the different types of equipments to the user and ask him to enter a category
     * @return an equipment type
     */
    public EquipmentType presentEquipmentType() {
        // Presentation category
        output.delete(0, output.length());
        for(EquipmentType equipmentType : EquipmentType.values()) {
            output.append(equipmentType.toString().toLowerCase() + " | ");
        }
        output.delete(output.length() - 2, output.length() + 1);    // Delete the last " | "
        System.out.println(output);

        // Presentation items
        System.out.println("Enter a category :");
        String equipmentTypeStr = input.nextLine().toLowerCase();

        System.out.println("Enter a equipment name");
        return presentEquipmentName(equipmentTypeStr);
    }

    /**
     * Presents the equipments name for a category of equipment
     * @param equipmentTypeStr a category string
     * @return an equipment type
     */
    public EquipmentType presentEquipmentName(String equipmentTypeStr) {
        for(EquipmentType equipmentType : EquipmentType.values()) {
            if ((equipmentType.toString().toLowerCase()).equals(equipmentTypeStr)) {    // Get the category type
                for (EquipmentName equipmentName : EquipmentName.values()) {
                    System.out.println(equipmentName.toString() + " - Price : " + equipmentName.getPrice());
                }

                // Buy character
                return equipmentType;
            }
        }
        return null;
    }

    /**
     * Supports the payment of an equipment
     * @param equipmentType the type of the equipment
     * @param equipmentNameStr the string of an equipmentName
     */
    public void buyEquipment(EquipmentType equipmentType, String equipmentNameStr) {
        for (EquipmentName equipmentName : EquipmentName.values()) {
            if ((equipmentName.toString().toLowerCase()).equals(equipmentNameStr)) {    // Get the category type
                if (playerTeam.getGold() >= equipmentName.getPrice()) {
                    playerTeam.addEquipment(new Equipment(equipmentType, equipmentName));
                    decreasePlayerTeamGolds(equipmentName.getPrice());
                } else {
                    System.out.println("You don't have enough gold !");
                }
            }
        }
    }

    /**
     * Supports the payment of a character
     * @param characterStr the string of a type of character
     */
    public void buyCharacter(String characterStr) {
        CharacterFactory characterFactory = new CharacterFactory();
        for(CharactersEnum charactersEnum : CharactersEnum.values()) {
            if ((charactersEnum.toString().toLowerCase()).equals(characterStr)) {
                if (playerTeam.getGold() >= charactersEnum.getPrice()) { // Verify if the user have enough golds
                    decreasePlayerTeamGolds(charactersEnum.getPrice());
                    playerTeam.addCharacter((T) characterFactory.createCharacter(charactersEnum.toString(), "Player" + (playerTeam.getSize() + 1)));
                    playerTeam.getSpecificCharacter(playerTeam.getSize() - 1).update(playerTeam.getEquipments());   // Notify the new character, so it can get the equipments
                } else {
                    System.out.println("You don't have enough gold !");
                }
            }
        }
    }

    /**
     * Decrease the number of golds of the player team
     * @param golds the number of gold to decrease
     */
    public void decreasePlayerTeamGolds(int golds) {
        playerTeam.setGold(playerTeam.getGold() - golds);
    }
}
