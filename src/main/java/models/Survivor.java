package models;

import models.loot.Food;
import models.loot.Gun;
import models.loot.Loot;
import models.loot.Melee;

import java.util.ArrayList;
import java.util.List;

public class Survivor {

    private Long id;
    private String name;
    private List<Loot> ammoInventory;
    private List<Food> foodInventory;
    private List<Gun> gunInventory;
    private List<Melee> meleeInventory;
    public SurvivorLevel survivorLevel;

    public Survivor(String name, SurvivorLevel survivorLevel) {
        this.name = name;
        this.survivorLevel = survivorLevel;
        this.ammoInventory = new ArrayList<>();
        this.foodInventory = new ArrayList<>();
        this.gunInventory = new ArrayList<>();
        this.meleeInventory = new ArrayList<>();
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

    public List<Loot> getAmmoInventory() {
        return ammoInventory;
    }

    public void setAmmoInventory(List<Loot> ammoInventory) {
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

    public void addFoodToInventory(Food food) {
        this.foodInventory.add(food);
    }
}
