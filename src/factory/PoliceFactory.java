package factory;

import model.Armor;
import model.Police;
import model.Robot;
import model.Weapon;

public class PoliceFactory implements RobotFactory {
    @Override
    public Robot createRobot(Weapon weapon, Armor armor, String name, int health) {
        return new Police(weapon, armor, name, health, 0);
    }
}
