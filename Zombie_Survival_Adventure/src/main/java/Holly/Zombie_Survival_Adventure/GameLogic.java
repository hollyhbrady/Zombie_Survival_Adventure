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

    public static void gameStart(Survivor survivor) {
        System.out.println("You're stumbling through the woods. \n" +
                "You hear a moan - the shuffle drag of zombie feet. \n" +
                "You can't go much longer without sleep...");
        System.out.println("You have " + survivor.getFoodInventory().size() + " food items to restore health, "
                + survivor.getMeleeInventory().size() + " knife, " +
                survivor.getGunInventory().size() + " gun and " + survivor.getAmmoInventory() + " bullets. \n" +
                "Proceed wisely.");
    }

    public static void inventoryCheck(Survivor survivor) {
        System.out.println("You now have " + survivor.getFoodInventory().size() + " food item(s) to restore health, "
                + survivor.getMeleeInventory().size() + " knives, " +
                survivor.getGunInventory().size() + " gun(s) and " + survivor.getAmmoInventory() + " bullet(s).");
    }

    public static void chooseCharacter() {
        System.out.println("Who are you?");
        System.out.println("1. A Soldier");
        System.out.println("2. A Wanderer");
        System.out.println("3. An Outcast");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        if (input.equals("1")) {
            Survivor survivor = new Survivor("Abby", 0, SurvivorLevel.SOLDIER, 50, 0, 0);
            survivor.addFoodToInventory(Food.BAKEDBEANS);
            survivor.addFoodToInventory(Food.DRIEDFRUIT);
            survivor.addFoodToInventory(Food.IRNBRU);
            survivor.addGunToInventory(Gun.HANDGUN);
            survivor.setAmmoInventory(5);
        } else if (input.equals("2")) {
            Survivor survivor = new Survivor("Joel", 0, SurvivorLevel.WANDERER, 50, 0, 0);
            survivor.addFoodToInventory(Food.BAKEDBEANS);
            survivor.addFoodToInventory(Food.DRIEDFRUIT);
            survivor.addFoodToInventory(Food.IRNBRU);
            survivor.addMeleeToInventory(Melee.KNIFE);
        } else if (input.equals("3")) {
            Survivor survivor = new Survivor("Allie", 0, SurvivorLevel.OUTCAST, 50, 0, 0);
            survivor.addFoodToInventory(Food.BAKEDBEANS);
            survivor.addFoodToInventory(Food.DRIEDFRUIT);
            survivor.addFoodToInventory(Food.IRNBRU);
            survivor.addMeleeToInventory(Melee.KNIFE);
            survivor.setAmmoInventory(8);
        } else {
            System.out.println("Invalid command.");
        }
//        return survivor;
    }

    public static int zombieAttack(Survivor survivor, Zombie zombie) {
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

    public static void foodDrop(Survivor survivor) {
        Random rand = new Random();
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
    }

    public static void weaponDrop(Survivor survivor, Zombie zombie) {
        Random rand = new Random();

        int gunDropChance = 30;
        int knifeDropChance = 40;

        int bulletDropChance1 = 30;
        int bulletDropChance2 = 50;
        int bulletDropChance3 = 60;

        if (rand.nextInt(100) < gunDropChance && survivor.getGunInventory().size() == 0) {
            survivor.addGunToInventory(Gun.HANDGUN);
            System.out.println("'The Zed-Head had a gun! That's mine now.'");
        } else if (rand.nextInt(100) < knifeDropChance && survivor.getMeleeInventory().size() == 0) {
            survivor.addMeleeToInventory(Melee.KNIFE);
            System.out.println("'That's one sweet looking knife there, don't mind if I do!'");
        } else if (rand.nextInt(100) < bulletDropChance1 && survivor.getAmmoInventory() > 3  ) {
            survivor.addToAmmoInventory(3);
            System.out.println("A magazine with 3 bullets fell from the " + zombie.getName() + " as it hit the ground");
            if (survivor.getAmmoInventory() == 0) {
                System.out.println("'Phew I was all out, thank you bullet fairy!'");
            } else {
                System.out.println("'Now thats what I call luck!'");
            }
            System.out.println("You now have " + survivor.getAmmoInventory() + " bullets");
        } else if (rand.nextInt(100) < bulletDropChance2 && survivor.getAmmoInventory() > 4  ) {
            survivor.addToAmmoInventory(2);
            System.out.println("2 bullets rolled out of the " + zombie.getName() + "'s pocket");
            if (survivor.getAmmoInventory() == 0){
                System.out.println("'Score, I know where I'm going to put these...'");
            } else {
                System.out.println("'Thanks buddy!'");
            }
            System.out.println("You now have " + survivor.getAmmoInventory() + " bullets");
        } else if (rand.nextInt(100) < bulletDropChance3 && survivor.getAmmoInventory() > 5  ) {
            survivor.addToAmmoInventory(1);
            System.out.println("1 bullet rolled out of the " + zombie.getName() + "'s pocket");
            if (survivor.getAmmoInventory() == 0){
                System.out.println("'This will buy me one more chance...'");
            } else {
                System.out.println("'Every bullet counts out here now.'");
            }
            System.out.println("You now have " + survivor.getAmmoInventory() + " bullets");
        }
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

    public static void zombieAppears(Zombie zombie) {
        System.out.println("A " + zombie.getName() + " is blocking your way!");
    }

    public static void zombieDeathLoop(Survivor survivor, Zombie zombie) {
        while (survivor.getSurvivorHealth() > 0) {
            zombieAppears(zombie);
            fightZombie(survivor, zombie);
        }
        sceneOne(survivor, zombie);
    }

    public static int fightZombie (Survivor survivor, Zombie zombie){
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

                    String attackInput = in.nextLine();

                    if (attackInput.equals("1")) {
                        zombieAttack(survivor, zombie);
                        if (survivor.getSurvivorHealth() < 1) {
                            System.out.println("You have taken too much damage to go on. \n" +
                                    "Welcome to the army of the Dead, you dumb-ass");
                            sceneOne(survivor, zombie);
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
                        zombieAttack(survivor, zombie);
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
                        zombieAttack(survivor, zombie);
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
                    System.out.println("What are you going to have?");
                    System.out.println("1. Baked Beans (20 HP value)");
                    System.out.println("2. Dried fruit (10 HP value)");
                    System.out.println("3. Can of Irn-Bru (5 HP value)");

                    String foodInput = in.nextLine();

                    if (foodInput.equals("1")) {
                        if (survivor.getFoodInventory().contains(Food.BAKEDBEANS)) {
                            survivor.setSurvivorHealth(survivor.getSurvivorHealth() + Food.BAKEDBEANS.getRestore());
                            if (survivor.getSurvivorHealth() > SurvivorLevel.OUTCAST.getHP()) {
                                survivor.setSurvivorHealthMax();
                            }
                            survivor.getFoodInventory().remove(Food.BAKEDBEANS);
                            survivor.HPRestoresUsed++;
                            System.out.println("Your health has been restored by " + Food.BAKEDBEANS.getRestore() + ".");
                            if (!survivor.getFoodInventory().contains(Food.BAKEDBEANS)) {
                                System.out.println("That was the last can!");
                            }
                        } else {
                            System.out.println("... Awkward. You don't have any.");
                        }
                    } else if (foodInput.equals("2")) {
                        if (survivor.getFoodInventory().contains(Food.DRIEDFRUIT)) {
                            survivor.setSurvivorHealth(survivor.getSurvivorHealth() + Food.DRIEDFRUIT.getRestore());
                            if (survivor.getSurvivorHealth() > SurvivorLevel.OUTCAST.getHP()) {
                                survivor.setSurvivorHealthMax();
                            }
                            survivor.getFoodInventory().remove(Food.DRIEDFRUIT);
                            survivor.HPRestoresUsed++;
                            System.out.println("Your health has been restored by " + Food.DRIEDFRUIT.getRestore() + ".");
                            if (!survivor.getFoodInventory().contains(Food.DRIEDFRUIT)) {
                                System.out.println("That was the last packet!");
                            }
                        } else {
                            System.out.println("... Awkward. You don't have any.");
                        }
                    } else if (foodInput.equals("3")) {
                        if (survivor.getFoodInventory().contains(Food.IRNBRU)) {
                            survivor.setSurvivorHealth(survivor.getSurvivorHealth() + Food.IRNBRU.getRestore());
                            if (survivor.getSurvivorHealth() > SurvivorLevel.OUTCAST.getHP()) {
                                survivor.setSurvivorHealthMax();
                            }
                            survivor.getFoodInventory().remove(Food.IRNBRU);
                            survivor.HPRestoresUsed++;
                            System.out.println("Your health has been restored by " + Food.IRNBRU.getRestore() + ".");
                            if (!survivor.getFoodInventory().contains(Food.IRNBRU)) {
                                System.out.println("That was the last can!");
                            }
                        } else {
                        System.out.println("... Awkward. You don't have any.");
                        }
                    } else {
                        System.out.println("Invalid command.");
                    }
                } else if (input.equals("3")) {
                    if (zombieSpeed < SurvivorLevel.OUTCAST.getSpeed()) {
                        System.out.println("You run away from the " + zombie.getName() + "!");
                        continue GAME;
                    } else {
                        System.out.println("Cannot escape! Are you going to be zombie dinner!?");
                    }
                } else {
                    System.out.println("Invalid command.");
                }
            }
            System.out.println("------------------------------");
            System.out.println("The " + zombie.getName() + " was defeated!");
            survivor.zombiesEncountered++;
            foodDrop(survivor);
            weaponDrop(survivor, zombie);

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

    public static void sceneOne(Survivor survivor, Zombie zombie) {
        System.out.println("There is a fork in the road, do you go: \n" +
                "1. To the left, or \n" +
                "2. Take the right?");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        if (input.equals("1")) {
            sceneTwo(survivor, zombie);
        }
        else if (input.equals("2")) {
            sceneThree(survivor, zombie);
        }
    }

    public static void sceneTwo(Survivor survivor, Zombie zombie) {
        System.out.println("You come across an abandoned campsite. Do you: \n" +
                "1. Do you stop to check for loot, or \n" +
                "2. Keep moving?");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        if (input.equals("1")) {
            sceneFour(survivor, zombie);
        }
        else if (input.equals("2")) {
            sceneFive(survivor, zombie);
        }
    }

    public static void sceneThree(Survivor survivor, Zombie zombie) {
        System.out.println("Oh no! A " + zombie.getName() + "lurches out from behind the tent! Do you: \n" +
                "1. Fight your way past, or \n" +
                "2. Attempt to flee?");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        if (input.equals("1")) {
            GameLogic.fightZombie(survivor, zombie);
            sceneSix(survivor, zombie);
        }
        else if (input.equals("2")) {
            sceneFive(survivor, zombie);
        }
    }

    public static void sceneFour(Survivor survivor, Zombie zombie) {
        System.out.println("Score! A gun, some loose bullets and more food! \n +" +
                "What happened to the people that left these?");
        survivor.addGunToInventory(Gun.HANDGUN);
        survivor.setAmmoInventory(4);
        survivor.addFoodToInventory(Food.BAKEDBEANS);
        survivor.addFoodToInventory(Food.DRIEDFRUIT);
        inventoryCheck(survivor);
        System.out.println("You step out of the tent and a " + zombie.getName() + "lurches at you!");
        GameLogic.fightZombie(survivor, zombie);
        sceneSeven(survivor, zombie);
    }

    public static void sceneFive(Survivor survivor, Zombie zombie) {
        System.out.println("You trip! Is that a legless " + zombie.getName() + "?!");
        GameLogic.fightZombie(survivor, zombie);
        sceneSeven(survivor, zombie);
    }

    public static void sceneSix(Survivor survivor, Zombie zombie) {
        System.out.println("The " + zombie.getName() + " has a back pack on, must have been someone else seeking shelter in the woods. \n" +
                "A gun, 2 bullets and some food. They don't need this stuff anymore...");
        survivor.addGunToInventory(Gun.HANDGUN);
        survivor.setAmmoInventory(2);
        survivor.addFoodToInventory(Food.IRNBRU);
        survivor.addFoodToInventory(Food.DRIEDFRUIT);
        inventoryCheck(survivor);
        sceneEight(survivor, zombie);
    }

    public static void sceneSeven(Survivor survivor, Zombie zombie) {
        System.out.println("Light reflects off some glass in the bushes. \n" +
                "is it a hut? Could you finally have found shelter?");
    }

    public static void sceneEight(Survivor survivor, Zombie zombie) {

    }







}
