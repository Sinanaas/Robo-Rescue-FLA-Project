package factory;

import model.Armor;

public class ArmorFactory {
    public Armor createArmor(String name, int defense, int progress) {
        return new Armor(name, defense, progress);
    }
}
