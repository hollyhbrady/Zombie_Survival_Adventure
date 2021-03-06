package Holly.Zombie_Survival_Adventure;

import Holly.Zombie_Survival_Adventure.models.Survivor;
import Holly.Zombie_Survival_Adventure.models.SurvivorLevel;
import Holly.Zombie_Survival_Adventure.models.Zombie;
import models.ZombieLevel;
import Holly.Zombie_Survival_Adventure.models.loot.Food;
import Holly.Zombie_Survival_Adventure.models.loot.Melee;

public class Main {

    public static void main(String[] args) {

        Survivor survivor = new Survivor("Allie", 0, SurvivorLevel.OUTCAST, 50, 0, 0, 0, 0, 0, 0);

        // ADD ZOMBIE MESSAGES/SET UP

        // START OF GAME

        GameLogic.gameStart(survivor);

        // LEVEL ONE
        Zombie zombie = new Zombie("Biter", ZombieLevel.ONE);
        System.out.println("You know what? These zombies aren't so smart, or fast. \n" +
                "I've heard stories of much worse. Were they exaggerated? \n" +
                "All these can do is bite, damn Biters!");
        System.out.println("------------------------------\n" +
        ".... Oh no! Instant Karma!");

        Scenes.sceneOne(survivor, zombie);

        // LEVEL TWO
        zombie = new Zombie("Walker", ZombieLevel.TWO);
        System.out.println("Are these zombies getting faster? \n" +
                "Maybe they have been recently turned... or are they better fed closer to the city? \n" +
                "Hmmm, I'm going to call these ones Walkers");
        System.out.println("------------------------------");

        Scenes.sceneEleven(survivor, zombie);

        // LEVEL THREE
        zombie = new Zombie("Runner", ZombieLevel.THREE);
        System.out.println("Oh no! This is a whole new breed of zombie. \n" +
                "They can run as fast as I can! \n" +
                "How can I outrun these Runners!? \n" +
                "I'm going to need to be a lot smarter about my choices going forward...");
        System.out.println("------------------------------");

        System.out.println("You survived " + survivor.getZombiesEncountered() + " Zombies, and used " + survivor.getHPRestoresUsed() + " HP restores.");
        System.out.println("To be continued...");
    }
}
