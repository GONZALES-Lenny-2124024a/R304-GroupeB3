package fr.univamu.iut;

import fr.univamu.iut.attributs.Distance;
import fr.univamu.iut.attributs.Fly;

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
        return "Vole au-dessus de la zone pour se soigner !";
    }

    @Override
    public String distance() {
        return "Attaque à distance !";
    }

    @Override
    public String toString() {
        return  "Healer" + '\n' +
                super.toString() + '\n' +
                "Compétences : " + fly() + " | " + distance() + '\n';
    }
}
