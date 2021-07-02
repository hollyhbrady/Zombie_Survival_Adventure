package models;

public class Zombie {

    private Long id;
    private String name;
    private ZombieLevel zLevel;

    public Zombie( String name, ZombieLevel zLevel) {
        this.name = name;
        this.zLevel = zLevel;
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
