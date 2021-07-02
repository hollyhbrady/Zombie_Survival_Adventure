package Holly.Zombie_Survival_Adventure.models;

import javax.persistence.*;

@Entity
@Table(name = "zombies")
public class Zombie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private models.ZombieLevel zLevel;

    public Zombie( String name, models.ZombieLevel zLevel) {
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

    public models.ZombieLevel getZLevel() {
        return zLevel;
    }

    public void setZLevel(models.ZombieLevel zLevel) {
        this.zLevel = zLevel;
    }
}
