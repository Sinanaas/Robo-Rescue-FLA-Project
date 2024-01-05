package factory;

import model.Mission;

public class MissionFactory {

    public Mission createMission(String name, String description, int difficulty, int reward, int status, int time) {
        return new Mission(name, description, difficulty, reward, status, time);
    }
    public Mission createMission(){
        final String[] missionDescription = {
                "An amazing journey into the unknown",
                "A journey into the unknown",
                "The Search For Everything",
                "Rescuing into the night",
                "A simple mission to test your skill"
        };

        final String name = "Mission #" + (int)(Math.random() * 100);
        final String description = missionDescription[(int)(Math.random() * missionDescription.length)];
        final int difficulty = (int)(Math.random() * 3) + 1;
        final int reward = (int)(Math.random() * 10) + 1;
        final int status = 0;
        final int time = (int)(Math.random() * 240) + 60;
        return this.createMission(name, description, difficulty, reward, status, time);
    }
}
