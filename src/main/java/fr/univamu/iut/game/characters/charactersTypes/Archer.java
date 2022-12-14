package fr.univamu.iut.game.characters.charactersTypes;

import fr.univamu.iut.game.characters.Character;
import fr.univamu.iut.game.characters.attributs.Distance;

/**
 * It's a type of character that does a lot of damage but is weak.
 */
public class Archer extends Character implements Distance {
    public Archer(String name) {
        super(name);
        setDamage(15);
        setDefence(5);
    }

    /**
     * Increase the stats of the character (Damage and defence)
     */
    @Override
    public void increaseStats() {
        setDamage((int) (getDamage() * 1.3));
        setDefence((int) (getDefence() * 1.1));
    }

    @Override
    public String distance() {
        return "He shoots arrows from a distance !";
    }

    @Override
    public int specialAttack(Character pEnemy) {
        pEnemy.setLife((getLife() + getDefenceWithEquipments()) - (2*getDamageWithEquipments()));
        return (2 * getDamage());
    }

    @Override
    public String toString() {
        return  "Archer" + '\n' +
                super.toString() + '\n' +
                "Skills : " + distance() + '\n';
    }
}
