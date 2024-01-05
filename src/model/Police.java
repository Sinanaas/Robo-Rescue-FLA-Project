package model;

public class Police extends Robot {
    private String type = "Police";

    public Police(Weapon weapon, Armor armor, String name, int health, int points) {
        super(weapon, armor, name, health, points);
    }
    public String getType() {
        return type;
    }
}
