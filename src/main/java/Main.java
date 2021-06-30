import models.Survivor;
import models.SurvivorLevel;
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

        Survivor survivor = new Survivor("Holly", SurvivorLevel.OUTCASTONE);
        
        int health = survivor.survivorLevel.getHP();
        int attackDamage = survivor.survivorLevel.getMaxStrength();

        survivor.addFoodToInventory(Food.BAKEDBEANS);
        survivor.addFoodToInventory(Food.DRIEDFRUIT);
        survivor.addFoodToInventory(Food.IRNBRU);

        int foodDropChance = 40;

        int zombiesDefeated = 0;
        int healthRestoresUsed = 0;
        int zombieFledCount = 0;

        boolean running = true;

        System.out.println("Welcome to the survival zone!");

        GAME:
        while(running) {
            System.out.println("------------------------------");

            // LEVEL 1 ZOMBIES
//            Enum zombie = ZombieLevel.ONE;
//            int zombieHealth = ZombieLevel.ONE.getHP();
            int zombieHealth = rand.nextInt(ZombieLevel.ONE.getHP());
            if (zombieHealth < 1) {
                zombieHealth = 1;
            }
            int zombieSpeed = rand.nextInt(ZombieLevel.ONE.getSpeed());
            if (zombieSpeed < 1) {
                zombieSpeed = 1;
            }
            int zombieAccuracy = ZombieLevel.ONE.getAccuracy();
            int zombieAttackDamage = ZombieLevel.ONE.getStrength();

            System.out.println("A Shambler has appeared!");

            while (zombieHealth > 0) {
                System.out.println("Your HP: " + health);
                System.out.println("Shambler's HP: " + zombieHealth);
                System.out.println("What would you like to do?");
                System.out.println("1. Attack");
                System.out.println("2. Restore energy");
                System.out.println("3. Run!");

                String input = in.nextLine();

                if (input.equals("1")) {
                    if (rand.nextInt(100) < zombieAccuracy) {
                        int damageTaken = rand.nextInt(zombieAttackDamage);
                        health -= damageTaken;
                        System.out.println("You receive " + damageTaken + " damage from the Shambler.");
                    } else {
                        System.out.println("The Shambler missed you! That is one seriously decomposing dude.");
                    }
                    System.out.println("How are you going to fight?");
                    System.out.println("1. Shoot");
                    System.out.println("2. Smash");

                    String attackInput = in.nextLine();

                    if (attackInput.equals("1")) {
                        if (survivor.getGunInventory().size() > 0 && survivor.getAmmoInventory().size() > 0) {
                            int damageDealt = (rand.nextInt(attackDamage) * Gun.HANDGUN.getDamage()) / 2;
                            if (rand.nextInt(100) < survivor.getSurvivorLevel().getGunAccuracy()) {
                                zombieHealth -= damageDealt;
                                System.out.println("You shoot the Shambler and do " + damageDealt + " damage.");
                                System.out.println("You have " + survivor.getAmmoInventory().size() + " bullets left");
                            }  else {
                                System.out.println("Your shot missed!");
                            }
                        } else if (survivor.getGunInventory().size() > 0) {
                            System.out.println("You don't have any bullets!");
                        } else {
                            System.out.println("You don't have a gun!");
                        }
                    } else if (attackInput.equals("2")) {
                        int damageDealt = (rand.nextInt(attackDamage) * Melee.AXE.getDamage()) / 2;
                        if (rand.nextInt(100) < survivor.getSurvivorLevel().getMeleeAccuracy()) {
                            zombieHealth -= damageDealt;
                            System.out.println("You strike the Shambler for " + damageDealt + " damage.");
                        } else {
                            System.out.println();
                        }
                    } else {
                        System.out.println("Invalid command.");
                    }
                    if (health < 1) {
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
                        System.out.println("You run away from the Shambler!");
                        zombieFledCount++;
                        continue GAME;
                    } else {
                        System.out.println("Cannot escape! Are you going to be zombie dinner!?");
                    }
                } else {
                    System.out.println("Invalid command.");
                }
            }
            if (health < 1) {
                System.out.println("You limp back to your hut, will you be next to join the ranks of the infected?");
                break;
            }
            System.out.println("------------------------------");
            System.out.println("The Shambler was defeated!");
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
