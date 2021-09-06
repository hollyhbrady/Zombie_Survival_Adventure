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

    public static void gameStartWanderer(Survivor survivor) {
        if (survivor.getSurvivorLevel() == SurvivorLevel.WANDERER) {
            survivor.setAmmoInventory(0);
            survivor.emptyFoodInventory();
            survivor.addFoodToInventory(Food.BAKEDBEANS);
            survivor.addFoodToInventory(Food.BAKEDBEANS);
            survivor.addFoodToInventory(Food.DRIEDFRUIT);
            survivor.addFoodToInventory(Food.DRIEDFRUIT);
            survivor.addFoodToInventory(Food.DRIEDFRUIT);
            survivor.addFoodToInventory(Food.IRNBRU);
            survivor.emptyGunInventory();
            survivor.emptyMeleeInventory();
            survivor.addMeleeToInventory(Melee.KNIFE);

            System.out.println("You're running through the woods. \n" +
                    "You're well stocked in food from your last raid, \n" +
                    "but you have been on the move without a chance to sleep in a long time...\n" +
                    "Was that a moan? And the shuffle drag of zombie feet?");

            areYouReady(survivor);
        }
    }

    public static void gameStartOutcast(Survivor survivor) {
        if (survivor.getSurvivorLevel() == SurvivorLevel.OUTCAST) {
            survivor.setAmmoInventory(8);
            survivor.emptyFoodInventory();
            survivor.addFoodToInventory(Food.BAKEDBEANS);
            survivor.addFoodToInventory(Food.DRIEDFRUIT);
            survivor.addFoodToInventory(Food.IRNBRU);
            survivor.emptyGunInventory();
            survivor.emptyMeleeInventory();
            survivor.addMeleeToInventory(Melee.KNIFE);

            System.out.println("You're stumbling through the woods. \n" +
                    "You hear a moan - the shuffle drag of zombie feet. \n" +
                    "You can't go much longer without sleep...");

            areYouReady(survivor);
        }
    }

    public static void gameStartSoldier(Survivor survivor) {
        if (survivor.getSurvivorLevel() == SurvivorLevel.SOLDIER) {
            survivor.setAmmoInventory(0);
            survivor.emptyFoodInventory();
            survivor.addFoodToInventory(Food.BAKEDBEANS);
            survivor.addFoodToInventory(Food.DRIEDFRUIT);
            survivor.addFoodToInventory(Food.IRNBRU);
            survivor.emptyGunInventory();
            survivor.addGunToInventory(Gun.HANDGUN);
            survivor.emptyMeleeInventory();
            survivor.addMeleeToInventory(Melee.KNIFE);

            System.out.println("You're stumbling through the woods. \n" +
                    "You're out of bullets and getting desperate. \n" +
                    "You hear a moan - the shuffle drag of zombie feet. \n" +
                    "Are you still being pursued by the zombies that finished off your unit?");

            areYouReady(survivor);
        }
    }

    public static void areYouReady(Survivor survivor) {
        System.out.println("Are you ready to fight for your life " + survivor.getName() + "? \n" +
                "1. Let me at 'em! \n" +
                "2. Do I have a choice here?");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Choosing an invalid option isn't going to get you out of this...");
        }
        if (input.equals("1")) {
            System.out.println("That's the spirit!\n" +
                    "You can have some extra bullets to take more down.");
            survivor.setAmmoInventory(survivor.getAmmoInventory() + 3);
        }
        if (input.equals("2")) {
            System.out.println("Actually you don't, but you can have some extra food to make it up to you...\n" +
                    "Do your best so you can survive to eat it!\n" +
                    "I hope you like beans and IrnBru...");
            survivor.addFoodToInventory(Food.BAKEDBEANS);
            survivor.addFoodToInventory(Food.IRNBRU);
        }

    }

    public static void gameStartStatsAnnouncementFood(Survivor survivor) {
        if (survivor.getFoodInventory().size() == 1) {
            System.out.println("1 food item to restore health,");
        }
        else if (survivor.getFoodInventory().size() == 0) {
            System.out.println("No food items to restore health,");
        }
        else System.out.println(survivor.getFoodInventory().size() + " food items to restore health,");
    }

    public static void gameStartStatsAnnouncementKnife(Survivor survivor) {
        if (survivor.getMeleeInventory().size() == 1) {
            System.out.println("1 knife,");
        }
        else if (survivor.getMeleeInventory().size() == 0) {
            System.out.println("No knives,");
        }
        else System.out.println(survivor.getMeleeInventory().size() + " knives,");
    }

    public static void gameStartStatsAnnouncementGun(Survivor survivor) {
        if (survivor.getGunInventory().size() == 1) {
            System.out.println("1 gun,");
        }
        else if (survivor.getGunInventory().size() == 0) {
            System.out.println("no gun,");
        }
        else System.out.println(survivor.getGunInventory().size() + " guns,");
    }

    public static void gameStartStatsAnnouncementBullets(Survivor survivor) {
        if (survivor.getAmmoInventory() == 1) {
            System.out.println("And 1 bullet.");
        }
        else if (survivor.getAmmoInventory() == 0) {
            System.out.println("And no bullets.");
        }
        else System.out.println("And " + survivor.getAmmoInventory() + " bullets.");
    }

    public static void inventoryAnnouncement(Survivor survivor) {
        System.out.println("You have:");
        gameStartStatsAnnouncementFood(survivor);
        gameStartStatsAnnouncementKnife(survivor);
        gameStartStatsAnnouncementGun(survivor);
        gameStartStatsAnnouncementBullets(survivor);
    }

    public static void gameStart(Survivor survivor) {
        resetToLevel1(survivor);
        survivor.setSurvivorHealthMax();
//        survivor.setZombiesEncountered(0);
        survivor.setHPRestoresUsed(0);
        survivor.setGunUsed(0);
        survivor.setMeleeUsed(0);
        survivor.setDayCount(0);
        setCharacter(survivor);
        gameStartWanderer(survivor);
        gameStartOutcast(survivor);
        gameStartSoldier(survivor);
//        inventoryAnnouncement(survivor);
    }

    public static void whatIsYourName(Survivor survivor) {
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        survivor.setName(name);

        confirmName(survivor);
    }

    public static void confirmName(Survivor survivor) {
        System.out.println("Your name is " + survivor.getName() + "? \n" +
                "1. Yes \n" +
                "2. No");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("2")) {
            whatIsYourName(survivor);
        }
    }

    public static void chooseCharacterType(Survivor survivor) {
        System.out.println("Hello Survivor. \n" +
                "Welcome to your adventure. \n" +
                "Who are you?");
        System.out.println("1. A Soldier \n" +
                "\t *Higher accuracy with a gun");
        System.out.println("2. A Wanderer \n" +
                "\t *Higher strength and speed");
        System.out.println("3. An Outcast \n" +
                "\t *Higher accuracy with a knife");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2") && !input.equals("3")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("1")) {
            survivor.setSurvivorLevel(SurvivorLevel.SOLDIER);
        } else if (input.equals("2")) {
            survivor.setSurvivorLevel(SurvivorLevel.WANDERER);
        } else if (input.equals("3")) {
            survivor.setSurvivorLevel(SurvivorLevel.OUTCAST);
        }

        confirmCharacterType(survivor);
    }

    public static void confirmCharacterType (Survivor survivor) {
        if (survivor.survivorLevel == SurvivorLevel.SOLDIER) {
            System.out.println("Are you sure you are a Soldier?\n" +
                    "1. Yes \n" +
                    "2. No");
        } else if (survivor.survivorLevel == SurvivorLevel.WANDERER) {
            System.out.println("Are you sure you are a Wanderer?\n" +
                    "1. Yes \n" +
                    "2. No");
        } else {
            System.out.println("Are you sure you are an Outcast?\n" +
                    "1. Yes \n" +
                    "2. No");
        }

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("2")) {
            chooseCharacterType(survivor);
        }
    }

    public static void setCharacter(Survivor survivor) {
        chooseCharacterType(survivor);
        whatIsYourName(survivor);
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

    public static void dropBeans(Survivor survivor) {
        survivor.addFoodToInventory(Food.BAKEDBEANS);
        System.out.println("It dropped a can of baked beans!");
        if (survivor.getFoodInventory().size() > 4){
            System.out.println("'Some variety would be nice, but you can't be fussy at times like these.'");
        } else {
            System.out.println("'Protein! This should help me get through til tomorrow at least....'");
        }
    }

    public static void dropFruit(Survivor survivor) {
        survivor.addFoodToInventory(Food.DRIEDFRUIT);
        System.out.println("It dropped a pack of dried fruit!");
        if (survivor.getFoodInventory().size() > 4){
            System.out.println("'Great more apricots, I'm sure I can pick of the uh... undead bits.'");
        } else {
            System.out.println("'I better make these last, I don't want a repeat of last time I ate the whole bag all at once.'");
        }
    }

    public static void dropIrnBru(Survivor survivor) {
        survivor.addFoodToInventory(Food.IRNBRU);
        System.out.println("It dropped a can of ... Irn-Bru. Again!?");
        if (survivor.getFoodInventory().size() > 4){
            System.out.println("'I'll take what I can get! What I wouldn't give for a coke though...'");
        } else {
            System.out.println("'Oh well, beggars can't be choosers.'");
        }
    }

    public static void reportFoodCount(Survivor survivor) {
        System.out.println("You now have " + survivor.getFoodInventory().size() + " food items");
    }

    public static void foodDrop(Survivor survivor) {
        Random rand = new Random();
        int foodDropChance = 30;
        if (rand.nextInt(100) < foodDropChance) {
            dropBeans(survivor);
            reportFoodCount(survivor);
        } else if (rand.nextInt(100) < foodDropChance) {
            dropFruit(survivor);
            reportFoodCount(survivor);
        } else if (rand.nextInt(100) < foodDropChance) {
            dropIrnBru(survivor);
            reportFoodCount(survivor);
        }
    }

    public static void dropGun(Survivor survivor) {
        survivor.addGunToInventory(Gun.HANDGUN);
        System.out.println("'The Zed-Head had a gun! That's mine now.'");
    }

    public static void dropKnife(Survivor survivor) {
        survivor.addMeleeToInventory(Melee.KNIFE);
        System.out.println("'That's one sweet looking knife there, don't mind if I do!'");
    }

    public static void drop6Bullets(Survivor survivor, Zombie zombie) {
        survivor.addToAmmoInventory(6);
        System.out.println("A full magazine fell from the " + zombie.getName() + "'s belt during the fight! That means 6 bullets!");
        if (survivor.getAmmoInventory() == 0) {
            System.out.println("'Phew I was all out, this will last me a while.'");
        } else {
            System.out.println("'It's raining bullets! But in a good way...'");
        }
        reportBulletCount(survivor);
    }

    public static void drop5Bullets(Survivor survivor, Zombie zombie) {
        survivor.addToAmmoInventory(5);
        System.out.println("A magazine with 5 bullets fell from the " + zombie.getName() + "'s belt during the fight!");
        if (survivor.getAmmoInventory() == 0) {
            System.out.println("'Phew I was all out, this will last me a while.'");
        } else {
            System.out.println("'These Zed Heads better watch out!'");
        }
        reportBulletCount(survivor);
    }

    public static void drop4Bullets(Survivor survivor, Zombie zombie) {
        survivor.addToAmmoInventory(4);
        System.out.println("A magazine with 4 bullets fell from the " + zombie.getName() + " as it hit the ground.");
        if (survivor.getAmmoInventory() == 0) {
            System.out.println("'Phew I was all out, this will last me a while.'");
        } else {
            System.out.println("'Is my luck turning?'");
        }
        reportBulletCount(survivor);
    }

    public static void drop3Bullets(Survivor survivor, Zombie zombie) {
        survivor.addToAmmoInventory(3);
        System.out.println("A magazine with 3 bullets fell from the " + zombie.getName() + " as it hit the ground.");
        if (survivor.getAmmoInventory() == 0) {
            System.out.println("'Phew I was all out, thank you bullet fairy!'");
        } else {
            System.out.println("'Now that's what I call luck!'");
        }
        reportBulletCount(survivor);
    }

    public static void drop2Bullets(Survivor survivor, Zombie zombie) {
        survivor.addToAmmoInventory(2);
        System.out.println("2 bullets rolled out of the " + zombie.getName() + "'s pocket.");
        if (survivor.getAmmoInventory() == 0){
            System.out.println("'Score, I know where I'm going to put these...'");
        } else {
            System.out.println("'Thanks buddy!'");
        }
        reportBulletCount(survivor);
    }
    public static void drop1Bullet(Survivor survivor, Zombie zombie) {
        survivor.addToAmmoInventory(1);
        System.out.println("1 bullet rolled out of the " + zombie.getName() + "'s pocket.");
        if (survivor.getAmmoInventory() == 0){
            System.out.println("'This will buy me one more chance...'");
        } else {
            System.out.println("'Every bullet counts out here now.'");
        }
        reportBulletCount(survivor);
    }

    public static void reportBulletCount(Survivor survivor) {
        if (survivor.getAmmoInventory() == 1) {
            System.out.println("You now have 1 bullet");
        } else {
            System.out.println("You now have " + survivor.getAmmoInventory() + " bullets.");
        }
    }

    public static void weaponDrop(Survivor survivor, Zombie zombie) {
        Random rand = new Random();

        int gunDropChance = 30;
        int knifeDropChance = 40;

        if (rand.nextInt(100) < gunDropChance && survivor.getGunInventory().size() == 0) {
            dropGun(survivor);
        } else if (rand.nextInt(100) < knifeDropChance && survivor.getMeleeInventory().size() == 0) {
            dropKnife(survivor);
        }

        int bulletDropChance10 = 10;
        int bulletDropChance20 = 20;
        int bulletDropChance40 = 40;
        int bulletDropChance60 = 60;
        int bulletDropChance80 = 80;
        int bulletDropChance90 = 90;

        // If less that 2 bullets
        if (rand.nextInt(100) < bulletDropChance10 && survivor.getAmmoInventory() < 2) {
            drop1Bullet(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance20 && survivor.getAmmoInventory() < 2) {
            drop2Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance40 && survivor.getAmmoInventory() < 2) {
            drop3Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance60 && survivor.getAmmoInventory() < 2) {
            drop4Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance80 && survivor.getAmmoInventory() < 2) {
            drop5Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance90 && survivor.getAmmoInventory() < 2) {
            drop6Bullets(survivor, zombie);
        }

        // If less than 3 bullets
        else if (rand.nextInt(100) < bulletDropChance10 && survivor.getAmmoInventory() < 3) {
            drop1Bullet(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance20 && survivor.getAmmoInventory() < 3) {
            drop2Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance40 && survivor.getAmmoInventory() < 3) {
            drop3Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance60 && survivor.getAmmoInventory() < 3) {
            drop4Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance80 && survivor.getAmmoInventory() < 3) {
            drop5Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance80 && survivor.getAmmoInventory() < 3) {
            drop6Bullets(survivor, zombie);
        }

        // If less than 4 bullets
        else if (rand.nextInt(100) < bulletDropChance10 && survivor.getAmmoInventory() < 4) {
            drop1Bullet(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance20 && survivor.getAmmoInventory() < 4) {
            drop2Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance20 && survivor.getAmmoInventory() < 4) {
            drop3Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance40 && survivor.getAmmoInventory() < 4) {
            drop4Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance60 && survivor.getAmmoInventory() < 4) {
            drop5Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance80 && survivor.getAmmoInventory() < 4) {
            drop6Bullets(survivor, zombie);
        }

        // If less than 5 bullets
        else if (rand.nextInt(100) < bulletDropChance20 && survivor.getAmmoInventory() < 5) {
            drop1Bullet(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance20 && survivor.getAmmoInventory() < 5) {
            drop2Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance20 && survivor.getAmmoInventory() < 5) {
            drop3Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance20 && survivor.getAmmoInventory() < 5) {
            drop4Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance40 && survivor.getAmmoInventory() < 5) {
            drop5Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance60 && survivor.getAmmoInventory() < 5) {
            drop6Bullets(survivor, zombie);
        }

        // If less than 6 bullets
        else if (rand.nextInt(100) < bulletDropChance40 && survivor.getAmmoInventory() < 6) {
            drop1Bullet(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance40 && survivor.getAmmoInventory() < 6) {
            drop2Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance40 && survivor.getAmmoInventory() < 6) {
            drop3Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance20 && survivor.getAmmoInventory() < 6) {
            drop4Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance20 && survivor.getAmmoInventory() < 6) {
            drop5Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance20 && survivor.getAmmoInventory() < 6) {
            drop6Bullets(survivor, zombie);
        }

        // If 6 or more bullets
        else if (rand.nextInt(100) < bulletDropChance90) {
            drop1Bullet(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance80) {
            drop2Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance60) {
            drop3Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance40) {
            drop4Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance20) {
            drop5Bullets(survivor, zombie);
        } else if (rand.nextInt(100) < bulletDropChance10) {
            drop6Bullets(survivor, zombie);
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

    public static void survivorExpIncreaseByZombieStrength(Survivor survivor, int expFromZombie) {
        survivor.setExpGained(survivor.getExpGained() + expFromZombie);
    }

    public static void survivorLevelUpCheck(Survivor survivor, int expFromZombie) {
        survivorExpIncreaseByZombieStrength(survivor, expFromZombie);
        survivorLevelUpCheckOutcast(survivor);
        survivorLevelUpCheckWanderer(survivor);
        survivorLevelUpCheckSoldier(survivor);
    }

    public static void survivorLevelUpCheckOutcast(Survivor survivor) {
        if (survivor.getSurvivorLevel() == SurvivorLevel.OUTCAST && survivor.getZombiesEncountered() >= 10) {
            reachLevel2Outcast(survivor);
        }
        if (survivor.getSurvivorLevel() == SurvivorLevel.OUTCASTTWO &&survivor.getZombiesEncountered() >= 20) {
            reachLevel3Outcast(survivor);
        }
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

    public static void survivorLevelUpCheckWanderer(Survivor survivor) {
        if (survivor.getSurvivorLevel() == SurvivorLevel.WANDERER && survivor.getZombiesEncountered() >= 5) {
            reachLevel2Wanderer(survivor);
        }
        if (survivor.getSurvivorLevel() == SurvivorLevel.OUTCASTTWO &&survivor.getZombiesEncountered() >= 15) {
            reachLevel3Wanderer(survivor);
        }
    }

    public static void reachLevel2Wanderer(Survivor survivor) {
        survivor.setSurvivorLevel(SurvivorLevel.WANDERERTWO);
        System.out.println("Woah, you've survived a lot of zombies. \n" +
                "Are you feeling it? Cause you are faster, stronger and that accuracy is way better! \n" +
                "Well done for making it to Level Two.");
    }

    public static void reachLevel3Wanderer(Survivor survivor) {
        survivor.setSurvivorLevel(SurvivorLevel.WANDERERTHREE);
        System.out.println("Woah, you've survived a lot of zombies. \n" +
                "Are you feeling it? Cause you are faster, stronger and that accuracy on point! \n" +
                "Well done for making it to Level Three. ");
    }

    public static void survivorLevelUpCheckSoldier(Survivor survivor) {
        if (survivor.getSurvivorLevel() == SurvivorLevel.SOLDIER && survivor.getZombiesEncountered() >= 10) {
            reachLevel2Soldier(survivor);
        }
        if (survivor.getSurvivorLevel() == SurvivorLevel.SOLDIERTWO &&survivor.getZombiesEncountered() >= 20) {
            reachLevel3Soldier(survivor);
        }
    }

    public static void reachLevel2Soldier(Survivor survivor) {
        survivor.setSurvivorLevel(SurvivorLevel.SOLDIERTWO);
        System.out.println("Woah, you've survived a lot of zombies. \n" +
                "Are you feeling it? Cause you are faster, stronger and that accuracy is way better! \n" +
                "Well done for making it to Level Two.");
    }

    public static void reachLevel3Soldier(Survivor survivor) {
        survivor.setSurvivorLevel(SurvivorLevel.SOLDIERTHREE);
        System.out.println("Woah, you've survived a lot of zombies. \n" +
                "Are you feeling it? Cause you are faster, stronger and that accuracy on point! \n" +
                "Well done for making it to Level Three. ");
    }

    public static void resetLevel1Outcast(Survivor survivor) {
        if (survivor.getSurvivorLevel() == SurvivorLevel.OUTCASTTWO) {
            survivor.setSurvivorLevel(SurvivorLevel.OUTCAST);
        }
        if (survivor.getSurvivorLevel() == SurvivorLevel.OUTCASTTHREE) {
            survivor.setSurvivorLevel(SurvivorLevel.OUTCAST);
        }
    }

    public static void resetLevel1Wanderer(Survivor survivor) {
        if (survivor.getSurvivorLevel() == SurvivorLevel.WANDERERTWO) {
            survivor.setSurvivorLevel(SurvivorLevel.WANDERER);
        }
        if (survivor.getSurvivorLevel() == SurvivorLevel.WANDERERTHREE) {
            survivor.setSurvivorLevel(SurvivorLevel.WANDERER);
        }
    }

    public static void resetLevel1Soldier(Survivor survivor) {
        if (survivor.getSurvivorLevel() == SurvivorLevel.SOLDIERTWO) {
            survivor.setSurvivorLevel(SurvivorLevel.SOLDIER);
        }
        if (survivor.getSurvivorLevel() == SurvivorLevel.SOLDIERTHREE) {
            survivor.setSurvivorLevel(SurvivorLevel.SOLDIER);
        }
    }

    public static void resetToLevel1(Survivor survivor) {
        resetLevel1Outcast(survivor);
        resetLevel1Wanderer(survivor);
        resetLevel1Soldier(survivor);
    }

    public static void checkHealthDoesNotExceedMax(Survivor survivor) {
        if (survivor.getSurvivorHealth() > survivor.getSurvivorLevel().getMaxHP()) {
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

    public static void zombieLoop(Survivor survivor, Zombie zombie) {
        while (survivor.getSurvivorHealth() > 0) {
            System.out.println("There are too many " + zombie.getName() + "'s, I can't escape!");
            fightZombieTrapped(survivor, zombie);
        }
        SebsHadesLoop(survivor, zombie);
    }

    public static void SebsHadesLoop(Survivor survivor, Zombie zombie) {
        System.out.println("You have taken too much damage to go on. \n" +
                "Welcome to the Army of the Dead, dumb-ass.");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        gameStart(survivor);
        Scenes.sceneOne(survivor, zombie);
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

    public static void readyToMoveOn (Survivor survivor) {
        System.out.println("What do you want to do? \n" +
                "1. Check inventory, \n" +
                "2. Assess health or \n" +
                "3. Carry on");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2") && !input.equals("3")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("1")) {
            inventoryAnnouncement(survivor);
            readyToMoveOn(survivor);
        } else if (input.equals("2")) {
            healthCheck(survivor);
        }
    }

    public static void healthCheck (Survivor survivor) {
        if (survivor.getSurvivorHealth() < survivor.getSurvivorHealthMax()) {
            System.out.println("Your HP is: " + survivor.getSurvivorHealth() + ",\n" +
                    "Do you want to eat some food? \n" +
                    "1. Yes, or \n" +
                    "2. No");

            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            while(!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command");
                input = in.nextLine();
            }
            if (input.equals("1")) {
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
            }
            readyToMoveOn(survivor);
            System.out.println("------------------------------");
        }
    }

    // Standard fight zombie sequence. Can fight, eat, or try to run
    public static void fightZombie (Survivor survivor, Zombie zombie){
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
            int expFromZombie = zombieHealth;
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
                            SebsHadesLoop(survivor, zombie);
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
                            SebsHadesLoop(survivor, zombie);
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
                            SebsHadesLoop(survivor, zombie);
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
                survivorLevelUpCheck(survivor, expFromZombie);
                foodDrop(survivor);
                weaponDrop(survivor, zombie);
            }
            System.out.println("------------------------------");
            break;
        }
        readyToMoveOn(survivor);
    }

    // Running is not an option here
    public static void fightZombieTrapped (Survivor survivor, Zombie zombie){
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
            int expFromZombie = zombieHealth;
            int attackDamage = survivor.survivorLevel.getMaxStrength();

            while (zombieHealth > 0) {
                System.out.println("Your HP: " + survivor.getSurvivorHealth());
                System.out.println(zombie.getName() + "'s HP: " + zombieHealth);
                System.out.println("What would you like to do?");
                System.out.println("1. Attack");
                System.out.println("2. Restore energy");

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
                            SebsHadesLoop(survivor, zombie);
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
                            SebsHadesLoop(survivor, zombie);
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
                            SebsHadesLoop(survivor, zombie);
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
                } else {
                    System.out.println("Invalid command.");
                }
            }
            if (zombieHealth < 1) {
                System.out.println("------------------------------");
                System.out.println("You killed the " + zombie.getName() + "!");
                survivorLevelUpCheck(survivor, expFromZombie);
                foodDrop(survivor);
                weaponDrop(survivor, zombie);
            }
            System.out.println("------------------------------");
            break;
        }
        readyToMoveOn(survivor);
    }

    // eating (used to regain health) is not an option here
    public static void fightZombieRushed (Survivor survivor, Zombie zombie){
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
            int expFromZombie = zombieHealth;
            int zombieSpeed = rand.nextInt(zombie.getZLevel().getSpeed());
            int attackDamage = survivor.survivorLevel.getMaxStrength();

            while (zombieHealth > 0) {
                System.out.println("Your HP: " + survivor.getSurvivorHealth());
                System.out.println(zombie.getName() + "'s HP: " + zombieHealth);
                System.out.println("What would you like to do?");
                System.out.println("1. Attack");
                System.out.println("2. Run!");

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
                            SebsHadesLoop(survivor, zombie);
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
                            SebsHadesLoop(survivor, zombie);
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
                            SebsHadesLoop(survivor, zombie);
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
                survivorLevelUpCheck(survivor, expFromZombie);
                foodDrop(survivor);
                weaponDrop(survivor, zombie);
            }
            System.out.println("------------------------------");
            break;
        }
        readyToMoveOn(survivor);
    }

    public static void returnToHut(Survivor survivor, Zombie zombie) {
        System.out.println("------------------------------");
        System.out.println("You make it back to the hut safely. \n" +
                "Best try and sleep, things are always better in the morning... \n" +
                "unless of course you are stuck in zombie purgatory!");
        sleep(survivor);
        System.out.println("Time to get moving! Do you: \n" +
                "1. Explore to find safer shelter or \n" +
                "2. Scavenge the area for more supplies?");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("1")) {
            Scenes.sceneNineteen(survivor, zombie);
        }
        else if (input.equals("2")) {
            Scenes.sceneFifteen(survivor, zombie);
        }
    }

    public static void fightZombieRushedOrWanderer(Survivor survivor, Zombie zombie) {
        if (survivor.getSurvivorLevel() == SurvivorLevel.OUTCAST || survivor.getSurvivorLevel() ==SurvivorLevel.SOLDIER) {
            fightZombieRushed(survivor, zombie);
        } else {
            fightZombie(survivor, zombie);
        }
    }



}
