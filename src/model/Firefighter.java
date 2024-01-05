package model;

public class Firefighter extends Robot {
    private String type = "Firefighter";

    public String getType() {
        return type;
    }

    public Firefighter(Weapon weapon, Armor armor, String name, int health, int points) {
        super(weapon, armor, name, health, points);
    }
}
