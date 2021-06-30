import models.Survivor;
import models.SurvivorLevel;
import models.ZombieLevel;
import models.loot.Food;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        Survivor survivor = new Survivor("Holly", SurvivorLevel.OUTCASTONE);
        
        int health = survivor.survivorLevel.getHP();
        int attackDamage = survivor.survivorLevel.getMaxStrength();

        int numFood = 1;
        int numDrink = 1;
        int numSnack = 1;

        int foodDropChance = 40;
        int snackDropChance = 30;
        int drinkDropChance = 20;

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
                    int damageDealt = rand.nextInt(attackDamage);
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
                        if ();
                    } else if (attackInput.equals("2")) {

                    } else {
                        System.out.println("Invalid command.");
                    }




                    zombieHealth -= damageDealt;

                    if (health < 1) {
                        System.out.println("You have taken too much damage to go on.");
                        break;
                    }
                    System.out.println("You strike the Shambler for " + damageDealt + " damage.");

                } else if (input.equals("2")) {
                    if (numFood > 0) {
                        health += Food.BAKEDBEANS.getRestore();
                        if (health > SurvivorLevel.OUTCASTONE.getHP()) {
                            health = SurvivorLevel.OUTCASTONE.getHP();
                        }
                        numFood--;
                        healthRestoresUsed++;
                        System.out.println("You health has been restored by " + Food.BAKEDBEANS.getRestore() + ".");
                    } else if (numSnack > 0) {
                        health += Food.DRIEDFRUIT.getRestore();
                        if (health > SurvivorLevel.OUTCASTONE.getHP()) {
                            health = SurvivorLevel.OUTCASTONE.getHP();
                        }
                        numSnack--;
                        healthRestoresUsed++;
                        System.out.println("You health has been restored by " + Food.DRIEDFRUIT.getRestore() + ".");
                    } else if (numDrink > 0) {
                        health += Food.IRNBRU.getRestore();
                        if (health > SurvivorLevel.OUTCASTONE.getHP()) {
                            health = SurvivorLevel.OUTCASTONE.getHP();
                        }
                        numDrink--;
                        healthRestoresUsed++;
                        System.out.println("You health has been restored by " + Food.IRNBRU.getRestore() + ".");
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
                numFood++;
                System.out.println("It dropped a can of baked beans!");
                System.out.println("You now have " + numFood + " cans of beans!");
            }
            if (rand.nextInt(100) < snackDropChance) {
                numSnack++;
                System.out.println("It dropped a pack of dried fruit!");
                System.out.println("You now have " + numSnack + " packs!");
            }
            if (rand.nextInt(100) < drinkDropChance) {
                numDrink++;
                System.out.println("It dropped a can of Irn-Bru!!");
                System.out.println("You now have " + numDrink + " cans. If only they had nutritional value...");
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
