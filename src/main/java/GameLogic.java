import models.Survivor;
import models.SurvivorLevel;
import models.Zombie;
import models.ZombieLevel;
import models.loot.Food;
import models.loot.Gun;
import models.loot.Melee;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    Random rand = new Random();

    Survivor survivor = new Survivor("Holly", SurvivorLevel.OUTCASTONE, 0);
    Zombie zombie = new Zombie("Shambler", ZombieLevel.ONE);

    int health = survivor.survivorLevel.getHP();
    int attackDamage = survivor.survivorLevel.getMaxStrength();

    boolean running = true;

    public static int zombieAttack(Zombie zombie, Survivor survivor){
        Random rand = new Random();
        int health = survivor.survivorLevel.getHP();
        if (rand.nextInt(100) < zombie.getZLevel().getAccuracy()) {
            int damageTaken = rand.nextInt(zombie.getZLevel().getMaxStrength());
            health -= damageTaken;
            System.out.println("You receive " + damageTaken + " damage from the " + zombie.getName());
        } else {
            System.out.println("The " + zombie.getName() + " missed you! That is one seriously decomposing dude.");
        }
        return health;
    }

    public static int getSurvivorHealth(Survivor survivor) {
        int survivorHealth = survivor.survivorLevel.getHP();
        return survivorHealth;
    }

    public static void increaseSurvivorHealth(Survivor survivor, int adjust) {
        int survivorHealth = getSurvivorHealth(survivor) + adjust;
    }

    public void decreaseSurvivorHealth(Survivor survivor, int adjust) {
        int survivorHealth = getSurvivorHealth(survivor) - adjust;

    }

    public static int whileZombieIsAlive(Zombie zombie, Survivor survivor){
        boolean running = true;
        Random rand = new Random();
        Scanner in = new Scanner(System.in);

        GAME:
        while(running) {
            System.out.println("------------------------------");

            // LEVEL 1 ZOMBIES
//            Enum zombie = ZombieLevel.ONE;
//            int zombieHealth = ZombieLevel.ONE.getHP();
            int zombieHealth = rand.nextInt(zombie.getZLevel().getHP());
            if (zombieHealth < 1) {
                zombieHealth = 1;
            }
            int zombieSpeed = rand.nextInt(zombie.getZLevel().getSpeed());
            if (zombieSpeed < 1) {
                zombieSpeed = 1;
            }

            System.out.println("A " + zombie.getName() + " has appeared!");

//            getSurvivorHealth(survivor);
//            int survivorHealth = survivor.survivorLevel.getHP();

            while (zombieHealth > 0) {
                System.out.println("Your HP: " + getSurvivorHealth(survivor));
                System.out.println(zombie.getName() + "'s HP: " + zombieHealth);
                System.out.println("What would you like to do?");
                System.out.println("1. Attack");
                System.out.println("2. Restore energy");
                System.out.println("3. Run!");

                String input = in.nextLine();

                if (input.equals("1")) {
                    zombieAttack(zombie, survivor);
//
                    System.out.println("How are you going to fight?");
                    System.out.println("1. Use my gun");
                    System.out.println("2. Close quarters weapon");
                    System.out.println("3. My fists");

                    int attackDamage = survivor.survivorLevel.getMaxStrength();
                    String attackInput = in.nextLine();


                    if (attackInput.equals("1")) {
                        if (survivor.getGunInventory().size() > 0 && survivor.getAmmoInventory() > 0) {
                            int damageDealt = (rand.nextInt(attackDamage) + Gun.HANDGUN.getDamage());
                            if (rand.nextInt(100) < survivor.getSurvivorLevel().getGunAccuracy()) {
                                zombieHealth -= damageDealt;
                                System.out.println("You shoot the " + zombie.getName() + " and do " + damageDealt + " damage.");
                                System.out.println("You have " + survivor.getAmmoInventory() + " bullets left");
                            } else {
                                System.out.println("Your shot missed!");
                            }
                        } else if (survivor.getGunInventory().size() > 0) {
                            System.out.println("You don't have any bullets left!");
                        } else {
                            System.out.println("You don't have a gun!");
                        }
                    } else if (attackInput.equals("2")) {
                        if (survivor.getMeleeInventory().size() > 0) {
                            int damageDealt = (rand.nextInt(attackDamage) + Melee.AXE.getDamage());
                            if (rand.nextInt(100) < survivor.getSurvivorLevel().getMeleeAccuracy()) {
                                zombieHealth -= damageDealt;
                                System.out.println("You strike the " + zombie.getName() + " for " + damageDealt + " damage.");
                            } else {
                                System.out.println("You take a swing and miss!");
                            }
                        } else {
                            System.out.println("You don't have a close quarters weapon!");
                        }
                    } else if (attackInput.equals("3")) {
                        int damageDealt = rand.nextInt(attackDamage);
                        if (rand.nextInt(100) < survivor.getSurvivorLevel().getMeleeAccuracy()) {
                            zombieHealth -= damageDealt;
                            System.out.println("You grapple with the " + zombie.getName() + " and cause " + damageDealt + " damage.");
                        } else {
                            System.out.println("You trip and and miss, the " + zombie.getName() + " is on top of you!");
                        }
                    } else {
                        System.out.println("Invalid command.");
                    }
                    if (getSurvivorHealth(survivor) < 1) {
                        System.out.println("You have taken too much damage to go on.");
                        break;
                    }
                } else if (input.equals("2")) {
                    if (survivor.getFoodInventory().contains(Food.BAKEDBEANS)) {
                         health += Food.BAKEDBEANS.getRestore();
                        if (health > SurvivorLevel.OUTCASTONE.getHP()) {
                            health = SurvivorLevel.OUTCASTONE.getHP();
                        }
                        survivor.getFoodInventory().remove(Food.BAKEDBEANS);
                        healthRestoresUsed++;
                        System.out.println("Your health has been restored by " + Food.BAKEDBEANS.getRestore() + ".");
                    } else if (survivor.getFoodInventory().contains(Food.DRIEDFRUIT)) {
                        health += Food.DRIEDFRUIT.getRestore();
                        if (health > SurvivorLevel.OUTCASTONE.getHP()) {
                            health = SurvivorLevel.OUTCASTONE.getHP();
                        }
                        survivor.getFoodInventory().remove(Food.DRIEDFRUIT);
                        healthRestoresUsed++;
                        System.out.println("Your health has been restored by " + Food.DRIEDFRUIT.getRestore() + ".");
                    } else if (survivor.getFoodInventory().contains(Food.IRNBRU)) {
                        health += Food.IRNBRU.getRestore();
                        if (health > SurvivorLevel.OUTCASTONE.getHP()) {
                            health = SurvivorLevel.OUTCASTONE.getHP();
                        }
                        survivor.getFoodInventory().remove(Food.IRNBRU);
                        healthRestoresUsed++;
                        System.out.println("Your health has been restored by " + Food.IRNBRU.getRestore() + ".");
                    } else {
                        System.out.println("You have nothing left to eat!");
                    }
                } else if (input.equals("3")) {
                    if (zombieSpeed < SurvivorLevel.OUTCASTONE.getSpeed()) {
                        System.out.println("You run away from the " + zombie.getName() + "!");
                        zombieFledCount++;
                        continue GAME;
                    } else {
                        System.out.println("Cannot escape! Are you going to be zombie dinner!?");
                    }
                } else {
                    System.out.println("Invalid command.");
                }
            }
        }
        return health;

    }

}
