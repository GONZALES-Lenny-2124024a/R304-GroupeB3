package fr.univamu.iut.game.characters;

import fr.univamu.iut.exceptions.EmptyNameForPlayerTeamException;

import java.util.ArrayList;
import java.util.List;

/**
 * Team of characters
 * @param <T> accepts types of character (Mage, Healer, Archer)
 */
public class CharactersTeam<T extends Character> {
    private String name;
    private List<T> characters;
    private int gold;

    public CharactersTeam(String name) throws EmptyNameForPlayerTeamException {
        if(name.length() > 0) {
            this.name = name;
        } else {
            throw new EmptyNameForPlayerTeamException();
        }
        characters = new ArrayList<>();
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
    public String toString() {
        return  getName() + '\n' +
                "Characters : " + '\n' + characters + '\n' +
                "Gold : " + getGold();
    }
}
