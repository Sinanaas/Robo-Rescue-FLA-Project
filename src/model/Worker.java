package model;

public class Worker extends Robot {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Worker(Weapon weapon, Armor armor, String name, int health, String type) {
        super(weapon, armor, name, health);
        this.type = type;
    }
}
