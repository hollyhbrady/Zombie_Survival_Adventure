package Holly.Zombie_Survival_Adventure;

import Holly.Zombie_Survival_Adventure.models.Survivor;
import Holly.Zombie_Survival_Adventure.models.SurvivorLevel;
import Holly.Zombie_Survival_Adventure.models.Zombie;
import models.loot.Food;
import models.loot.Gun;
import models.loot.Melee;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    public static int zombieAttack(Zombie zombie, Survivor survivor) {
        Random rand = new Random();

        if (rand.nextInt(100) < zombie.getZLevel().getAccuracy()) {
            int damageTaken = rand.nextInt(zombie.getZLevel().getMaxStrength());
            survivor.setSurvivorHealth(survivor.getSurvivorHealth() - damageTaken);
            System.out.println("You receive " + damageTaken + " damage from the " + zombie.getName());
        } else {
            System.out.println("The " + zombie.getName() + " missed you!");
            System.out.println("That is one seriously decomposed Z-head.");
        }
        return survivor.getSurvivorHealth();
    }

//    public static void afterZombieFight() {
//        System.out.println("------------------------------");
//        System.out.println("What would you like to do?");
//        System.out.println("1. Continue on your path");
//        System.out.println("2. Return to hut");
//
//        Scanner in = new Scanner(System.in);
//        String input = in.nextLine();
//
//        while(!input.equals("1") && !input.equals("2")) {
//            System.out.println("Invalid command");
//            input = in.nextLine();
//        }
//        if (input.equals("1")) {
//            System.out.println("You continue further down the path.");
//        }
//        else if (input.equals("2")) {
//            System.out.println("You return to your hut for a rest.");
////            break;
//        }
//    }

    public static int fightZombie (Zombie zombie, Survivor survivor){
        boolean running = true;
        Random rand = new Random();
        Scanner in = new Scanner(System.in);

        GAME:
        while(running) {
            System.out.println("------------------------------");

            int zombieHealth = rand.nextInt(zombie.getZLevel().getHP());
            if (zombieHealth < 1) {
                zombieHealth = 1;
            }
            int zombieSpeed = rand.nextInt(zombie.getZLevel().getSpeed());
            if (zombieSpeed < 1) {
                zombieSpeed = 1;
            }
            int attackDamage = survivor.survivorLevel.getMaxStrength();

            System.out.println("A " + zombie.getName() + " has appeared!");

            while (zombieHealth > 0) {
                System.out.println("Your HP: " + survivor.getSurvivorHealth());
                System.out.println(zombie.getName() + "'s HP: " + zombieHealth);
                System.out.println("What would you like to do?");
                System.out.println("1. Attack");
                System.out.println("2. Restore energy");
                System.out.println("3. Run!");

                String input = in.nextLine();

                if (input.equals("1")) {
                    System.out.println("How are you going to fight?");
                    System.out.println("1. Use my gun");
                    System.out.println("2. With my knife");
                    System.out.println("3. I have no weapons left!");

//                    if (survivor.getSurvivorHealth() < 1) {
//                        System.out.println("You have taken too much damage to go on.");
//                        break;
//                    }

                    String attackInput = in.nextLine();

                    if (attackInput.equals("1")) {
                        zombieAttack(zombie, survivor);
                        if (survivor.getSurvivorHealth() < 1) {
                            System.out.println("You have taken too much damage to go on.");
                            break;
                        }
                        if (survivor.getGunInventory().size() > 0 && survivor.getAmmoInventory() > 0) {
                            survivor.setAmmoInventory(survivor.getAmmoInventory() - 1);
                            int damageDealt = (rand.nextInt(attackDamage) + Gun.HANDGUN.getDamage());
                            if (rand.nextInt(100) < survivor.getSurvivorLevel().getGunAccuracy()) {
                                zombieHealth -= damageDealt;
                                System.out.println("You shoot the " + zombie.getName() + " and do " + damageDealt + " damage.");
                            } else {
                                System.out.println("Your shot missed!");
                            }
                            System.out.println("You have " + survivor.getAmmoInventory() + " bullets left");
                        } else if (survivor.getGunInventory().size() > 0) {
                            System.out.println("You don't have any bullets left!");
                        } else {
                            System.out.println("You don't have a gun!");
                        }
                    } else if (attackInput.equals("2")) {
                        zombieAttack(zombie, survivor);
                        if (survivor.getSurvivorHealth() < 1) {
                            System.out.println("You have taken too much damage to go on.");
                            break;
                        }
                        if (survivor.getMeleeInventory().size() > 0) {
                            int damageDealt = (rand.nextInt(attackDamage) + Melee.KNIFE.getDamage());
                            if (rand.nextInt(100) < survivor.getSurvivorLevel().getMeleeAccuracy()) {
                                zombieHealth -= damageDealt;
                                System.out.println("You slash the " + zombie.getName() + " for " + damageDealt + " damage.");
                            } else {
                                System.out.println("You take a swing and miss!");
                            }
                        } else {
                            System.out.println("You don't have a close quarters weapon!");
                        }
                    } else if (attackInput.equals("3")) {
                        zombieAttack(zombie, survivor);
                        if (survivor.getSurvivorHealth() < 1) {
                            System.out.println("You have taken too much damage to go on.");
                            break;
                        }
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
                } else if (input.equals("2")) {
                    if (survivor.getFoodInventory().contains(Food.BAKEDBEANS)) {
                        survivor.setSurvivorHealth(survivor.getSurvivorHealth() + Food.BAKEDBEANS.getRestore());
                        if (survivor.getSurvivorHealth() > SurvivorLevel.OUTCAST.getHP()) {
                            survivor.setSurvivorHealthMax();
                        }
                        survivor.getFoodInventory().remove(Food.BAKEDBEANS);
//                        healthRestoresUsed++;
                        System.out.println("Your health has been restored by " + Food.BAKEDBEANS.getRestore() + ".");
                    } else if (survivor.getFoodInventory().contains(Food.DRIEDFRUIT)) {
                        survivor.setSurvivorHealth(survivor.getSurvivorHealth() + Food.DRIEDFRUIT.getRestore());
                        if (survivor.getSurvivorHealth() > SurvivorLevel.OUTCAST.getHP()) {
                            survivor.setSurvivorHealthMax();
                        }
                        survivor.getFoodInventory().remove(Food.DRIEDFRUIT);
//                        healthRestoresUsed++;
                        System.out.println("Your health has been restored by " + Food.DRIEDFRUIT.getRestore() + ".");
                    } else if (survivor.getFoodInventory().contains(Food.IRNBRU)) {
                        survivor.setSurvivorHealth(survivor.getSurvivorHealth() + Food.IRNBRU.getRestore());
                        if (survivor.getSurvivorHealth() > SurvivorLevel.OUTCAST.getHP()) {
                            survivor.setSurvivorHealthMax();
                        }
                        survivor.getFoodInventory().remove(Food.IRNBRU);
//                        healthRestoresUsed++;
                        System.out.println("Your health has been restored by " + Food.IRNBRU.getRestore() + ".");
                    } else {
                        System.out.println("You have nothing left to eat!");
                    }
                } else if (input.equals("3")) {
                    if (zombieSpeed < SurvivorLevel.OUTCAST.getSpeed()) {
                        System.out.println("You run away from the " + zombie.getName() + "!");
//                        zombieFledCount++;
                        continue GAME;
//                        break;
                    } else {
                        System.out.println("Cannot escape! Are you going to be zombie dinner!?");
                    }
                } else {
                    System.out.println("Invalid command.");
                }
            }
            System.out.println("------------------------------");
            System.out.println("The " + zombie.getName() + " was defeated!");
//        zombiesDefeated++;
            int foodDropChance = 40;
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
            break;
        }
        return survivor.getSurvivorHealth();
    }

    public static void continueOrGoToHut() {
        System.out.println("------------------------------");
        System.out.println("What would you like to do?");
        System.out.println("1. Continue on your path");
        System.out.println("2. Return to hut");

        Scanner in = new Scanner(System.in);
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
        }
    }

}
