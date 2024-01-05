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
        INSTANCE.getMissions().add(missionFactory.createMission("Mission 1", "An amazing journey into the unknown", 1, 1, 0, 100));
        INSTANCE.getMissions().add(missionFactory.createMission("Mission 2", "The Search For Everything", 2, 2, 1, 200));
        INSTANCE.getMissions().add(missionFactory.createMission("Mission 3", "Rescuing into the night", 3, 3, 2, 250));

        ArmorFactory armorFactory = new ArmorFactory();
        INSTANCE.getArmors().add(armorFactory.createArmor("Armor 1", 20, 2));
        INSTANCE.getArmors().add(armorFactory.createArmor("Armor 2", 25, 4));
        INSTANCE.getArmors().add(armorFactory.createArmor("Armor 3", 10, 6));

        WeaponFactory weaponFactory = new WeaponFactory();
        INSTANCE.getWeapons().add(weaponFactory.createWeapon("Weapon 1", 20, 2));
        INSTANCE.getWeapons().add(weaponFactory.createWeapon("Weapon 2", 25, 4));
        INSTANCE.getWeapons().add(weaponFactory.createWeapon("Weapon 3", 10, 6));

        FirefighterFactory firefighterFactory = new FirefighterFactory();
        INSTANCE.getRobots().add(firefighterFactory.createRobot(INSTANCE.getWeapons().get(0), INSTANCE.getArmors().get(0), "Firefighter 1", 100));
        PoliceFactory policeFactory = new PoliceFactory();
        INSTANCE.getRobots().add(policeFactory.createRobot(INSTANCE.getWeapons().get(1), INSTANCE.getArmors().get(1), "Police 1", 100));
        MedicFactory medicFactory = new MedicFactory();
        INSTANCE.getRobots().add(medicFactory.createRobot(INSTANCE.getWeapons().get(2), INSTANCE.getArmors().get(2), "Medic 1", 100));
    }
    
    public static Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
            populateData();
        }
        return INSTANCE;
    }
}