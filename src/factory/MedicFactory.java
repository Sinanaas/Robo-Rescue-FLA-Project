package factory;

import model.*;

public class MedicFactory implements RobotFactory {
    @Override
    public Robot createRobot(Weapon weapon, Armor armor, String name, int health) {
        return new Medic(weapon, armor, name, health, 0);
    }
}
