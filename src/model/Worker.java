package model;

public class Worker extends Robot {
    private String type = "Worker";

    public String getType() {
        return type;
    }

    public Worker(Weapon weapon, Armor armor, String name, int health, String type, int points) {
        super(weapon, armor, name, health, points);
        this.type = type;
    }
}
