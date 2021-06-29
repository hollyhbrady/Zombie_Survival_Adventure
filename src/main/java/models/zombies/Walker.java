package models.zombies;

import models.Zombie;
import models.ZombieLevel;

public class Walker extends Zombie {

    private String name;

    public Walker(ZombieLevel zLevel, String name) {
        super(zLevel);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
