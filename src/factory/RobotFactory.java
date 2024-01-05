package factory;

import model.*;

public interface RobotFactory {
    Robot createRobot(Weapon weapon, Armor armor, String name);
}
