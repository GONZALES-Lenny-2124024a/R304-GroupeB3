package fr.univamu.iut.game.characters.charactersTypes;

import fr.univamu.iut.game.characters.Character;
import fr.univamu.iut.game.characters.attributs.Distance;

/**
 * Class representing an Archer character.
 * Extends the Character Class.
 * Implements the Distance interface.
 *
 * @author LennyGonzales
 */
public class Archer extends Character implements Distance {
    /**
     * Constructor for the Archer class
     * @param name the name of the Archer character
     */
    public Archer(String name) {
        super(name);
        setDamage(15);
        setDefence(5);
    }

    /**
     * Increase the stats of the Archer character
     */
    @Override
    public void increaseStats() {
        setDamage((int) (getDamage() * 1.3));
        setDefence((int) (getDefence() * 1.1));
    }

    /**
     * Returns a description of the character's ability to attack from a distance.
     * @return the description
     */
    @Override
    public String distance() {
        return "He shoots arrows from a distance !";
    }

    /**
     * Performs special attack on the target.
     * @param pEnemy target character
     * @return the amount of damage done
     */
    @Override
    public int specialAttack(Character pEnemy) {
        pEnemy.setLife((getLife() + getDefenceWithEquipments()) - (2*getDamageWithEquipments()));
        return (2 * getDamage());
    }

    /**
     * Returns a string representation of the Archer character.
     * @return the description
     */
    @Override
    public String toString() {
        return  "Archer" + '\n' +
                super.toString() + '\n' +
                "Skills : " + distance() + '\n';
    }
}
