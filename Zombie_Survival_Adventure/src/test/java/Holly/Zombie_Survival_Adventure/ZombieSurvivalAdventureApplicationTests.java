package Holly.Zombie_Survival_Adventure;

import Holly.Zombie_Survival_Adventure.models.Survivor;
import Holly.Zombie_Survival_Adventure.models.Zombie;
import com.sun.tools.internal.jxc.SchemaGenerator;
import models.SurvivorLevel;
import models.ZombieLevel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZombieSurvivalAdventureApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void createSurvivor() {
		Survivor holly = new Survivor("Holly", 6, SurvivorLevel.OUTCASTONE, 50);
	}

	@Test
	public void createZombie() {
		Zombie runner = new Zombie("Runner", ZombieLevel.THREE);
	}

}
