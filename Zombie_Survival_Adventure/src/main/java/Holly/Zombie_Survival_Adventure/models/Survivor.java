package Holly.Zombie_Survival_Adventure.models;

import models.loot.Food;
import models.loot.Gun;
import models.loot.Melee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "survivors")
public class Survivor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ammo")
    private int ammoInventory;

    @Column(name = "food")
    private ArrayList<Food> foodInventory;

    @Column(name = "guns")
    private ArrayList<Gun> gunInventory;

    @Column(name = "knives")
    private ArrayList<Melee> meleeInventory;

    @Column(name = "survivor_level")
    @Enumerated(value = EnumType.STRING)
    public SurvivorLevel survivorLevel;

    @Column(name = "survivor_health")
    public int survivorHealth;

    public int zombiesEncountered;

    public int HPRestoresUsed;

    public Survivor(String name, int ammoInventory, SurvivorLevel survivorLevel, int survivorHealth, int zombiesEncountered, int HPRestoresUsed) {
        this.name = name;
        this.survivorLevel = survivorLevel;
        this.ammoInventory = ammoInventory;
        this.foodInventory = new ArrayList<>();
        this.gunInventory = new ArrayList<>();
        this.meleeInventory = new ArrayList<>();
        this.survivorHealth = survivorHealth;
        this.zombiesEncountered = zombiesEncountered;
        this.HPRestoresUsed = HPRestoresUsed;
    }

    public Survivor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SurvivorLevel getSurvivorLevel() {
        return survivorLevel;
    }

    public void setSurvivorLevel(SurvivorLevel survivorLevel) {
        this.survivorLevel = survivorLevel;
    }

    public int getAmmoInventory() {
        return ammoInventory;
    }

    public void setAmmoInventory(int ammoInventory) {
        this.ammoInventory = ammoInventory;
    }

    public List<Food> getFoodInventory() {
        return foodInventory;
    }

    public void setFoodInventory(ArrayList<Food> foodInventory) {
        this.foodInventory = foodInventory;
    }

    public List<Gun> getGunInventory() {
        return gunInventory;
    }

    public void setGunInventory(ArrayList<Gun> gunInventory) {
        this.gunInventory = gunInventory;
    }

    public List<Melee> getMeleeInventory() {
        return meleeInventory;
    }

    public void setMeleeInventory(ArrayList<Melee> meleeInventory) {
        this.meleeInventory = meleeInventory;
    }

    public int getSurvivorHealth() {
        return survivorHealth;
    }

    public void setSurvivorHealth(int survivorHealth) {
        this.survivorHealth = survivorHealth;
    }

    public int getZombiesEncountered() {
        return zombiesEncountered;
    }

    public void setZombiesEncountered(int zombiesEncountered) {
        this.zombiesEncountered = zombiesEncountered;
    }

    public int getHPRestoresUsed() {
        return HPRestoresUsed;
    }

    public void setHPRestoresUsed(int HPRestoresUsed) {
        this.HPRestoresUsed = HPRestoresUsed;
    }

    public void setSurvivorHealthMax() {
        this.survivorHealth = survivorLevel.getHP();
    }

    public void addFoodToInventory(Food food) {
        this.foodInventory.add(food);
    }

    public void addMeleeToInventory(Melee melee) {
        this.meleeInventory.add(melee);
    }

    public void addGunToInventory(Gun gun) {
        this.gunInventory.add(gun);
    }

}
