package fr.univamu.iut.game.characters.charactersTypes;

import fr.univamu.iut.game.characters.Character;
import fr.univamu.iut.game.characters.attributs.Distance;
import fr.univamu.iut.game.characters.attributs.Fly;

/**
 * It's a type of character that can heal itself.
 */
public class Healer extends Character implements Distance, Fly {
    private int heal;

    public Healer(String name) {
        super(name);
        setDamage(8);
        setDefence(2);
        setHeal(20);
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }


    @Override
    public void increaseStats() {
        setDamage((int) (getDamage() * 1.1));
        setDefence((int) (getDefence() * 1.1));
        setHeal((int) (getHeal() * 1.2));
    }

    @Override
    public int specialAttack(Character pEnemy) {
        setLife(getLife() + getHeal());
        return 0;
    }   // He heals himself

    @Override
    public String fly() {
        return "He flies over the area to heal himself !";
    }

    @Override
    public String distance() {
        return "Ranged attack !";
    }

    @Override
    public String toString() {
        return  "Healer" + '\n' +
                super.toString() + '\n' +
                "Skills : " + fly() + " | " + distance() + '\n';
    }
}
