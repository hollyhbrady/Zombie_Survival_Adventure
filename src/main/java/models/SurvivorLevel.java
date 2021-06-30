package models;

public enum SurvivorLevel {

    // BEST GUN ACCURACY
    SOLDIERONE(50, 80, 70,20, 10),
    SOLDIERTWO(75, 90, 80,25, 15),
    SOLDIERTHREE(100, 95, 90,30, 20),
    // FASTEST
    WANDERERONE(50, 70, 70, 20, 15),
    WANDERERTWO(75, 80, 80,25, 25),
    WANDERERTHREE(100, 90, 90,30, 30),
    // BEST MELEE ACCURACY
    OUTCASTONE(50, 70, 80,20, 10),
    OUTCASTTWO(75, 80, 90,25, 15),
    OUTCASTTHREE(100, 90, 95,30, 20);

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