package model;

public class Police extends Robot {
    private String type = "Police";

    public Police(Weapon weapon, Armor armor, String name) {
        super(weapon, armor, name);
    }
    public String getType() {
        return type;
    }
}
