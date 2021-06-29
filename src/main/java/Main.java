import models.SurvivorLevel;
import models.ZombieLevel;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        int health = SurvivorLevel.OUTCASTONE.getHP();
        int attackDamage = SurvivorLevel.OUTCASTONE.getMaxStrength();

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
            int zombieSpeed = rand.nextInt(ZombieLevel.ONE.getSpeed());
            int zombieAccuracy = rand.nextInt(ZombieLevel.ONE.getAccuracy());
            int zombieAttackDamage = rand.nextInt(ZombieLevel.ONE.getStrength());

            System.out.println("A Shambler has appeared!");

            while(zombieHealth > 0) {
                System.out.println("Your HP: " + health);
                System.out.println("Shambler's HP: " + zombieHealth);
                System.out.println("What would you like to do?");
                System.out.println("1. Attack");
                System.out.println("2. Restore energy");
                System.out.println("3. Run!");

                String input = in.nextLine();

                if(input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(zombieAttackDamage);

                    zombieHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("You receive " + damageTaken + " damage from the Shambler.");
                    if (health < 1) {
                        System.out.println("You have taken too much damage to go on.");
                        break;
                    }
                    System.out.println("You strike the Shambler for " + damageDealt + " damage.");

                }
                else if (input.equals("2")) {
                    if (numFood > 0) {
                        health += healthPotionHealAmount;
                        if (health > 100) {
                            health = 100;
                        }
                        numHealthPotions--;
                        healthPotionsUsed++;
                        System.out.println("You health has been restored by " + healthPotionHealAmount + ".");
                    }
                    else if (numSnack > 0) {

                    }
                    else if (numSnack > 0) {

                    }
                    else {
                        System.out.println("You have no health potions left!");
                    }
                }
                else if (input.equals("3")) {
                    System.out.println("You run away from the " + enemy + "!");
                    enemyFledCount++;
                    continue GAME;
                }
                else {
                    System.out.println("Invalid command.");
                }
        }
        System.out.println("You defeated " + zombiesDefeated + " Zombies, fled from " + zombieFledCount + " and used " + healthRestoresUsed + " HP restores.");
        System.out.println("Thanks for playing!");
    }
}
