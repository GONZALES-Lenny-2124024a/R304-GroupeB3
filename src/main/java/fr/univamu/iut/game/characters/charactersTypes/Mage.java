package fr.univamu.iut.game.characters.charactersTypes;

import fr.univamu.iut.game.characters.Character;
import fr.univamu.iut.game.characters.attributs.Distance;
import fr.univamu.iut.game.characters.attributs.Fly;

/**
 * Class representing a Healer character.
 * Extends Character
 * Implements Distance and Fly interfaces.
 *
 * @author LennyGonzales
 */
public class Mage extends Character implements Distance, Fly {

    /**
     * Constructor for the Mage character.
     * @param name the name of the Mage.
     */
    public Mage(String name) {
        super(name);
        setDamage(10);
        setDefence(7);
    }

    /**
     * Increase the Mage's stats.
     */
    @Override
    public void increaseStats() {
        setDamage((int) (getDamage() * 1.2));
        setDefence((int) (getDefence() * 1.2));
    }

    /**
     * Flying ability for the Mage character.
     * @return the description
     */
    @Override
    public String fly() {
        return "Fly over the area !";
    }

    /**
     * Ranged attack ability for the Mage.
     * @return the description
     */
    @Override
    public String distance() {
        return "Ranged attack !";
    }

    /**
     * Special attack for the Mage.
     * @param pEnemy The enemy that the Mage will attack.
     * @return int the special attack's damage.
     * @throws InterruptedException if the Thread.sleep(250) didn't go well
     */
    @Override
    public int specialAttack(Character pEnemy) throws InterruptedException {
        int attackDamage = (pEnemy.getLife() + pEnemy.getDefenceWithEquipments()) - getDamageWithEquipments();
        pEnemy.setLife(attackDamage);

        for (int i = 0; i < 5; ++i) {   // Make a passive attack for 5 seconds
            System.out.println(getName() + " -> " + pEnemy.getName() + " (1) !");
            pEnemy.setLife(pEnemy.getLife() - 1);
            Thread.sleep(250);
        }
        return (getDamageWithEquipments() + 5);
    }

    /**
     * Describes this Mage character.
     * @return the description of the character
     */
    @Override
    public String toString() {
        return  "Mage" + '\n' +
                super.toString() + '\n' +
                "Skills : " + fly() + " | " + distance() + '\n';
    }
}
