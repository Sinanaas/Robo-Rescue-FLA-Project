package model;

public class Fighter extends Robot {
    private String type = "Fighter";

    public Fighter(Weapon weapon, Armor armor, String name, int health, String type, int points) {
        super(weapon, armor, name, health, points);
        this.type = type;
    }
    public String getType() {
        return type;
    }
}
