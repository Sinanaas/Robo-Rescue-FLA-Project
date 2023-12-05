package model;

public class Armor {
    String name;
    int defense;
    int progress;


    public Armor(String name, int defense, int progress) {
        this.name = name;
        this.defense = defense;
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
