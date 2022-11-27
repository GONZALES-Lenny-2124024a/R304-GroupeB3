package fr.univamu.iut;

import fr.univamu.iut.attributs.Distance;

public class Archer extends Character implements Distance {
    public Archer(String name) {
        super(name);
        setDamage(15);
        setDefence(5);
    }
    @Override
    public void increaseStats() {
        setDamage((int) (getDamage() * 1.3));
        setDefence((int) (getDefence() * 1.1));
    }

    @Override
    public String distance() {
        return "Il lance des flèches à distance !";
    }

    public void specialAttack(Character pEnemy) {
        int attackDamage = 2* getDamage();  //The archer attack with 2 arrows
        pEnemy.setLife(pEnemy.getLife() - attackDamage);
    }

    @Override
    public String toString() {
        return  "Archer" + '\n' +
                super.toString() + '\n' +
                "Compétences : " + distance() + '\n';
    }
}
