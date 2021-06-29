package models.zombies;

import models.Zombie;
import models.ZombieLevel;

public class Runner extends Zombie {

    private String name;

    public Runner(ZombieLevel zLevel, String name) {
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
