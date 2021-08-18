package Holly.Zombie_Survival_Adventure.repositories;

import Holly.Zombie_Survival_Adventure.models.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurvivorRepository extends JpaRepository<Survivor, Long> {
}
