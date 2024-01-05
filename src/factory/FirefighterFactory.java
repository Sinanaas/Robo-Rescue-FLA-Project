package factory;

import model.Armor;
import model.Firefighter;
import model.Robot;
import model.Weapon;

public class FirefighterFactory implements RobotFactory {
    @Override
    public Robot createRobot(Weapon weapon, Armor armor, String name) {
        return new Firefighter(weapon, armor, name);
    }
    public Robot createRobot(String name){
        ArmorFactory armorFactory = new ArmorFactory();
        WeaponFactory weaponFactory = new WeaponFactory();
        return new Firefighter(weaponFactory.createWeapon("Starter Water Gun", 15, 0), armorFactory.createArmor("Firefighter Suit", 10, 0), name);
    }
}
