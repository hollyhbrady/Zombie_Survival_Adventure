package Holly.Zombie_Survival_Adventure.components;

import Holly.Zombie_Survival_Adventure.models.Survivor;
import Holly.Zombie_Survival_Adventure.models.SurvivorLevel;
import Holly.Zombie_Survival_Adventure.models.Zombie;
import Holly.Zombie_Survival_Adventure.repositories.SurvivorRepository;
import Holly.Zombie_Survival_Adventure.repositories.ZombieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    SurvivorRepository survivorRepository;

    @Autowired
    ZombieRepository zombieRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Survivor holly = new Survivor("Holly", 6, SurvivorLevel.OUTCAST, 0);
        survivorRepository.save(holly);

        holly.setSurvivorHealthMax();

        holly.addFoodToInventory(models.loot.Food.BAKEDBEANS);
        holly.addFoodToInventory(models.loot.Food.DRIEDFRUIT);
        holly.addFoodToInventory(models.loot.Food.IRNBRU);
        holly.addMeleeToInventory(models.loot.Melee.KNIFE);
        holly.addGunToInventory(models.loot.Gun.HANDGUN);

        Zombie shambler = new Zombie("Shambler", models.ZombieLevel.ONE);
        zombieRepository.save(shambler);

        Zombie walker = new Zombie("Walker", models.ZombieLevel.THREE);
        zombieRepository.save(walker);

        Zombie runner = new Zombie("Runner", models.ZombieLevel.THREE);
        zombieRepository.save(runner);

    }
}
