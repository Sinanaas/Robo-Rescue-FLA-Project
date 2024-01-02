package database;

import model.Armor;
import model.Mission;
import model.Robot;
import model.Weapon;

import java.util.ArrayList;

public class Database {
    public static Database INSTANCE;
    private ArrayList<Robot> robots = new ArrayList<>();
    private ArrayList<Mission> missions = new ArrayList<>();
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<Armor> armors = new ArrayList<>();

    public ArrayList<Robot> getRobots() {
        return robots;
    }

    public ArrayList<Mission> getMissions() {
        return missions;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public ArrayList<Armor> getArmors() {
        return armors;
    }
    private Database() {}
    public static Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }
}