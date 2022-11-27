package fr.univamu.iut.game;

import fr.univamu.iut.game.attributs.Distance;
import fr.univamu.iut.game.attributs.Fly;

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
    void specialAttack(Character pEnemy) {
        setLife(getLife() + getHeal());
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
