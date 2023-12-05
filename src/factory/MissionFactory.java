package factory;

import model.Mission;

public class MissionFactory {
    public Mission createMission(String name, String description, int difficulty, int reward, boolean status, int progress) {
        return new Mission(name, description, difficulty, reward, status, progress);
    }
}
