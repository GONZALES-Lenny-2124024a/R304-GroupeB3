package fr.univamu.iut.game.characters.charactersTypes;

import fr.univamu.iut.game.characters.Character;
import fr.univamu.iut.game.characters.attributs.Distance;
import fr.univamu.iut.game.characters.attributs.Fly;

/**
 * Class representing a Healer character.
 * A Healer is a Character with special abilities to heal himself and fly.
 * It performs ranged attack.
 *
 * @author LennyGonzales
 */
public class Healer extends Character implements Distance, Fly {
    private int heal;

    /**
     * Constructor for the Healer class.
     * @param name the name of the Healer character
     */
    public Healer(String name) {
        super(name);
        setDamage(8);
        setDefence(2);
        setHeal(20);
    }

    /**
     * Gets the heals points of the Healer character.
     * @return the heals points of the Healer character
     */
    public int getHeal() {
        return heal;
    }

    /**
     * Sets the heals points of the Healer character.
     * @param heal the heals points of the Healer character
     */
    public void setHeal(int heal) {
        this.heal = heal;
    }


    /**
     * Increase the stats of the Healer
     */
    @Override
    public void increaseStats() {
        setDamage((int) (getDamage() * 1.1));
        setDefence((int) (getDefence() * 1.1));
        setHeal((int) (getHeal() * 1.2));
    }

    /**
     * Special attack of the Healer character.
     * He heals himself.
     * @param pEnemy the enemy
     * @return 0 because it does no damage
     */
    @Override
    public int specialAttack(Character pEnemy) {
        setLife(getLife() + getHeal());
        return 0;
    }

    /**
     * Describes the ability of the Healer to fly.
     * @return the description
     */
    @Override
    public String fly() {
        return "He flies over the area to heal himself !";
    }

    /**
     * Describes the ability of the Healer to perform a ranged attack.
     * @return the description
     */
    @Override
    public String distance() {
        return "Ranged attack !";
    }


    /**
     * Describes the Healer.
     * @return the description
     */
    @Override
    public String toString() {
        return  "Healer" + '\n' +
                super.toString() + '\n' +
                "Skills : " + fly() + " | " + distance() + '\n';
    }
}
