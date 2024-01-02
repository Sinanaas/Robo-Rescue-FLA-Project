package model;

public class Robot {
    private Weapon weapon;
    private Armor armor;
    private String name;
    private int health;
    private boolean status;
    private int points;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

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

    public Robot(Weapon weapon, Armor armor, String name, int health, int points) {
        this.weapon = weapon;
        this.armor = armor;
        this.name = name;
        this.health = health;
        this.points = points;
    }

    public void printAll() {
        System.out.println("Name: " + getName());
        System.out.println("Health: " + getHealth());
        System.out.println("Weapon: " + getWeapon().getName());
        System.out.println("Armor: " + getArmor().getName());
        System.out.println("Points: " + getPoints());
    }

    public int calculateMissionTime(Mission mission) {
        int baseTime = mission.getTime();
        int difficultyModifier = mission.getDifficulty();
        int attackModifier = getWeapon().getDamage();
        int defenseModifier = getArmor().getDefense();
        int healthModifier = getHealth();

        int totalTime = baseTime - (4*attackModifier + 3*defenseModifier - healthModifier/2 - 2*difficultyModifier);
//        return Math.max(totalTime, 0)
        return totalTime;
    }
}
