package model;

public class Mission {
    String name;
    String description;
    int difficulty;
    int reward;
    int status;
    int time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Mission(String name, String description, int difficulty, int reward, int status, int time) {
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.reward = reward;
        this.status = status;
        this.time = time;
    }
}
