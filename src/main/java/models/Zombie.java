package models;

public class Zombie {

    private Long id;
    private String name;
    private ZombieLevel zLevel;

    public Zombie(ZombieLevel zLevel, String name) {
        this.zLevel = zLevel;
        this.name = name;
    }

    public Zombie() {
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

    public ZombieLevel getZLevel() {
        return zLevel;
    }

    public void setZLevel(ZombieLevel zLevel) {
        this.zLevel = zLevel;
    }
}
