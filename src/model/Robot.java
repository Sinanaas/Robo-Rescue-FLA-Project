package model;

public abstract class Robot {
    private Weapon weapon;
    private Armor armor;
    private String name;
    private int health;
    private boolean status;

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Robot(Weapon weapon, Armor armor, String name, int health) {
        this.weapon = weapon;
        this.armor = armor;
        this.name = name;
        this.health = health;
    }
}
