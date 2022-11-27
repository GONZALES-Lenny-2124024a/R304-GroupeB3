package fr.univamu.iut;

import fr.univamu.iut.attributs.Distance;
import fr.univamu.iut.attributs.Fly;

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
        return "Vole au-dessus de la zone !";
    }

    @Override
    public String distance() {
        return "Attaque à distance !";
    }

    @Override
    public void specialAttack(Character pEnemy) throws InterruptedException {
        pEnemy.setLife(getLife() - getDamage());

        for (int i = 0; i < 5; ++i) {   // Make a passive attack for 5 seconds
            System.out.println(getName() + " a infligé 1 dégâts à " + pEnemy.getName() + " !");
            pEnemy.setLife(pEnemy.getLife() - 1);
            Thread.sleep(1);
        }
    }

    @Override
    public String toString() {
        return  "Mage" + '\n' +
                super.toString() + '\n' +
                "Compétences : " + fly() + " | " + distance() + '\n';
    }
}
