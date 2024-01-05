package factory;

import model.*;

public class PoliceFactory implements RobotFactory {
    @Override
    public Robot createRobot(Weapon weapon, Armor armor, String name) {
        return new Police(weapon, armor, name);
    }
    public Robot createRobot(String name){
        ArmorFactory armorFactory = new ArmorFactory();
        WeaponFactory weaponFactory = new WeaponFactory();
        return new Police(weaponFactory.createWeapon("Taser", 15, 0), armorFactory.createArmor("Police Suit", 10, 0), name);
    }
}
