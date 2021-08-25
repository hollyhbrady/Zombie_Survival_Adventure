package Holly.Zombie_Survival_Adventure.models;

import Holly.Zombie_Survival_Adventure.models.loot.Gun;
import Holly.Zombie_Survival_Adventure.models.loot.Food;
import Holly.Zombie_Survival_Adventure.models.loot.Melee;

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

    public int expGained;

    public int HPRestoresUsed;

    public int gunUsed;
    public int meleeUsed;
    public int dayCount;

    public Survivor(String name, int ammoInventory, SurvivorLevel survivorLevel, int survivorHealth, int zombiesEncountered, int expGained, int HPRestoresUsed, int gunUsed, int meleeUsed, int dayCount) {
        this.name = name;
        this.survivorLevel = survivorLevel;
        this.ammoInventory = ammoInventory;
        this.foodInventory = new ArrayList<>();
        this.gunInventory = new ArrayList<>();
        this.meleeInventory = new ArrayList<>();
        this.survivorHealth = survivorHealth;
        this.zombiesEncountered = zombiesEncountered;
        this.expGained = expGained;
        this.HPRestoresUsed = HPRestoresUsed;
        this.gunUsed = gunUsed;
        this.meleeUsed = meleeUsed;
        this.dayCount = dayCount;
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

    public void emptyFoodInventory() {
        this.foodInventory = new ArrayList<>();
    }

    public List<Gun> getGunInventory() {
        return gunInventory;
    }

    public void setGunInventory(ArrayList<Gun> gunInventory) {
        this.gunInventory = gunInventory;
    }

    public void emptyGunInventory() {
        this.gunInventory = new ArrayList<>();
    }

    public List<Melee> getMeleeInventory() {
        return meleeInventory;
    }

    public void setMeleeInventory(ArrayList<Melee> meleeInventory) {
        this.meleeInventory = meleeInventory;
    }

    public void emptyMeleeInventory() {
        this.meleeInventory = new ArrayList<>();
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

    public void increaseZombieCountByOne() {
        this.zombiesEncountered = this.getZombiesEncountered() + 1;
    }

    public int getExpGained() {
        return expGained;
    }

    public void setExpGained(int expGained) {
        this.expGained = expGained;
    }

    public int getHPRestoresUsed() {
        return HPRestoresUsed;
    }

    public void setHPRestoresUsed(int HPRestoresUsed) {
        this.HPRestoresUsed = HPRestoresUsed;
    }

    public int getGunUsed() {
        return gunUsed;
    }

    public void setGunUsed(int gunUsed) {
        this.gunUsed = gunUsed;
    }

    public int getMeleeUsed() {
        return meleeUsed;
    }

    public void setMeleeUsed(int meleeUsed) {
        this.meleeUsed = meleeUsed;
    }

    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public void setSurvivorHealthMax() {
        this.survivorHealth = survivorLevel.getMaxHP();
    }

    public int getSurvivorHealthMax() {
        return survivorLevel.getMaxHP();
    }

    public void addFoodToInventory(Food food) {
        this.foodInventory.add(food);
    }

    public void addMeleeToInventory(Melee melee) {
        this.meleeInventory.add(melee);
    }

    public void removeMeleeFromInventory(Melee melee) {
        this.meleeInventory.remove(melee);
    }

    public void addGunToInventory(Gun gun) {
        this.gunInventory.add(gun);
    }

    public void removeGunFromInventory(Gun gun) {
        this.gunInventory.remove(gun);
    }

    public void addToAmmoInventory(int bullets) {
        this.ammoInventory = getAmmoInventory() + bullets;
    }


}
