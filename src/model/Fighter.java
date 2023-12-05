package model;

public class Fighter extends Robot {
    private String type;

    public Fighter(Weapon weapon, Armor armor, String name, int health, String type) {
        super(weapon, armor, name, health);
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
