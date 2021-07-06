package Holly.Zombie_Survival_Adventure;

import Holly.Zombie_Survival_Adventure.models.Survivor;
import Holly.Zombie_Survival_Adventure.models.SurvivorLevel;
import Holly.Zombie_Survival_Adventure.models.Zombie;
import models.ZombieLevel;
import models.loot.Food;
import models.loot.Gun;
import models.loot.Melee;

public class Main {

    public static void main(String[] args) {

        Survivor survivor = new Survivor("Holly", 0, SurvivorLevel.OUTCAST, 50);
        Zombie zombie = new Zombie("Shambler", ZombieLevel.ONE);

        survivor.addFoodToInventory(Food.BAKEDBEANS);
        survivor.addFoodToInventory(Food.DRIEDFRUIT);
        survivor.addFoodToInventory(Food.IRNBRU);
        survivor.addMeleeToInventory(Melee.KNIFE);
        survivor.addGunToInventory(Gun.HANDGUN);
        survivor.setAmmoInventory(5);

        // USE HASHMAP TO RETURN FROM whileZombieIsAlive
        int zombiesDefeated = 0;
        int healthRestoresUsed = 0;
        int zombieFledCount = 0;



        GameLogic.gameStart(survivor);
        GameLogic.fightZombie(zombie, survivor);
        GameLogic.continueOrGoToHut();


//        System.out.println("You defeated " + zombiesDefeated + " Zombies, fled from " + zombieFledCount + " and used " + healthRestoresUsed + " HP restores.");
//        System.out.println("Thanks for playing!");
    }
}
