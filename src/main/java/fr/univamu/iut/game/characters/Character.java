package fr.univamu.iut.game.characters;

/**
 * Abstract method that has all the basic methods of a character
 */
public abstract class Character {
    private String name;
    private int level;
    private int xp;
    private int xpNecessary;
    private int damage;
    private int damageInFight;
    private int defence;
    private int life;

    public Character(String name) {
        this.name = name;
        level = 1;
        xp = 0;
        xpNecessary = 10;
        life = 100;
        damageInFight = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
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
     * Increase attributes (damage, defence) of the character
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
     * @param xp int
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

    public int getDamageInFight() {
        return damageInFight;
    }

    public void setDamageInFight(int damageInFight) {
        this.damageInFight = damageInFight;
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
     * @param pEnemy enemy character
     * @throws InterruptedException it's for Thread.sleep(250) in the mage special attack's method
     */
    public void attack(Character pEnemy, double randomValue) throws InterruptedException {
        int damageAttack = getDamage();

        if (randomValue <= 0.05) {   // 5% chance of making a critical attack
            damageAttack *= 3;
            pEnemy.setLife((pEnemy.getLife() + pEnemy.getDefence()) - damageAttack);
            System.out.println(getName() + " -> " + pEnemy.getName() + " (" + getDamage() * 3 + ") with a Critical Attack");
        } else if (randomValue > 0.15) { // 85% chance of making a critical attack
            pEnemy.setLife((pEnemy.getLife() + pEnemy.getDefence()) - getDamage());
            System.out.println(getName() + " -> " + pEnemy.getName() + " (" + damageAttack + ')');
        } else { // 10% chance of making a special attack
            damageAttack = specialAttack(pEnemy);
            System.out.println(getName() + " performed his special attack ! (" + damageAttack + ')');
        }
        setDamageInFight(getDamageInFight() + damage);
    }

    abstract int specialAttack(Character pEnemy) throws InterruptedException;

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
