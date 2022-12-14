package fr.univamu.iut.game.market;

import fr.univamu.iut.game.characters.Character;
import fr.univamu.iut.game.characters.charactersTypes.CharactersEnum;
import fr.univamu.iut.game.characters.factory.CharacterFactory;
import fr.univamu.iut.game.characters.CharactersTeam;
import fr.univamu.iut.game.equipments.Equipment;
import fr.univamu.iut.game.equipments.EquipmentName;
import fr.univamu.iut.game.equipments.EquipmentType;

import java.util.Scanner;

public class Market<T extends Character> {

    private CharactersTeam<T> playerTeam;
    private Scanner input;
    private String inputStr;
    private StringBuilder output;

    public Market(CharactersTeam<T> playerTeam, Scanner input) {
        this.playerTeam = playerTeam;
        this.input = input;
        output = new StringBuilder();
    }

    public void marketMode() {
        System.out.println("Characters | Equipments");
        System.out.println("Enter a catagory :");
        switch (input.nextLine().toLowerCase()) {
            case "characters":
                presentationItemsInCategory(CharactersEnum.values());
                break;
            case "equipments":
                presentationItemsInCategory(EquipmentType.values());
                break;
        }
    }

    public void presentationItemsInCategory(Enum<?>[] enumerator) {
        if(enumerator[0] instanceof CharactersEnum) {
            presentCharactersEnum();
            buyCharacter();
        } else if (enumerator[0] instanceof EquipmentType) {
            buyEquipment(presentEquipmentType());
        }
    }

    public void presentCharactersEnum() {
        for (CharactersEnum charactersEnum : CharactersEnum.values()) {
            System.out.println(charactersEnum.toString() + " - Price : " + charactersEnum.getPrice());
        }
    }

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
        return presentEquipmentName(input.nextLine().toLowerCase());
    }

    public EquipmentType presentEquipmentName(String inputStr) {
        for(EquipmentType equipmentType : EquipmentType.values()) {
            if ((equipmentType.toString().toLowerCase()).equals(inputStr)) {    // Get the category type
                for (EquipmentName equipmentName : EquipmentName.values()) {
                    System.out.println(equipmentName.toString() + " - Price : " + equipmentName.getPrice());
                }

                // Buy character
                return equipmentType;
            }
        }
        return null;
    }

    public void buyEquipment(EquipmentType equipmentType) {
        System.out.println("Enter a equipment name");
        inputStr = input.nextLine().toLowerCase();
        for (EquipmentName equipmentName : EquipmentName.values()) {
            if ((equipmentName.toString().toLowerCase()).equals(inputStr)) {    // Get the category type
                if (playerTeam.getGold() > equipmentName.getPrice()) {
                    playerTeam.addEquipment(new Equipment(equipmentType, equipmentName));
                    decreasePlayerTeamGolds(equipmentName.getPrice());
                } else {
                    System.out.println("You don't have enough gold !");
                }
            }
        }
    }

    public void buyCharacter() {
        CharacterFactory characterFactory = new CharacterFactory();
        System.out.println("Enter the name of the character that you want to buy :");
        inputStr = input.nextLine().toLowerCase();
        for(CharactersEnum charactersEnum : CharactersEnum.values()) {
            if ((charactersEnum.toString().toLowerCase()).equals(inputStr)) {
                if (playerTeam.getGold() > charactersEnum.getPrice()) { // Verify if the user have enough golds
                    decreasePlayerTeamGolds(charactersEnum.getPrice());
                    playerTeam.addCharacter((T) characterFactory.createCharacter(charactersEnum.toString(), "Player" + (playerTeam.getSize() + 1)));
                } else {
                    System.out.println("You don't have enough gold !");
                }
            }
        }
        System.out.println(playerTeam);
    }

    public void decreasePlayerTeamGolds(int golds) {
        playerTeam.setGold(playerTeam.getGold() - golds);
    }
}
