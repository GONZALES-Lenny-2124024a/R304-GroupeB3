package fr.univamu.iut.game.characters;

import fr.univamu.iut.exceptions.EmptyNameForPlayerTeamException;
import fr.univamu.iut.game.equipments.Equipment;
import fr.univamu.iut.game.equipments.EquipmentType;
import fr.univamu.iut.observerPattern.Observable;
import fr.univamu.iut.observerPattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Team of characters
 * @param <T> accepts types of character (Mage, Healer, Archer)
 */
public class CharactersTeam<T extends Character> implements Observable {
    private String name;
    private List<T> characters;
    private List<Equipment> equipments;
    private int gold;

    public CharactersTeam(String name) throws EmptyNameForPlayerTeamException {
        if(name.length() > 0) {
            this.name = name;
        } else {
            throw new EmptyNameForPlayerTeamException();
        }
        characters = new ArrayList<>();
        equipments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addCharacter(T character) {
        characters.add(character);
    }

    public void delCharacter(T character) {
        characters.remove(character);
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
        notifyAllObservers();
    }

    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
        notifyAllObservers();
    }

    public void delEquipment(Equipment equipment) {
        equipments.remove(equipment);
        notifyAllObservers();
    }

    public int getSize() { return getCharacters().size(); }

    public T getSpecificCharacter(int indexCharacter) {
        return getCharacters().get(indexCharacter);
    }

    public List<T> getCharacters() {
        return characters;
    }

    public void setCharacters(List<T> characters) {
        this.characters = characters;
    }

    @Override
    public void addObserver(Observer observer) {
        if (observer instanceof Character) {
            addCharacter((T) observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observer instanceof Character) {
            delCharacter((T) observer);
        }
    }

    @Override
    public void notifyAllObservers() {
        for (Character character : characters) {
            character.update(equipments);
        }
    }

    @Override
    public String toString() {
        return  getName() + '\n' +
                "Characters : " + '\n' + characters + '\n' +
                "Gold : " + getGold();
    }
}
