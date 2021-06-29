package models;

public enum ZombieLevels {

    ONE(50, 0.7, 20, 10),
    TWO(75, 0.8, 25, 15),
    THREE(100, 0.9, 30, 20);

    private int HP;
    private double accuracy;
    private int maxStrength;
    private int speed;

    ZombieLevels(int HP, double accuracy, int maxStrength, int speed) {
        this.HP = HP;
        this.accuracy = accuracy;
        this.maxStrength = maxStrength;
        this.speed = speed;
    }

    public int getHP() {
        return HP;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public int getStrength() {
        return maxStrength;
    }

    public int getSpeed() {
        return speed;
    }
}
