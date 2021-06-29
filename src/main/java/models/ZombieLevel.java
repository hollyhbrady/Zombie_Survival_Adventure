package models;

public enum ZombieLevel {

    ONE(30, 70, 20, 10),
    TWO(45, 80, 25, 15),
    THREE(60, 90, 30, 20);

    private final int HP;
    private final int accuracy;
    private final int maxStrength;
    private final int speed;

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
