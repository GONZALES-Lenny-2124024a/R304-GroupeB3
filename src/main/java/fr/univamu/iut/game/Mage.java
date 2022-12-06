package fr.univamu.iut.game;

import fr.univamu.iut.game.attributs.Distance;
import fr.univamu.iut.game.attributs.Fly;

public class Mage extends Character implements Distance, Fly {

    public Mage(String name) {
        super(name);
        setDamage(10);
        setDefence(7);
    }

    @Override
    public void increaseStats() {
        setDamage((int) (getDamage() * 1.2));
        setDefence((int) (getDefence() * 1.2));
    }

    @Override
    public String fly() {
        return "Fly over the area !";
    }

    @Override
    public String distance() {
        return "Ranged attack !";
    }

    @Override
    public int specialAttack(Character pEnemy) throws InterruptedException {
        int attackDamage = (pEnemy.getLife() + pEnemy.getDefence()) - getDamage();
        pEnemy.setLife(attackDamage);

        for (int i = 0; i < 5; ++i) {   // Make a passive attack for 5 seconds
            System.out.println(getName() + " -> " + pEnemy.getName() + " (1) !");
            pEnemy.setLife(pEnemy.getLife() - 1);
            Thread.sleep(1000);
        }
        return (getDamage() + 5);
    }

    @Override
    public String toString() {
        return  "Mage" + '\n' +
                super.toString() + '\n' +
                "Skills : " + fly() + " | " + distance() + '\n';
    }
}
