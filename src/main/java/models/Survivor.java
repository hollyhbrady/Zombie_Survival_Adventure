package models;

import models.loot.Loot;

import java.util.ArrayList;
import java.util.List;

public class Survivor {

    private Long id;
    private String name;
    private List<Loot> inventory;
    public SurvivorLevel survivorLevel;

    public Survivor(String name, SurvivorLevel survivorLevel) {
        this.name = name;
        this.survivorLevel = survivorLevel;
        this.inventory = new ArrayList<>();
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

    public List<Loot> getInventory() {
        return inventory;
    }

    public void setInventory(List<Loot> inventory) {
        this.inventory = inventory;
    }

    public SurvivorLevel getSurvivorLevel() {
        return survivorLevel;
    }

    public void setsLevel(SurvivorLevel survivorLevel) {
        this.survivorLevel = survivorLevel;
    }
}
