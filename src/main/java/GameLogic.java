import models.Survivor;
import models.SurvivorLevel;
import models.Zombie;
import models.ZombieLevel;
import models.loot.Gun;

import java.util.Random;

public class GameLogic {

//    Random rand = new Random();

    Survivor survivor = new Survivor("Holly", SurvivorLevel.OUTCASTONE, 0);
    Zombie zombie = new Zombie("Shambler", ZombieLevel.ONE);

    int health = survivor.survivorLevel.getHP();
    int attackDamage = survivor.survivorLevel.getMaxStrength();


    public static int zombieAttack(Zombie zombie, Survivor survivor, int health){
        Random rand = new Random();
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

//    public static int getSurvivorAttackDamage(Survivor survivor) {
//        int attackDamage = survivor.survivorLevel.getMaxStrength();
//        return attackDamage;
//    }
//
//    public static int getZombieHealth(Zombie zombie) {
//        Random rand = new Random();
//        int zombieHealth = rand.nextInt(zombie.getZLevel().getHP());
//        if (zombieHealth < 1) {
//            zombieHealth = 1;
//        }
//        return zombieHealth;
//    }

    public static int survivorAttackWithGun(Survivor survivor, Zombie zombie) {
        Random rand = new Random();
//        getZombieHealth(zombie);
        int zombieHealth = rand.nextInt(zombie.getZLevel().getHP());
        if (zombieHealth < 1) {
            zombieHealth = 1;
        }

        if (survivor.getGunInventory().size() > 0 && survivor.getAmmoInventory() > 0) {
//            GameLogic.getSurvivorAttackDamage(survivor);
            int attackDamage = survivor.survivorLevel.getMaxStrength();
            int damageDealt = (rand.nextInt(attackDamage) + Gun.HANDGUN.getDamage());
            if (rand.nextInt(100) < survivor.getSurvivorLevel().getGunAccuracy()) {
                zombieHealth -= damageDealt;
                System.out.println("You shoot the " + zombie.getName() + " and do " + damageDealt + " damage.");
                System.out.println("You have " + survivor.getAmmoInventory() + " bullets left");
            }  else {
                System.out.println("Your shot missed!");
            }
        } else if (survivor.getGunInventory().size() > 0) {
            System.out.println("You don't have any bullets left!");
        } else {
            System.out.println("You don't have a gun!");
        }
        return zombieHealth;
    }





}
