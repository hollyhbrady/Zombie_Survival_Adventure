package Holly.Zombie_Survival_Adventure.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "survivor_levels")
public enum SurvivorLevel {

    // BEST GUN ACCURACY
    SOLDIER(50, 80, 70,20, 10),
    SOLDIERTWO(75, 90, 80,25, 15),
    SOLDIERTHREE(100, 95, 90,30, 20),
    // FASTEST
    WANDERER(50, 70, 70, 20, 15),
    WANDERERTWO(75, 80, 80,25, 25),
    WANDERERTHREE(100, 90, 90,30, 30),
    // BEST MELEE ACCURACY
    OUTCAST(50, 70, 80,20, 10),
    OUTCASTTWO(75, 80, 90,25, 15),
    OUTCASTTHREE(100, 90, 95,30, 20);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "maxHP")
    public int maxHP;

    @Column(name = "gun_accuracy")
    public double gunAccuracy;

    @Column(name = "melee_accuracy")
    public double meleeAccuracy;

    @Column(name = "strength")
    public int strength;

    @Column(name = "speed")
    public int speed;

    SurvivorLevel(int maxHP, double gunAccuracy, double meleeAccuracy, int strength, int speed) {
        this.maxHP = maxHP;
        this.gunAccuracy = gunAccuracy;
        this.meleeAccuracy = meleeAccuracy;
        this.strength = strength;
        this.speed = speed;
    }

    SurvivorLevel() {
    }

    public String getSurvivorLevel() {
        return this.name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMaxHP() {
        return maxHP;
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