package model;

public class Mission {
    String name;
    String description;
    int difficulty;
    int reward;
    boolean status;
    int progress;

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public Mission(String name, String description, int difficulty, int reward, boolean status, int progress) {
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.reward = reward;
        this.status = status;
        this.progress = progress;
    }
}
