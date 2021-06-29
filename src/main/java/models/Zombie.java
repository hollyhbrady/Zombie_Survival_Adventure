package models;

public class Zombie {

    private Long id;
    private ZombieLevels zLevel;

    public Zombie(ZombieLevels zLevel) {
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

    public ZombieLevels getzLevel() {
        return zLevel;
    }

    public void setzLevel(ZombieLevels zLevel) {
        this.zLevel = zLevel;
    }
}
