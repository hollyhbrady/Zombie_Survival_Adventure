package Holly.Zombie_Survival_Adventure;

import Holly.Zombie_Survival_Adventure.models.Survivor;
import Holly.Zombie_Survival_Adventure.models.SurvivorLevel;
import Holly.Zombie_Survival_Adventure.models.Zombie;
import models.ZombieLevel;
import Holly.Zombie_Survival_Adventure.models.loot.Food;
import Holly.Zombie_Survival_Adventure.models.loot.Melee;

public class Main {

    public static void main(String[] args) {

        Survivor survivor = new Survivor("Allie", 0, SurvivorLevel.OUTCAST, 50, 0, 0, 0, 0, 0);
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
        System.out.println("about L1 zombie here");

        GameLogic.sceneOne(survivor, zombie);

        // LEVEL TWO
        zombie = new Zombie("Walker", ZombieLevel.TWO);
        System.out.println("Are these zombies getting faster? \n" +
                "Maybe they have been recently turned... or are they better fed closer to the city? \n" +
                "Hmmm, I'm going to call these ones WALKERS");

        // LEVEL THREE
        zombie = new Zombie("Runner", ZombieLevel.THREE);
        System.out.println("Oh no! This is a whole new breed of zombie. \n" +
                "Are they as fast as I am!" +
                "I'm going to need to be a lot smarter about my choices going forward...");

        System.out.println("You survived " + survivor.getZombiesEncountered() + " Zombies, and used " + survivor.getHPRestoresUsed() + " HP restores.");
        System.out.println("To be continued...");
    }
}
