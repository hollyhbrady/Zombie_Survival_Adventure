package Holly.Zombie_Survival_Adventure.repositories;

import Holly.Zombie_Survival_Adventure.models.Zombie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZombieRepository extends JpaRepository<Zombie, Long> {
}
