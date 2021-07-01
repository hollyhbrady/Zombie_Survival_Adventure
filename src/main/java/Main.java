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

        Survivor survivor = new Survivor("Holly", 0, SurvivorLevel.OUTCASTONE, 50);
        Zombie zombie = new Zombie("Shambler", ZombieLevel.ONE);

        survivor.addFoodToInventory(Food.BAKEDBEANS);
        survivor.addFoodToInventory(Food.DRIEDFRUIT);
        survivor.addFoodToInventory(Food.IRNBRU);
        survivor.addMeleeToInventory(Melee.AXE);
        survivor.addGunToInventory(Gun.HANDGUN);
        survivor.setAmmoInventory(5);

        int zombiesDefeated = 0;
        int healthRestoresUsed = 0;
        int zombieFledCount = 0;

        boolean running = true;

        System.out.println("Welcome to the survival zone!");
        System.out.println("You now have " + survivor.getFoodInventory().size() + " food items to restore health.");
        System.out.println("You have " + survivor.getMeleeInventory().size() + " close quarter weapons.");
        System.out.println("You have " + survivor.getGunInventory().size() + " guns and " + survivor.getAmmoInventory() + " bullets.");
        System.out.println("Proceed wisely");


        GameLogic.whileZombieIsAlive(zombie, survivor);


//        System.out.println("You defeated " + zombiesDefeated + " Zombies, fled from " + zombieFledCount + " and used " + healthRestoresUsed + " HP restores.");
//        System.out.println("Thanks for playing!");
    }
}
