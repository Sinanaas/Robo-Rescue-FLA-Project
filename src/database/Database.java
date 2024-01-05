package database;

import factory.*;
import model.*;

import java.util.ArrayList;

public class Database {
    public static Database INSTANCE;
    private ArrayList<Robot> robots;
    private ArrayList<Mission> missions;
    private ArrayList<Weapon> weapons;
    private ArrayList<Armor> armors;

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
    private Database() {
        this.robots = new ArrayList<>();
        this.missions = new ArrayList<>();
        this.weapons = new ArrayList<>();
        this.armors = new ArrayList<>();
    }
    public static void populateData() {
        MissionFactory missionFactory = new MissionFactory();
        INSTANCE.getMissions().add(missionFactory.createMission());
        INSTANCE.getMissions().add(missionFactory.createMission());
        INSTANCE.getMissions().add(missionFactory.createMission());

        ArmorFactory armorFactory = new ArmorFactory();
        INSTANCE.getArmors().add(armorFactory.createArmor("Medium Armor", 20, 2));
        INSTANCE.getArmors().add(armorFactory.createArmor("Heavy Armor", 25, 4));
        INSTANCE.getArmors().add(armorFactory.createArmor("Light Armor", 10, 6));

        WeaponFactory weaponFactory = new WeaponFactory();
        INSTANCE.getWeapons().add(weaponFactory.createWeapon("Water Gun", 20, 2));
        INSTANCE.getWeapons().add(weaponFactory.createWeapon("Pistol", 25, 4));
        INSTANCE.getWeapons().add(weaponFactory.createWeapon("Medkit", 10, 6));

        FirefighterFactory firefighterFactory = new FirefighterFactory();
        INSTANCE.getRobots().add(firefighterFactory.createRobot(INSTANCE.getWeapons().get(0), INSTANCE.getArmors().get(0), "Firefighter 1"));
        PoliceFactory policeFactory = new PoliceFactory();
        INSTANCE.getRobots().add(policeFactory.createRobot(INSTANCE.getWeapons().get(1), INSTANCE.getArmors().get(1), "Police 1"));
        MedicFactory medicFactory = new MedicFactory();
        INSTANCE.getRobots().add(medicFactory.createRobot(INSTANCE.getWeapons().get(2), INSTANCE.getArmors().get(2), "Medic 1"));
    }
    
    public static Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
            populateData();
        }
        return INSTANCE;
    }
}