package factory;

import model.Armor;
import model.Firefighter;
import model.Robot;
import model.Weapon;

public class FirefighterFactory implements RobotFactory {
    @Override
    public Robot createRobot(Weapon weapon, Armor armor, String name, int health) {
        return new Firefighter(weapon, armor, name, health, 0);
    }
}
