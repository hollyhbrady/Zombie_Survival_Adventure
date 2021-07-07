package Holly.Zombie_Survival_Adventure.components;

import Holly.Zombie_Survival_Adventure.models.Survivor;
import Holly.Zombie_Survival_Adventure.models.SurvivorLevel;
import Holly.Zombie_Survival_Adventure.models.Zombie;
import Holly.Zombie_Survival_Adventure.repositories.SurvivorLevelRepository;
import Holly.Zombie_Survival_Adventure.repositories.SurvivorRepository;
import Holly.Zombie_Survival_Adventure.repositories.ZombieRepository;
import models.ZombieLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    SurvivorRepository survivorRepository;

    @Autowired
    ZombieRepository zombieRepository;

    @Autowired
    SurvivorLevelRepository survivorLevelRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Survivor holly = new Survivor("Holly", 6, SurvivorLevel.OUTCAST, 50, 0, 0, 0, 0);
        survivorRepository.save(holly);

//        SurvivorLevel Soldier = new SurvivorLevel(50, 80, 70,20, 10);
        survivorLevelRepository.save(SurvivorLevel.SOLDIER);
        survivorLevelRepository.save(SurvivorLevel.OUTCAST);
        survivorLevelRepository.save(SurvivorLevel.WANDERER);

        System.out.println(Arrays.stream(SurvivorLevel.values()).distinct());

        holly.setSurvivorHealthMax();

        holly.addFoodToInventory(models.loot.Food.BAKEDBEANS);
        holly.addFoodToInventory(models.loot.Food.DRIEDFRUIT);
        holly.addFoodToInventory(models.loot.Food.IRNBRU);
        holly.addMeleeToInventory(models.loot.Melee.KNIFE);
        holly.addGunToInventory(Holly.Zombie_Survival_Adventure.models.loot.Gun.HANDGUN);

        Zombie shambler = new Zombie("Shambler", ZombieLevel.ONE);
        zombieRepository.save(shambler);

        Zombie walker = new Zombie("Walker", ZombieLevel.THREE);
        zombieRepository.save(walker);

        Zombie runner = new Zombie("Runner", ZombieLevel.THREE);
        zombieRepository.save(runner);

    }
}
