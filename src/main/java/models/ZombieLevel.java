package models;

public enum ZombieLevel {

    ONE(30, 80, 20, 15),
    TWO(45, 90, 25, 20),
    THREE(60, 95, 30, 25);

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
