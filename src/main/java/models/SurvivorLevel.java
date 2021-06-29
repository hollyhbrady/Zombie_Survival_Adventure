package models;

public enum SurvivorLevel {

    // BEST GUN ACCURACY
    SOLDIERONE(50, 0.8, 0.7,20, 10),
    SOLDIERTWO(75, 0.9, 0.8,25, 15),
    SOLDIERTHREE(100, 0.95, 0.9,30, 20),
    // FASTEST
    WANDERERONE(50, 0.7, 0.7, 20, 15),
    WANDERERTWO(75, 0.8, 0.8,25, 25),
    WANDERERTHREE(100, 0.9, 0.9,30, 30),
    // BEST MELEE ACCURACY
    OUTCASTONE(50, 0.7, 0.8,20, 10),
    OUTCASTTWO(75, 0.8, 0.9,25, 15),
    OUTCASTTHREE(100, 0.9, 0.95,30, 20);

    private int HP;
    private double gunAccuracy;
    private double meleeAccuracy;
    private int maxStrength;
    private int speed;

    SurvivorLevel(int HP, double gunAccuracy, double meleeAccuracy, int maxStrength, int speed) {
        this.HP = HP;
        this.gunAccuracy = gunAccuracy;
        this.meleeAccuracy = meleeAccuracy;
        this.maxStrength = maxStrength;
        this.speed = speed;
    }

    public int getHP() {
        return HP;
    }

    public double getGunAccuracy() {
        return gunAccuracy;
    }

    public double getMeleeAccuracy() {
        return meleeAccuracy;
    }

    public int getMaxStrength() {
        return maxStrength;
    }

    public int getSpeed() {
        return speed;
    }
}