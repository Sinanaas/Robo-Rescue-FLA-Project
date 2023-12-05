package model;

public class Carrier extends Robot {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Carrier(Weapon weapon, Armor armor, String name, int health, String type) {
        super(weapon, armor, name, health);
        this.type = type;
    }
}
