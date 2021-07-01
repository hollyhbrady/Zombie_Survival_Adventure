package models;

import models.loot.Food;
import models.loot.Gun;
import models.loot.Melee;

import java.util.ArrayList;
import java.util.List;

public class Survivor {

    private Long id;
    private String name;
    private int ammoInventory;
    private List<Food> foodInventory;
    private List<Gun> gunInventory;
    private List<Melee> meleeInventory;
    public SurvivorLevel survivorLevel;
    public int survivorHealth;

    public Survivor(String name, int ammoInventory, SurvivorLevel survivorLevel, int survivorHealth) {
        this.name = name;
        this.survivorLevel = survivorLevel;
        this.ammoInventory = ammoInventory;
        this.foodInventory = new ArrayList<>();
        this.gunInventory = new ArrayList<>();
        this.meleeInventory = new ArrayList<>();
        this.survivorHealth = 50;
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

    public void setsLevel(SurvivorLevel survivorLevel) {
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

    public void setFoodInventory(List<Food> foodInventory) {
        this.foodInventory = foodInventory;
    }

    public List<Gun> getGunInventory() {
        return gunInventory;
    }

    public void setGunInventory(List<Gun> gunInventory) {
        this.gunInventory = gunInventory;
    }

    public List<Melee> getMeleeInventory() {
        return meleeInventory;
    }

    public void setMeleeInventory(List<Melee> meleeInventory) {
        this.meleeInventory = meleeInventory;
    }

    public int getSurvivorHealth() {
        return survivorHealth;
    }

    public void setSurvivorHealth(int survivorHealth) {
        this.survivorHealth = survivorHealth;
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
