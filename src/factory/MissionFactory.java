package factory;

import model.Mission;

import java.util.Random;

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
        final int status = 0;
        int reward;
        int time;
        Random random = new Random();
        if (difficulty == 1) {
            reward = random.nextInt(1, 3);
            time = random.nextInt(60, 180);
        } else if (difficulty == 2) {
            reward = random.nextInt(4, 7);
            time = random.nextInt(180, 240);
        } else {
            reward = random.nextInt(8, 10);
            time = random.nextInt(240, 300);
        }
        return this.createMission(name, description, difficulty, reward, status, time);
    }
}
