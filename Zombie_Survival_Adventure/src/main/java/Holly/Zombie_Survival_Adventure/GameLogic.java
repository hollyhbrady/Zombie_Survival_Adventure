package Holly.Zombie_Survival_Adventure;

import Holly.Zombie_Survival_Adventure.models.Survivor;
import Holly.Zombie_Survival_Adventure.models.SurvivorLevel;
import Holly.Zombie_Survival_Adventure.models.Zombie;
import Holly.Zombie_Survival_Adventure.models.loot.Gun;
import Holly.Zombie_Survival_Adventure.models.loot.Food;
import Holly.Zombie_Survival_Adventure.models.loot.Melee;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    public static void gameStart(Survivor survivor) {
        resetLevel1Outcast(survivor);
        survivor.setSurvivorHealthMax();
        survivor.setAmmoInventory(5);
        survivor.emptyFoodInventory();
        survivor.addFoodToInventory(Food.BAKEDBEANS);
        survivor.addFoodToInventory(Food.DRIEDFRUIT);
        survivor.addFoodToInventory(Food.IRNBRU);
        survivor.emptyGunInventory();
        survivor.emptyMeleeInventory();
        survivor.addMeleeToInventory(Melee.KNIFE);
        survivor.setZombiesEncountered(0);
        survivor.setHPRestoresUsed(0);
        survivor.setGunUsed(0);
        survivor.setMeleeUsed(0);
        System.out.println("You're stumbling through the woods. \n" +
                "You hear a moan - the shuffle drag of zombie feet. \n" +
                "You can't go much longer without sleep...");
        System.out.println("You have " + survivor.getFoodInventory().size() + " food items to restore health, "
                + survivor.getMeleeInventory().size() + " knife, " +
                survivor.getGunInventory().size() + " gun and " + survivor.getAmmoInventory() + " bullets.");
    }

    public static void inventoryCheck(Survivor survivor) {
        System.out.println("You have " + survivor.getFoodInventory().size() + " food item(s) to restore health, "
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

        while(!input.equals("1") && !input.equals("2") && !input.equals("3")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("1")) {
            Survivor survivor = new Survivor("Abby", 0, SurvivorLevel.SOLDIER, 50, 0, 0, 0, 0);
            survivor.addFoodToInventory(Food.BAKEDBEANS);
            survivor.addFoodToInventory(Food.DRIEDFRUIT);
            survivor.addFoodToInventory(Food.IRNBRU);
            survivor.addGunToInventory(Gun.HANDGUN);
            survivor.setAmmoInventory(5);
        } else if (input.equals("2")) {
            Survivor survivor = new Survivor("Joel", 0, SurvivorLevel.WANDERER, 50, 0, 0, 0, 0);
            survivor.addFoodToInventory(Food.BAKEDBEANS);
            survivor.addFoodToInventory(Food.DRIEDFRUIT);
            survivor.addFoodToInventory(Food.IRNBRU);
            survivor.addMeleeToInventory(Melee.KNIFE);
        } else if (input.equals("3")) {
            Survivor survivor = new Survivor("Allie", 0, SurvivorLevel.OUTCAST, 50, 0, 0, 0, 0);
            survivor.addFoodToInventory(Food.BAKEDBEANS);
            survivor.addFoodToInventory(Food.DRIEDFRUIT);
            survivor.addFoodToInventory(Food.IRNBRU);
            survivor.addMeleeToInventory(Melee.KNIFE);
            survivor.setAmmoInventory(8);
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
        int foodDropChance = 30;
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

        int bulletDropChance1 = 20;
        int bulletDropChance2 = 30;
        int bulletDropChance3 = 40;

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
                System.out.println("'Now that's what I call luck!'");
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

    public static void gunDegradation(Survivor survivor) {
        survivor.setGunUsed(survivor.getGunUsed() + 1);
        checkGunUses(survivor);
    }

    public static void checkGunUses(Survivor survivor) {
        if (survivor.getGunUsed() == Gun.HANDGUN.getUses()) {
            survivor.removeGunFromInventory(Gun.HANDGUN);
            survivor.setGunUsed(0);
            System.out.println("Oh no, my gun has jammed! Too much zombie guts. \n" +
                    "I better be more careful with the next one");
        }
    }

    public static void meleeDegradation(Survivor survivor) {
        survivor.setMeleeUsed(survivor.getMeleeUsed() + 1);
        checkMeleeUses(survivor);
    }

    public static void checkMeleeUses(Survivor survivor) {
        if (survivor.getMeleeUsed() >= Melee.KNIFE.getUses()) {

            Random rand = new Random();
            int meleeBluntChance = 50;

            if (rand.nextInt(100) < meleeBluntChance) {
                survivor.removeMeleeFromInventory(Melee.KNIFE);
                survivor.setMeleeUsed(0);
                System.out.println("Oh no, my knife is too blunt! Those zombie skulls are thick.... \n" +
                        "I better be more careful with the next one");
            }
        }
    }

    public static void survivorLevelUpCheck(Survivor survivor) {
        survivor.increaseZombieCountByOne();
        if (survivor.getZombiesEncountered() == 3) {
            reachLevel2Outcast(survivor);
        }
        if (survivor.getZombiesEncountered() == 5) {
            reachLevel3Outcast(survivor);
        }
    }

    public static void resetLevel1Outcast(Survivor survivor) {
        survivor.setSurvivorLevel(SurvivorLevel.OUTCAST);
    }

    public static void reachLevel2Outcast(Survivor survivor) {
        survivor.setSurvivorLevel(SurvivorLevel.OUTCASTTWO);
        System.out.println("Woah, you've survived a lot of zombies. \n" +
                "Are you feeling it? Cause you are faster, stronger and that accuracy is way better! \n" +
                "Well done for making it to Level Two.");
    }

    public static void reachLevel3Outcast(Survivor survivor) {
        survivor.setSurvivorLevel(SurvivorLevel.OUTCASTTHREE);
        System.out.println("Woah, you've survived a lot of zombies. \n" +
                "Are you feeling it? Cause you are faster, stronger and that accuracy on point! \n" +
                "Well done for making it to Level Three. ");
    }

    public static void checkHealthDoesNotExceedMax(Survivor survivor) {
        if (survivor.getSurvivorHealth() > survivor.getSurvivorLevel().getHP()) {
            survivor.setSurvivorHealthMax();
        }
    }

    public static void sleep(Survivor survivor) {
        survivor.setSurvivorHealth(survivor.getSurvivorHealth() * 2);
        checkHealthDoesNotExceedMax(survivor);
        System.out.println("Your health has doubled to " + survivor.getSurvivorHealth() + ".");
    }

    public static void zombieAppears(Survivor survivor, Zombie zombie) {
        System.out.println("A " + zombie.getName() + " is blocking your way!");
    }

    public static void zombieDeathLoop(Survivor survivor, Zombie zombie) {
        while (survivor.getSurvivorHealth() > 0) {
            zombieAppears(survivor, zombie);
            fightZombie(survivor, zombie);
        }
        GameLogic.gameStart(survivor);
        sceneOne(survivor, zombie);
    }

    public static void SebsHadesLoopOfHell(Survivor survivor, Zombie zombie) {
        System.out.println("You have taken too much damage to go on. \n" +
                "Welcome to the Army of the Dead, dumb-ass.");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        gameStart(survivor);
        sceneOne(survivor, zombie);
    }

    public static void eatBeans(Survivor survivor) {
        if (survivor.getFoodInventory().contains(Food.BAKEDBEANS)) {
            survivor.setSurvivorHealth(survivor.getSurvivorHealth() + Food.BAKEDBEANS.getRestore());
            checkHealthDoesNotExceedMax(survivor);
            survivor.getFoodInventory().remove(Food.BAKEDBEANS);
            survivor.HPRestoresUsed++;
            System.out.println("Your health has been restored by " + Food.BAKEDBEANS.getRestore() + ".");
            if (!survivor.getFoodInventory().contains(Food.BAKEDBEANS)) {
                System.out.println("That was the last can!");
            }
        } else {
            System.out.println("... Awkward. You don't have any.");
        }
    }

    public static void eatFruit(Survivor survivor) {
        if (survivor.getFoodInventory().contains(Food.DRIEDFRUIT)) {
            survivor.setSurvivorHealth(survivor.getSurvivorHealth() + Food.DRIEDFRUIT.getRestore());
            checkHealthDoesNotExceedMax(survivor);
            survivor.getFoodInventory().remove(Food.DRIEDFRUIT);
            survivor.HPRestoresUsed++;
            System.out.println("Your health has been restored by " + Food.DRIEDFRUIT.getRestore() + ".");
            if (!survivor.getFoodInventory().contains(Food.DRIEDFRUIT)) {
                System.out.println("That was the last packet!");
            }
        } else {
            System.out.println("... Awkward. You don't have any.");
        }
    }

    public static void drinkIrnBru(Survivor survivor) {
        if (survivor.getFoodInventory().contains(Food.IRNBRU)) {
            survivor.setSurvivorHealth(survivor.getSurvivorHealth() + Food.IRNBRU.getRestore());
            checkHealthDoesNotExceedMax(survivor);
            survivor.getFoodInventory().remove(Food.IRNBRU);
            survivor.HPRestoresUsed++;
            System.out.println("Your health has been restored by " + Food.IRNBRU.getRestore() + ".");
            if (!survivor.getFoodInventory().contains(Food.IRNBRU)) {
                System.out.println("That was the last can!");
            }
        } else {
            System.out.println("... Awkward. You don't have any.");
        }
    }

    public static int fightZombie (Survivor survivor, Zombie zombie){
        boolean running = true;
        Random rand = new Random();
        Scanner in = new Scanner(System.in);

        GAME:
        while(running) {
            System.out.println("------------------------------");

            int zombieHealth = rand.nextInt(zombie.getZLevel().getHP());
            if (zombieHealth < 5) {
                zombieHealth = 5;
            }
            int zombieSpeed = rand.nextInt(zombie.getZLevel().getSpeed());
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
                    System.out.println("3. Bare hands!");

                    String attackInput = in.nextLine();

                    if (attackInput.equals("1")) {
                        zombieAttack(survivor, zombie);
                        if (survivor.getSurvivorHealth() < 1) {
                            SebsHadesLoopOfHell(survivor, zombie);
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
                            gunDegradation(survivor);
                            System.out.println("You have " + survivor.getAmmoInventory() + " bullets left");
                        } else if (survivor.getGunInventory().size() > 0) {
                            System.out.println("You don't have any bullets left!");
                        } else {
                            System.out.println("You don't have a gun!");
                        }
                    } else if (attackInput.equals("2")) {
                        zombieAttack(survivor, zombie);
                        if (survivor.getSurvivorHealth() < 1) {
                            SebsHadesLoopOfHell(survivor, zombie);
                        }
                        if (survivor.getMeleeInventory().size() > 0) {
                            int damageDealt = (rand.nextInt(attackDamage) + Melee.KNIFE.getDamage());
                            if (rand.nextInt(100) < survivor.getSurvivorLevel().getMeleeAccuracy()) {
                                zombieHealth -= damageDealt;
                                meleeDegradation(survivor);
                                System.out.println("You slash the " + zombie.getName() + " for " + damageDealt + " damage.");
                            } else {
                                System.out.println("You take a swing and miss!");
                            }
                        } else {
                            System.out.println("You don't have a knife!");
                        }
                    } else if (attackInput.equals("3")) {
                        zombieAttack(survivor, zombie);
                        if (survivor.getSurvivorHealth() < 1) {
                            SebsHadesLoopOfHell(survivor, zombie);
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
                        eatBeans(survivor);
                    } else if (foodInput.equals("2")) {
                        eatFruit(survivor);
                    } else if (foodInput.equals("3")) {
                        drinkIrnBru(survivor);
                    } else {
                        System.out.println("Invalid command.");
                    }
                } else if (input.equals("3")) {
                    if (zombieSpeed < SurvivorLevel.OUTCAST.getSpeed()) {
                        System.out.println("You successfully run away!");
                        break;
                    } else {
                        System.out.println("This one is fast, you can't escape! Are you going to be zombie dinner!?");
                    }
                } else {
                    System.out.println("Invalid command.");
                }
            }
            if (zombieHealth < 1) {
                System.out.println("------------------------------");
                System.out.println("You killed the " + zombie.getName() + "!");
                survivorLevelUpCheck(survivor);
                foodDrop(survivor);
                weaponDrop(survivor, zombie);
                inventoryCheck(survivor);
            }
            System.out.println("------------------------------");
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
        zombieAppears(survivor, zombie);
        fightZombie(survivor, zombie);
        System.out.println("There is a fork in the road, do you go: \n" +
                "1. To the left, or \n" +
                "2. Take the right?");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
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

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("1")) {
            sceneFour(survivor, zombie);
        }
        else if (input.equals("2")) {
            sceneFive(survivor, zombie);
        }
    }

    public static void sceneThree(Survivor survivor, Zombie zombie) {
        System.out.println("Oh no! A " + zombie.getName() + " lurches out from behind bushes to your left! Do you: \n" +
                "1. Fight your way past, or \n" +
                "2. Attempt to flee?");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("1")) {
            fightZombie(survivor, zombie);
            sceneSix(survivor, zombie);
        }
        else if (input.equals("2")) {
            System.out.println("Phew you escaped!" +
                    "But wait....");
            sceneFive(survivor, zombie);
        }
    }

    public static void sceneFour(Survivor survivor, Zombie zombie) {
        System.out.println("Score! A gun, some loose bullets and more food in the tent! \n" +
                "What happened to the people that left these?");
        survivor.addGunToInventory(Gun.HANDGUN);
        survivor.addToAmmoInventory(4);
        survivor.addFoodToInventory(Food.BAKEDBEANS);
        survivor.addFoodToInventory(Food.DRIEDFRUIT);
        inventoryCheck(survivor);
        System.out.println("------------------------------");
        System.out.println("You step out of the tent and a " + zombie.getName() + " lurches at you!");
        fightZombie(survivor, zombie);
        sceneSeven(survivor, zombie);
    }

    public static void sceneFive(Survivor survivor, Zombie zombie) {
        System.out.println("You trip over a legless " + zombie.getName() + "!");
        fightZombie(survivor, zombie);
        sceneSeven(survivor, zombie);

    }

    public static void sceneSix(Survivor survivor, Zombie zombie) {
        System.out.println("The " + zombie.getName() + " has a back pack on, must have been someone else seeking shelter in the woods. \n" +
                "You search it and come up empty. Sucks to be you... \n" +
                "Wait, was that a branch snapping behind you?");
        fightZombie(survivor, zombie);
        sceneEight(survivor, zombie);
    }

    public static void sceneSeven(Survivor survivor, Zombie zombie) {
        System.out.println("You check your surroundings and see light reflecting off some glass in the bushes. \n" +
                "Is it a hut? Could you finally have found shelter? Do you: \n" +
                "1. Investigate, or \n" +
                "2. Stay in the open and carry on down the road");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("1")) {
            sceneNine(survivor, zombie);
        }
        else if (input.equals("2")) {
            sceneTen(survivor, zombie);
        }
    }

    public static void sceneEight(Survivor survivor, Zombie zombie) {
        System.out.println("The road sweeps off to the left, and you see light reflecting off some glass in the bushes ahead. Do you: \n" +
                "1. Investigate, or \n" +
                "2. Follow where the road leads");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("1")) {
            sceneSeven(survivor, zombie);
        }
        else if (input.equals("2")) {
            sceneTen(survivor, zombie);
        }
    }

    public static void sceneNine(Survivor survivor, Zombie zombie) {
        System.out.println("Its an abandoned hut! \n" +
                        "Or not so abandoned...");
        zombieAppears(survivor, zombie);
        fightZombie(survivor, zombie);
        System.out.println("You are not the only person who has been here, there are ashes from a fire on the ground. \n" +
                "Empty cans and crisp packets are strewn around. \n" +
                "The windows look like they have been smashed from the inside... \n" +
                "Desperate for sleep and shelter, you spend the night.");
        sleep(survivor);
        sceneEleven(survivor, zombie);
    }

    public static void sceneTen(Survivor survivor, Zombie zombie) {
        System.out.println("You follow the road and find a river of gently rotting bodies");
    }

    public static void sceneEleven(Survivor survivor, Zombie zombie) {
        System.out.println("------------------------------");
        System.out.println("In the morning light, you search the hut top to bottom. \n" +
                "You find food hidden under debris in the corner");
        survivor.addFoodToInventory(Food.BAKEDBEANS);
        survivor.addFoodToInventory(Food.IRNBRU);
        inventoryCheck(survivor);
        System.out.println("You cannot spend another night like that, do you: \n" +
                "1. Explore to find safer shelter or \n" +
                "2. Fortify your hut?");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("1")) {
            sceneTen(survivor, zombie);
        }
        else if (input.equals("2")) {
            sceneFifteen(survivor, zombie);
        }
    }

    public static void sceneTwelve(Survivor survivor, Zombie zombie) {

    }

    public static void sceneThirteen(Survivor survivor, Zombie zombie) {

    }

    public static void sceneFourteen(Survivor survivor, Zombie zombie) {

    }

    public static void sceneFifteen(Survivor survivor, Zombie zombie) {
        System.out.println("You venture down the road.");
    }



}
