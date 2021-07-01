import models.Survivor;
import models.SurvivorLevel;
import models.Zombie;
import models.ZombieLevel;
import models.loot.Food;
import models.loot.Gun;
import models.loot.Melee;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        Survivor survivor = new Survivor("Holly", SurvivorLevel.OUTCASTONE, 0);
        Zombie zombie = new Zombie("Shambler", ZombieLevel.ONE);
        
        int health = survivor.survivorLevel.getHP();
//        int attackDamage = survivor.survivorLevel.getMaxStrength();

        survivor.addFoodToInventory(Food.BAKEDBEANS);
        survivor.addFoodToInventory(Food.DRIEDFRUIT);
        survivor.addFoodToInventory(Food.IRNBRU);
        survivor.addMeleeToInventory(Melee.AXE);
        survivor.addGunToInventory(Gun.HANDGUN);
        survivor.setAmmoInventory(5);

        int foodDropChance = 40;

        int zombiesDefeated = 0;
        int healthRestoresUsed = 0;
        int zombieFledCount = 0;

        boolean running = true;

        System.out.println("Welcome to the survival zone!");
        System.out.println("You now have " + survivor.getFoodInventory().size() + " food items to restore health.");
        System.out.println("You have " + survivor.getMeleeInventory().size() + " close quarter weapons.");
        System.out.println("You have " + survivor.getGunInventory().size() + " guns and " + survivor.getAmmoInventory() + " bullets.");
        System.out.println("Proceed wisely.");

        GAME:
        while(running) {
            System.out.println("------------------------------");

            // LEVEL 1 ZOMBIES
//            int zombieHealth = rand.nextInt(zombie.getZLevel().getHP());
//            if (zombieHealth < 1) {
//                zombieHealth = 1;
//            }
            int zombieSpeed = rand.nextInt(zombie.getZLevel().getSpeed());
            if (zombieSpeed < 1) {
                zombieSpeed = 1;
            }

            System.out.println("A " + zombie.getName() + " has appeared!");

            GameLogic.getZombieHealth(zombie);

            GameLogic.whileZombieIsAlive(zombieHealth);
//            while (zombieHealth > 0) {
//                System.out.println("Your HP: " + health);
//                System.out.println(zombie.getName() + "'s HP: " + zombieHealth);
//                System.out.println("What would you like to do?");
//                System.out.println("1. Attack");
//                System.out.println("2. Restore energy");
//                System.out.println("3. Run!");
//
//                String input = in.nextLine();
//
//                if (input.equals("1")) {
//                    GameLogic.zombieAttack(zombie, survivor, health);
//
//
//                    String attackInput = in.nextLine();
//
//                    if (attackInput.equals("1")) {
////                        GameLogic.getSurvivorAttackDamage(survivor);
//                        GameLogic.survivorAttackWithGun(survivor, zombie);
////                        if (survivor.getGunInventory().size() > 0 && survivor.getAmmoInventory() > 0) {
////                            int damageDealt = (rand.nextInt(attackDamage) + Gun.HANDGUN.getDamage());
////                            if (rand.nextInt(100) < survivor.getSurvivorLevel().getGunAccuracy()) {
////                                zombieHealth -= damageDealt;
////                                System.out.println("You shoot the " + zombie.getName() + " and do " + damageDealt + " damage.");
////                                System.out.println("You have " + survivor.getAmmoInventory() + " bullets left");
////                            }  else {
////                                System.out.println("Your shot missed!");
////                            }
////                        } else if (survivor.getGunInventory().size() > 0) {
////                            System.out.println("You don't have any bullets left!");
////                        } else {
////                            System.out.println("You don't have a gun!");
////                        }
//                    } else if (attackInput.equals("2")) {
////                        if (survivor.getMeleeInventory().size() > 0) {
////                            int damageDealt = (rand.nextInt(attackDamage) + Melee.AXE.getDamage());
////                            if (rand.nextInt(100) < survivor.getSurvivorLevel().getMeleeAccuracy()) {
////                                zombieHealth -= damageDealt;
////                                System.out.println("You strike the " + zombie.getName() + " for " + damageDealt + " damage.");
////                            } else {
////                                System.out.println("You take a swing and miss!");
////                            }
////                        } else {
////                            System.out.println("You don't have a close quarters weapon!");
////                        }
//                    } else if (attackInput.equals("3")) {
//                        int damageDealt = rand.nextInt(attackDamage);
//                        if (rand.nextInt(100) < survivor.getSurvivorLevel().getMeleeAccuracy()) {
//                            zombieHealth -= damageDealt;
//                            System.out.println("You grapple with the " + zombie.getName() + " and cause " + damageDealt + " damage.");
//                        } else {
//                            System.out.println("You trip and and miss, the " + zombie.getName() + " is on top of you!");
//                        }
//                    } else {
//                        System.out.println("Invalid command.");
//                    }
//                    if (health < 1) {
//                        System.out.println("You have taken too much damage to go on.");
//                        break;
//                    }
//                } else if (input.equals("2")) {
//                    if (survivor.getFoodInventory().contains(Food.BAKEDBEANS)) {
//                        health += Food.BAKEDBEANS.getRestore();
//                        if (health > SurvivorLevel.OUTCASTONE.getHP()) {
//                            health = SurvivorLevel.OUTCASTONE.getHP();
//                        }
//                        survivor.getFoodInventory().remove(Food.BAKEDBEANS);
//                        healthRestoresUsed++;
//                        System.out.println("Your health has been restored by " + Food.BAKEDBEANS.getRestore() + ".");
//                    } else if (survivor.getFoodInventory().contains(Food.DRIEDFRUIT)) {
//                        health += Food.DRIEDFRUIT.getRestore();
//                        if (health > SurvivorLevel.OUTCASTONE.getHP()) {
//                            health = SurvivorLevel.OUTCASTONE.getHP();
//                        }
//                        survivor.getFoodInventory().remove(Food.DRIEDFRUIT);
//                        healthRestoresUsed++;
//                        System.out.println("Your health has been restored by " + Food.DRIEDFRUIT.getRestore() + ".");
//                    } else if (survivor.getFoodInventory().contains(Food.IRNBRU)) {
//                        health += Food.IRNBRU.getRestore();
//                        if (health > SurvivorLevel.OUTCASTONE.getHP()) {
//                            health = SurvivorLevel.OUTCASTONE.getHP();
//                        }
//                        survivor.getFoodInventory().remove(Food.IRNBRU);
//                        healthRestoresUsed++;
//                        System.out.println("Your health has been restored by " + Food.IRNBRU.getRestore() + ".");
//                    } else {
//                        System.out.println("You have nothing left to eat!");
//                    }
//                } else if (input.equals("3")) {
//                    if (zombieSpeed < SurvivorLevel.OUTCASTONE.getSpeed()) {
//                        System.out.println("You run away from the " + zombie.getName() + "!");
//                        zombieFledCount++;
//                        continue GAME;
//                    } else {
//                        System.out.println("Cannot escape! Are you going to be zombie dinner!?");
//                    }
//                } else {
//                    System.out.println("Invalid command.");
//                }
//            }
            System.out.println("------------------------------");
            System.out.println("The " + zombie.getName() + " was defeated!");
            zombiesDefeated++;
            if (rand.nextInt(100) < foodDropChance) {
                survivor.addFoodToInventory(Food.BAKEDBEANS);
                System.out.println("It dropped a can of baked beans!");
                if (survivor.getFoodInventory().size() > 4){
                    System.out.println("'Some variety would be nice, but you can't be fussy at times like these.'");
                } else {
                    System.out.println("'Protein! This should help me get through til tomorrow at least....'");
                }
                System.out.println("You now have " + survivor.getFoodInventory().size() + " food items");
            } else if (rand.nextInt(100) < foodDropChance) {
                survivor.addFoodToInventory(Food.DRIEDFRUIT);
                System.out.println("It dropped a pack of dried fruit!");
                if (survivor.getFoodInventory().size() > 4){
                    System.out.println("'Great more apricots, I'm sure I can pick of the uh... undead bits.'");
                } else {
                    System.out.println("'I better make these last, I don't want a repeat of last time I ate the whole bag all at once.'");
                }
                System.out.println("You now have " + survivor.getFoodInventory().size() + " food items");
            } else if (rand.nextInt(100) < foodDropChance) {
                survivor.addFoodToInventory(Food.IRNBRU);
                System.out.println("It dropped a can of ... Irn-Bru. Again!?");
                if (survivor.getFoodInventory().size() > 4){
                    System.out.println("'I'll take what I can get! What I wouldn't give for a coke though...'");
                } else {
                    System.out.println("'Oh well, beggars can't be choosers.'");
                }
                System.out.println("You now have " + survivor.getFoodInventory().size() + " food items");
            }
            System.out.println("------------------------------");
            System.out.println("What would you like to do?");
            System.out.println("1. Continue on your path");
            System.out.println("2. Return to hut");

            String input = in.nextLine();

            while(!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command");
                input = in.nextLine();
            }
            if (input.equals("1")) {
                System.out.println("You continue further down the path.");
            }
            else if (input.equals("2")) {
                System.out.println("You return to your hut for a rest.");
                break;
            }
        }
        System.out.println("You defeated " + zombiesDefeated + " Zombies, fled from " + zombieFledCount + " and used " + healthRestoresUsed + " HP restores.");
        System.out.println("Thanks for playing!");
    }
}
