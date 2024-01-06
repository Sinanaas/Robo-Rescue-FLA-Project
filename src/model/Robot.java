package model;

public class Robot {
    private Weapon weapon;
    private Armor armor;
    private String name;
    private String type;
    private int health;
    private boolean status;
    private int points;

    public boolean isStatus() {
        return status;
    }

    public String getStatus() {
        if (status) {
            return "Available";
        } else {
            return "In mission";
        }
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

    public String getType(){
        return type;
    }

    public Robot(Weapon weapon, Armor armor, String name, String type) {
        this.weapon = weapon;
        this.armor = armor;
        this.name = name;
        this.health = 100;
        this.points = 0;
        this.status = true;
        this.type = type;
    }

    public void printAll() {
        System.out.println("Name: " + getName());
        System.out.println("Health: " + getHealth());
        System.out.println("Weapon: " + getWeapon().getName());
        System.out.println("Armor: " + getArmor().getName());
        System.out.println("Points: " + getPoints());
        System.out.println("Status: " + getStatus());
    }

    public int calculateMissionTime(Mission mission) {
        int baseTime = mission.getTime();
        int attackModifier = getWeapon().getDamage();
        int defenseModifier = getArmor().getDefense();

        return baseTime + (attackModifier / defenseModifier);
    }
}
