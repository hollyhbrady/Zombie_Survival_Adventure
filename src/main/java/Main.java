import models.ZombieLevel;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        int healthRestoreDropChance = 40;
        int zombiesDefeated = 0;
        int healthRestoresUsed = 0;
        int zombieFledCount = 0;

        boolean running = true;

        System.out.println("Welcome to the survival zone!");

        GAME:
        while(running) {
            System.out.println("------------------------------");

            // LEVEL 1 ZOMBIES
            Enum zombie = ZombieLevel.ONE;
            int zombieHealth = rand.nextInt(ZombieLevel.ONE.getHP());
            int zombieSpeed = rand.nextInt(ZombieLevel.ONE.getSpeed());
            int zombieAccuracy = rand.nextInt(ZombieLevel.ONE.getAccuracy());

            System.out.println();
        }
        System.out.println("You defeated " + zombiesDefeated + " Zombies, fled from " + zombieFledCount + " and used " + healthRestoresUsed + " HP restores.");
        System.out.println("Thanks for playing!");
    }
}
