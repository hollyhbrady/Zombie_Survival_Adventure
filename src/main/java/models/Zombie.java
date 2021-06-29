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

    public ZombieLevels getZLevel() {
        return zLevel;
    }

    public void setZLevel(ZombieLevels zLevel) {
        this.zLevel = zLevel;
    }
}
