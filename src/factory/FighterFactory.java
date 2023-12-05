package factory;

import model.Armor;
import model.Fighter;
import model.Robot;
import model.Weapon;

public class FighterFactory implements RobotFactory {
    @Override
    public Robot createRobot(Weapon weapon, Armor armor, String name, int health, String type) {
        return new Fighter(weapon, armor, name, health, type);
    }
}
