package models;

import models.loot.Loot;

import java.util.ArrayList;
import java.util.List;

public class Survivor {

    private Long id;
    private String name;
    private List<Loot> inventory;
    private SurvivorLevel sLevel;

    public Survivor(String name, List<Loot> inventory, SurvivorLevel sLevel) {
        this.name = name;
        this.inventory = new ArrayList<>();
        this.sLevel = sLevel;
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

    public SurvivorLevel getsLevel() {
        return sLevel;
    }

    public void setsLevel(SurvivorLevel sLevel) {
        this.sLevel = sLevel;
    }
}
