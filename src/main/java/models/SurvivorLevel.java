package models;

public enum SurvivorLevel {

    // BEST GUN ACCURACY
    SOLDIERONE(50, 80, 0.7,20, 10),
    SOLDIERTWO(75, 90, 0.8,25, 15),
    SOLDIERTHREE(100, 95, 0.9,30, 20),
    // FASTEST
    WANDERERONE(50, 70, 0.7, 20, 15),
    WANDERERTWO(75, 80, 0.8,25, 25),
    WANDERERTHREE(100, 90, 0.9,30, 30),
    // BEST MELEE ACCURACY
    OUTCASTONE(50, 70, 0.8,20, 10),
    OUTCASTTWO(75, 80, 0.9,25, 15),
    OUTCASTTHREE(100, 90, 0.95,30, 20);

    private int HP;
    private double gunAccuracy;
    private double meleeAccuracy;
    private int strength;
    private int speed;

    SurvivorLevel(int HP, double gunAccuracy, double meleeAccuracy, int strength, int speed) {
        this.HP = HP;
        this.gunAccuracy = gunAccuracy;
        this.meleeAccuracy = meleeAccuracy;
        this.strength = strength;
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
        return strength;
    }

    public int getSpeed() {
        return speed;
    }
}