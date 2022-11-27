package fr.univamu.iut;

abstract class Character {
    private String name;
    private int level;
    private int xp;
    private int xpNecessary;
    private int damage;
    private int defence;
    private int life;

    public Character(String name) {
        this.name = name;
        level = 1;
        xp = 0;
        xpNecessary = 10;
        life = 100;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    /**
     * increment by 1 the character's level
     */
    public void incrementLevel() {
        ++level;
        increaseStats();
    }

    /**
     * Increase atrtibuts (damage, defence) of the character
     */
    public void increaseStats() {
        setDamage((int) (getDamage() * 1.2));
        setDefence((int) (getDefence() * 1.2));
    }

    public int getXp() {
        return xp;
    }

    /**
     * Set the xp and check if the character can level up
     * @param xp
     */
    public void setXp(int xp) {
        this.xp = xp;

        if (getXp() >= getXpNecessary()) {
            this.xp = 0;
            incrementLevel();
            setXpNecessary((int) (getXpNecessary() * 1.4));
        }
    }

    public int getXpNecessary() {
        return xpNecessary;
    }

    public void setXpNecessary(int xpNecessary) {
        this.xpNecessary = xpNecessary;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    /**
     * This character attack another character
     * @param pEnemy
     * @throws InterruptedException
     */
    public void attack(Character pEnemy) throws InterruptedException {
        int attackDamage = getDamage();
        double rand = Math.random();
        if(rand <= 0.05) {  // 5% chance of making a critical attack
            pEnemy.setLife((pEnemy.getLife() + pEnemy.getDefence()) - (3 * attackDamage));
            System.out.println(getName() + " a infligé " + ((3 * attackDamage) - pEnemy.getDefence()) + " dégats à " + pEnemy.getName() + " en effectuant un coup critique !");
        } else if (rand > 0.05 && rand <= 0.15) { // 10% chance of making a special attack
            specialAttack(pEnemy);
            System.out.println(getName() + " a effectué son attaque spéciale !");
        } else {    // Default attack
            pEnemy.setLife((pEnemy.getLife() + pEnemy.getDefence()) - attackDamage);
            System.out.println(getName() + " a infligé " + (attackDamage - pEnemy.getDefence()) + " dégats à " + pEnemy.getName() + " !");
        }
    }

    abstract void specialAttack(Character pEnemy) throws InterruptedException;

    @Override
    public String toString() {
        return  "name : " + name + '\n' +
                "level : " + level + '\n' +
                "xp : " + xp + '/' + xpNecessary + '\n' +
                "damage : " + getDamage() + '\n' +
                "defence : " + getDefence() + '\n' +
                "life : " + getLife();
    }
}
