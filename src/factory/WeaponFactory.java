package factory;

import model.Weapon;

public class WeaponFactory {
    public Weapon createWeapon(String name, int damage, int progress) {
        return new Weapon(name, damage, progress);
    }
}
