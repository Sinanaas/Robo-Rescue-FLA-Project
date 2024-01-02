package model;

public class Carrier extends Robot {
    private String type = "Carrier";

    public String getType() {
        return type;
    }

    public Carrier(Weapon weapon, Armor armor, String name, int health, String type, int points) {
        super(weapon, armor, name, health, points);
        this.type = type;
    }
}
