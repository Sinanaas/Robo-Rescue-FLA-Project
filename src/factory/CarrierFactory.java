package factory;

import model.Armor;
import model.Carrier;
import model.Robot;
import model.Weapon;

public class CarrierFactory implements RobotFactory {
    @Override
    public Robot createRobot(Weapon weapon, Armor armor, String name, int health, String type) {
        return new Carrier(weapon, armor, name, health, type);
    }
}
