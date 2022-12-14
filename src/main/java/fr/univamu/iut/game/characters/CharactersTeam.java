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
 * @author LennyGonzales
 */
public class CharactersTeam<T extends Character> implements Observable {
    private String name;
    private List<T> characters;
    private List<Equipment> equipments;
    private int gold;

    /**
     * Constructor
     * @param name the name of the team
     * @throws EmptyNameForPlayerTeamException if the input name is empty, we throw this exception
     */
    public CharactersTeam(String name) throws EmptyNameForPlayerTeamException {
        if(name.length() > 0) {
            this.name = name;
        } else {
            throw new EmptyNameForPlayerTeamException();
        }
        characters = new ArrayList<>();
        equipments = new ArrayList<>();
    }

    /**
     * Get the name of the characters team
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the team
     * @param name the new name of the team
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the number of gold of the team
     * @return
     */
    public int getGold() {
        return gold;
    }

    /**
     * Set the number of gold of the team
     * @param gold
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * Add a type of character to the team
     * @param character the type of character to add
     */
    public void addCharacter(T character) {
        characters.add(character);
    }

    /**
     * Delete a character of the team
     * @param character the character to delete
     */
    public void delCharacter(T character) {
        characters.remove(character);
    }

    /**
     * Get the equipments of the team's characters
     * @return the equipments
     */
    public List<Equipment> getEquipments() {
        return equipments;
    }

    /**
     * Set the equipments list
     * @param equipments the new equipments list
     */
    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
        notifyAllObservers();
    }

    /**
     * Add an equipment
     * @param equipment the equipment to add
     */
    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
        notifyAllObservers();
    }

    /**
     * Delete an equipment
     * @param equipment the quipment to delete
     */
    public void delEquipment(Equipment equipment) {
        equipments.remove(equipment);
        notifyAllObservers();
    }

    /**
     * Get the number of characters in the team
     * @return the number of characters
     */
    public int getSize() { return getCharacters().size(); }

    /**
     * Get a specific character in the team
     * @param indexCharacter the index of the character
     * @return the character associated with the input index
     */
    public T getSpecificCharacter(int indexCharacter) {
        return getCharacters().get(indexCharacter);
    }

    /**
     * Get the list of characters
     * @return the list of characters
     */
    public List<T> getCharacters() {
        return characters;
    }

    /**
     * Set tghe list of characters
     * @param characters the new list of characters
     */
    public void setCharacters(List<T> characters) {
        this.characters = characters;
    }

    /**
     * Add an observer
     * @param observer the observer to add
     */
    @Override
    public void addObserver(Observer observer) {
        if (observer instanceof Character) {
            addCharacter((T) observer);
        }
    }

    /**
     * Remove an observer
     * @param observer the observer to remove
     */
    @Override
    public void removeObserver(Observer observer) {
        if (observer instanceof Character) {
            delCharacter((T) observer);
        }
    }

    /**
     * Notify the observers
     */
    @Override
    public void notifyAllObservers() {
        for (Character character : characters) {
            character.update(equipments);
        }
    }

    /**
     * Describes the characters team
     * @return the description
     */
    @Override
    public String toString() {
        return  getName() + '\n' +
                "Characters : " + '\n' + characters + '\n' +
                "Gold : " + getGold();
    }
}
