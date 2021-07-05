package Holly.Zombie_Survival_Adventure.repositories;

import Holly.Zombie_Survival_Adventure.models.SurvivorLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurvivorLevelRepository extends JpaRepository<SurvivorLevel, Long> {
}
