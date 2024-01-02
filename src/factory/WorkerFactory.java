package factory;

import model.*;

public class WorkerFactory implements RobotFactory {
    @Override
    public Robot createRobot(Weapon weapon, Armor armor, String name, int health, String type) {
        return new Worker(weapon, armor, name, health, type, 0);
    }
}
