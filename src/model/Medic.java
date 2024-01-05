package model;

public class Medic extends Robot {
    private String type = "Medic";

    public String getType() {
        return type;
    }

    public Medic(Weapon weapon, Armor armor, String name) {
        super(weapon, armor, name);
    }
}
