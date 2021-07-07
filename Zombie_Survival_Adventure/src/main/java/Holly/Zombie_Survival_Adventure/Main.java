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

        Survivor survivor = new Survivor("Allie", 0, SurvivorLevel.OUTCAST, 50, 0, 0);
        survivor.addFoodToInventory(Food.BAKEDBEANS);
        survivor.addFoodToInventory(Food.DRIEDFRUIT);
        survivor.addFoodToInventory(Food.IRNBRU);
        survivor.addMeleeToInventory(Melee.KNIFE);
        survivor.setAmmoInventory(5);

        //CHOOSE CHARACTER

//        GameLogic.chooseCharacter();
//        System.out.println(survivor.getName());
        // START OF GAME

        GameLogic.gameStart(survivor);

        // LEVEL ONE
        Zombie zombie = new Zombie("Shambler", ZombieLevel.ONE);

        GameLogic.sceneOne(zombie, survivor);
        GameLogic.continueOrGoToHut();


        // LEVEL TWO
        zombie = new Zombie("Walker", ZombieLevel.TWO);

        GameLogic.fightZombie(zombie, survivor);

        // LEVEL THREE
        zombie = new Zombie("Runner", ZombieLevel.THREE);

        GameLogic.fightZombie(zombie, survivor);


        System.out.println("You survived " + survivor.getZombiesEncountered() + " Zombies, and used " + survivor.getHPRestoresUsed() + " HP restores.");
        System.out.println("Thanks for playing!");
    }
}
