package Holly.Zombie_Survival_Adventure;

import Holly.Zombie_Survival_Adventure.models.Survivor;
import Holly.Zombie_Survival_Adventure.models.Zombie;
import Holly.Zombie_Survival_Adventure.repositories.SurvivorRepository;
import Holly.Zombie_Survival_Adventure.repositories.ZombieRepository;
import Holly.Zombie_Survival_Adventure.models.SurvivorLevel;
import models.ZombieLevel;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ZombieSurvivalAdventureApplicationTests {

	@Autowired
	SurvivorRepository survivorRepository;

	@Autowired
	ZombieRepository zombieRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createSurvivor() {
		Survivor holly = new Survivor("Holly", 6, SurvivorLevel.OUTCAST, 50, 0, 0, 0, 0);
		survivorRepository.save(holly);
	}

	@Test
	public void createZombie() {
		Zombie runner = new Zombie("Runner", ZombieLevel.THREE);
		zombieRepository.save(runner);
	}

}
