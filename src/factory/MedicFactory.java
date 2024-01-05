package factory;

import model.*;

public class MedicFactory implements RobotFactory {
    @Override
    public Robot createRobot(Weapon weapon, Armor armor, String name) {
        return new Medic(weapon, armor, name);
    }
    public Robot createRobot(String name){
        ArmorFactory armorFactory = new ArmorFactory();
        WeaponFactory weaponFactory = new WeaponFactory();
        return new Medic(weaponFactory.createWeapon("Starter Bandage", 15, 15), armorFactory.createArmor("Medic Suit", 10, 10), name);
    }
}
