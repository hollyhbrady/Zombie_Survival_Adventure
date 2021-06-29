package models;

public enum ZombieLevel {

    ONE(50, 70, 20, 10),
    TWO(75, 80, 25, 15),
    THREE(100, 90, 30, 20);

    private int HP;
    private int accuracy;
    private int maxStrength;
    private int speed;

    ZombieLevel(int HP, int accuracy, int maxStrength, int speed) {
        this.HP = HP;
        this.accuracy = accuracy;
        this.maxStrength = maxStrength;
        this.speed = speed;
    }

    public int getHP() {
        return HP;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getStrength() {
        return maxStrength;
    }

    public int getSpeed() {
        return speed;
    }
}
