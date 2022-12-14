package fr.univamu.iut.game.characters;

import fr.univamu.iut.game.equipments.Equipment;
import fr.univamu.iut.observerPattern.Observer;

import java.util.List;

/**
 * Abstract method that has all the basic methods of a character
 * @author LennyGonzales
 */
public abstract class Character implements Observer<List<Equipment>> {
    private String name;
    private int level;
    private int xp;
    private int xpNecessary;
    private int damage;
    private int damageEquipments;
    private int damageInFight;
    private int defence;
    private int defenceEquipments;
    private int life;

    public Character(String name) {
        this.name = name;
        level = 1;
        xp = 0;
        xpNecessary = 10;
        life = 100;
        damageInFight = 0;
        damageEquipments = 0;
        defenceEquipments = 0;
    }

    /**
     * Get the character's name
     * @return name of the character
     */
    public String getName() {
        return name;
    }

    /**
     * Set the character's name
     * @param name character's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the character's level
     * @param level character's level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Get the character's level
     * @return character's level
     */
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
     * Increase attributes of the character
     */
    public void increaseStats() {
        setDamage((int) (getDamage() * 1.1));
        setDefence((int) (getDefence() * 1.1));
    }

    /**
     * Get the character's experience
     * @return character's experience
     */
    public int getXp() {
        return xp;
    }

    /**
     * Set the xp and check if the character can level up
     * @param xp new character's experience
     */
    public void setXp(int xp) {
        this.xp = xp;

        if (getXp() >= getXpNecessary()) {  // Check if the player can level up
            this.xp = 0;
            incrementLevel();   // Increment the level by 1
            setXpNecessary((int) (getXpNecessary() * 1.4)); // Increase the necessary experience to level up
        }
    }

    /**
     * Get the experience (xp) necessary to level up
     * @return the experience necessary to level up
     */
    public int getXpNecessary() {
        return xpNecessary;
    }

    /**
     * Set the experience necessary to level up
     * @param xpNecessary the experience necessary to level up
     */
    public void setXpNecessary(int xpNecessary) {
        this.xpNecessary = xpNecessary;
    }

    /**
     * Get the damage of the character with his equipments
     * @return the damage
     */
    public int getDamageWithEquipments() {
        return (damage + damageEquipments);
    }

    /**
     * Get the base damage of the character
     * @return the base damage
     */
    public int getDamage() { return damage; }

    /**
     * Set the base damage of the character
     * @param damage the new base damage of the character
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Get the total damage done during a fight
     * @return the total damage
     */
    public int getDamageInFight() {
        return damageInFight;
    }

    /**
     * Set the total damage done during a fight
     * @param damageInFight the new total damage
     */
    public void setDamageInFight(int damageInFight) {
        this.damageInFight = damageInFight;
    }

    /**
     * Get the base defence of the character
     * @return the base defence
     */
    public int getDefence() {
        return defence;
    }

    /**
     * Set the base defence of the character
     * @param defence the new base defence of the character
     */
    public void setDefence(int defence) {
        this.defence = defence;
    }

    /**
     * Get the defence of the character with his equipments
     * @return the defence points
     */
    public int getDefenceWithEquipments() { return (defence + defenceEquipments); }

    /**
     * Get the life of the character
     * @return his life
     */
    public int getLife() {
        return life;
    }

    /**
     * Set the life of the character
     * @param life his new life
     */
    public void setLife(int life) {
        this.life = life;
    }

    /**
     * Get the damage from equipments
     * @return his equipments damage
     */
    public int getDamageEquipments() {
        return damageEquipments;
    }

    /**
     * Set the damage from equipments
     * @param damageEquipments his new equipments damage
     */
    public void setDamageEquipments(int damageEquipments) {
        this.damageEquipments = damageEquipments;
    }

    /**
     * Get the defence from equipments
     * @return his equipments defence
     */
    public int getDefenceEquipments() {
        return defenceEquipments;
    }

    /**
     * Set the defence from equipments
     * @param defenceEquipments his new equipments defence
     */
    public void setDefenceEquipments(int defenceEquipments) {
        this.defenceEquipments = defenceEquipments;
    }

    /**
     * This character attack another character
     * @param pEnemy enemy character
     * @throws InterruptedException it's for Thread.sleep(250) in the mage special attack's method
     */
    public void attack(Character pEnemy, double randomValue) throws InterruptedException {
        int damageAttack = getDamageWithEquipments();
        int enemyDefence = pEnemy.getLife() + pEnemy.getDefenceWithEquipments();

        if (randomValue <= 0.05) {   // 5% chance of making a critical attack
            damageAttack *= 3;
            pEnemy.setLife(enemyDefence - damageAttack);
            System.out.println(getName() + " -> " + pEnemy.getName() + " (" + damageAttack + ") with a Critical Attack");
        } else if (randomValue > 0.15) { // 85% chance of making a critical attack
            pEnemy.setLife(enemyDefence - damageAttack);
            System.out.println(getName() + " -> " + pEnemy.getName() + " (" + damageAttack + ')');
        } else { // 10% chance of making a special attack
            damageAttack = specialAttack(pEnemy);
            System.out.println(getName() + " performed his special attack ! (" + damageAttack + ')');
        }
        setDamageInFight(getDamageInFight() + damageAttack);
    }

    /**
     * Perform a special attack on a given character
     * @param pEnemy The target character to attack
     * @return The amount of damage inflicted to the enemy character
     * @throws InterruptedException in the Mage character, if the Thread.sleep(250) didn't go well
     */
    protected abstract int specialAttack(Character pEnemy) throws InterruptedException;

    /**
     * React to an observable notification
     * @param equipments the observable
     */
    @Override
    public void update(List<Equipment> equipments) {
        damageEquipments = 0;
        defenceEquipments = 0;

        for (Equipment equipment : equipments) {
            switch (equipment.getEquipmentType()) {
                case ARMOR -> defenceEquipments += equipment.getEquipmentName().getPoints();
                case WEAPON -> damageEquipments += equipment.getEquipmentName().getPoints();
            }
        }
    }

    /**
     * Describes the character.
     * @return the description
     */
    @Override
    public String toString() {
        return  "name : " + name + '\n' +
                "level : " + level + '\n' +
                "xp : " + xp + '/' + xpNecessary + '\n' +
                "damage : " + getDamage() + '\n' +
                "equipments damage : " + getDamageEquipments() + '\n' +
                "defence : " + getDefence() + '\n' +
                "equipments defence : " + getDefenceEquipments() + '\n' +
                "life : " + getLife();
    }
}
