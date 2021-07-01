import models.Survivor;
import models.SurvivorLevel;
import models.Zombie;
import models.ZombieLevel;

import java.util.Random;

public class GameLogic {

//    Random rand = new Random();

    Survivor survivor = new Survivor("Holly", SurvivorLevel.OUTCASTONE, 0);
    Zombie zombie = new Zombie("Shambler", ZombieLevel.ONE);

    int health = survivor.survivorLevel.getHP();
    int attackDamage = survivor.survivorLevel.getMaxStrength();


    public static int zombieAttack(Zombie zombie, Survivor survivor, int health){
        Random rand = new Random();
//        int health = survivor.survivorLevel.getHP();
        if (rand.nextInt(100) < zombie.getZLevel().getAccuracy()) {
            int damageTaken = rand.nextInt(zombie.getZLevel().getMaxStrength());
            health -= damageTaken;
            System.out.println("You receive " + damageTaken + " damage from the " + zombie.getName());
        } else {
            System.out.println("The " + zombie.getName() + " missed you! That is one seriously decomposing dude.");
        }
        System.out.println("How are you going to fight?");
        System.out.println("1. Use my gun");
        System.out.println("2. Close quarters weapon");
        System.out.println("3. My fists");
        return health;
    }







}
