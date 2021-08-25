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
                    "You're well stocked in food from your last raid, " +
                    "but you have been on the move without a chance to sleep in a long time...\n" +
                    "Was that a moan? And the shuffle drag of zombie feet?");
        }
    }

    public static void gameStartOutcast(Survivor survivor) {
        if (survivor.getSurvivorLevel() == SurvivorLevel.OUTCAST) {
            survivor.setAmmoInventory(5);
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
                    "You hear a moan - the shuffle drag of zombie feet." +
                    "Are you still being pursued by the zombies that finished off your unit?");
        }
    }

    public static void gameStartStatsAnnouncementKnife(Survivor survivor) {
        if (survivor.getMeleeInventory().size() == 1) {
            System.out.println("1 knife, ");
        }
        else if (survivor.getMeleeInventory().size() == 0) {
            System.out.println("no knives, ");
        }
        else System.out.println(survivor.getMeleeInventory().size() + " knives, ");
    }

    public static void gameStartStatsAnnouncementGun(Survivor survivor) {
        if (survivor.getGunInventory().size() == 1) {
            System.out.println("1 gun, ");
        }
        else if (survivor.getGunInventory().size() == 0) {
            System.out.println("no gun, ");
        }
        else System.out.println(survivor.getGunInventory().size() + " guns, ");
    }

    public static void gameStartStatsAnnouncementBullets(Survivor survivor) {
        if (survivor.getAmmoInventory() == 1) {
            System.out.println("and 1 bullet.");
        }
        else if (survivor.getAmmoInventory() == 0) {
            System.out.println("and no bullets.");
        }
        else System.out.println("and " + survivor.getAmmoInventory() + " bullets.");
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
        survivor.setZombiesEncountered(0);
        survivor.setHPRestoresUsed(0);
        survivor.setGunUsed(0);
        survivor.setMeleeUsed(0);
        gameStartWanderer(survivor);
        gameStartOutcast(survivor);
        gameStartSoldier(survivor);
        inventoryAnnouncement(survivor);
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
            Survivor survivor = new Survivor("Abby", 0, SurvivorLevel.SOLDIER, 50, 0, 0, 0, 0, 0);
            survivor.addFoodToInventory(Food.BAKEDBEANS);
            survivor.addFoodToInventory(Food.DRIEDFRUIT);
            survivor.addFoodToInventory(Food.IRNBRU);
            survivor.addGunToInventory(Gun.HANDGUN);
            survivor.setAmmoInventory(5);
        } else if (input.equals("2")) {
            Survivor survivor = new Survivor("Joel", 0, SurvivorLevel.WANDERER, 50, 0, 0, 0, 0, 0);
            survivor.addFoodToInventory(Food.BAKEDBEANS);
            survivor.addFoodToInventory(Food.DRIEDFRUIT);
            survivor.addFoodToInventory(Food.IRNBRU);
            survivor.addMeleeToInventory(Melee.KNIFE);
        } else if (input.equals("3")) {
            Survivor survivor = new Survivor("Allie", 0, SurvivorLevel.OUTCAST, 50, 0, 0, 0, 0, 0);
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

    public static void readyToMoveOn (Survivor survivor) {
        System.out.println("What do you want to do? \n" +
                "1. Check weapons, \n" +
                "2. Check health or \n" +
                "3. Carry on");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2") && !input.equals("3")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("1")) {

        } else if (input.equals("2")) {

        } else {

        }
    }

    public static void healthCheck (Survivor survivor) {
        if (survivor.getSurvivorHealth() < survivor.getSurvivorHealthMax()) {
            System.out.println("Your HP is: " + survivor.getSurvivorHealth() + ",\n" +
                    "Do you want to eat some food? \n" +
                    "1. Yes \n" +
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
            } else if (input.equals("2")) {

            }
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
        survivor.getSurvivorHealth();
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
        survivor.getSurvivorHealth();
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
        survivor.getSurvivorHealth();
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
            sceneNineteen(survivor, zombie);
        }
        else if (input.equals("2")) {
            sceneFifteen(survivor, zombie);
        }
    }

    public static void fightZombieRushedOrWanderer(Survivor survivor, Zombie zombie) {
        if (survivor.getSurvivorLevel() == SurvivorLevel.OUTCAST || survivor.getSurvivorLevel() ==SurvivorLevel.SOLDIER) {
            fightZombieRushed(survivor, zombie);
        } else {
            fightZombie(survivor, zombie);
        }
    }

    public static void sceneOne(Survivor survivor, Zombie zombie) {
        zombieAppears(survivor, zombie);
        fightZombieRushedOrWanderer(survivor, zombie);
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
        inventoryAnnouncement(survivor);
        System.out.println("------------------------------");
        System.out.println("You step out of the tent and a " + zombie.getName() + " lurches at you!");
        fightZombie(survivor, zombie);
        sceneSeven(survivor, zombie);
    }

    public static void sceneFive(Survivor survivor, Zombie zombie) {
        System.out.println("You trip over a legless " + zombie.getName() + "!");
        fightZombieRushedOrWanderer(survivor, zombie);
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
                "1. Sneak through the undergrowth towards it, or \n" +
                "2. Stay in the open and loop around to case the other side?");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("1")) {
            System.out.println("The tall grass ahead rustles.." +
                    "A " + zombie.getName() + " jumps out!");
            fightZombie(survivor, zombie);
            sceneNine(survivor, zombie);
        }
        else if (input.equals("2")) {
            sceneNineA(survivor, zombie);
        }
    }

    public static void sceneEight(Survivor survivor, Zombie zombie) {
        System.out.println("The road sweeps off to the left, and you see light reflecting off some glass in the bushes ahead. Do you: \n" +
                "1. Sneak through the undergrowth towards it, or \n" +
                "2. Stay in the open and loop around to case the other side?");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("1")) {
            System.out.println("The tall grass ahead rustles.." +
                    "A " + zombie.getName() + " jumps out!");
            fightZombie(survivor, zombie);
            sceneNine(survivor, zombie);
        }
        else if (input.equals("2")) {
            sceneNineA(survivor, zombie);
        }
    }

    public static void sceneNineA(Survivor survivor, Zombie zombie) {
        System.out.println("It's definitely a shelter of some kind, and it doesn't look like anyone is nearby... \n" +
                "I'm going in!");
        sceneNine(survivor, zombie);
    }

    public static void sceneNine(Survivor survivor, Zombie zombie) {
        System.out.println("Its an abandoned woodshed! \n" +
                        "Or not so abandoned...");
        zombieAppears(survivor, zombie);
        fightZombieTrapped(survivor, zombie);
        System.out.println("You are not the only person who has been here, there are ashes from a fire on the ground. \n" +
                "Empty cans and crisp packets are strewn around. \n" +
                "The windows look like they have been smashed from the inside... \n" +
                "Desperate for sleep and shelter, you spend the night.");
        sleep(survivor);
    }

    public static void sceneTen(Survivor survivor, Zombie zombie) {
        System.out.println("You follow the road and find a river of gently rotting bodies.\n" +
                "The wind changes and you can smell the sweet stench of their corpses. Do you:\n" +
                "1. Cross the river or \n" +
                "2. Follow the bank?");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("1")) {
            sceneTwelve(survivor, zombie);
        }
        else if (input.equals("2")) {
            sceneNineteen(survivor, zombie);
        }
    }

    public static void sceneElevenA(Survivor survivor, Zombie zombie) {
        System.out.println("Were those nightmares last night or was it" + zombie.getName() + "'s shuffling around the shed?! \n" +
                "You can't handle that again... But what will you do?" +
                "1. Explore to find safer shelter, or \n" +
                "2. Scavenge the area for more supplies?");

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

    public static void sceneEleven(Survivor survivor, Zombie zombie) {
        System.out.println("------------------------------");
        System.out.println("In the morning light, you search the hut top to bottom. \n" +
                "You find food hidden under debris in the corner");
        survivor.addFoodToInventory(Food.BAKEDBEANS);
        survivor.addFoodToInventory(Food.IRNBRU);
        inventoryAnnouncement(survivor);
        System.out.println("You cannot spend another night like that, do you: \n" +
                "1. Explore to find safer shelter, \n" +
                "2. Scavenge the area for more supplies, or \n" +
                "3. Rest up for the day to gain more health?");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2") && !input.equals("3")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("1")) {
            sceneTen(survivor, zombie);
        }
        else if (input.equals("2")) {
            sceneFifteen(survivor, zombie);
        }
        else if (input.equals("3")) {
            System.out.println("An extra day of rest was a good idea, you were so exhausted you managed to sleep another night.");
            sleep(survivor);
            sceneElevenA(survivor, zombie);
        }
    }

    public static void sceneTwelve(Survivor survivor, Zombie zombie) {
        System.out.println("You wade past the corpses, nudging a few out of your way...\n" +
                "The last one moves, it's still alive!");
        fightZombie(survivor, zombie);
        System.out.println("You drag yourself up the river bank and see a cop car parked nearby, \n" +
                "through the back window you can see an ammo stash! Do you:\n" +
                "1. Try and get the guns or" +
                "2. Carry on?");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("1")) {
            sceneThirteen(survivor, zombie);
        }
        else if (input.equals("2")) {
            sceneTwenty(survivor, zombie);
        }
    }

    public static void sceneThirteen(Survivor survivor, Zombie zombie) {
        System.out.println("The car is locked, so you break a back window and reach in for the gear.\n" +
                "A gun and 12 bullets. That's a score!");
        survivor.addGunToInventory(Gun.HANDGUN);
        survivor.addToAmmoInventory(12);
        inventoryAnnouncement(survivor);
        System.out.println("You put your new items away, but as you step away a hand grabs you from under the car. \n" +
                "The cop whose car you've damaged is re-animated and hungry for revenge!");
        fightZombieTrapped(survivor, zombie);
        System.out.println("A hoard heard you and are on their way! Do you:\n" +
                "1. Hide in the car or\n" +
                "2. Flee along the bank?");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("1")) {
            sceneFourteen(survivor, zombie);
        }
        else if (input.equals("2")) {
            sceneTwenty(survivor, zombie);
        }
    }

    public static void sceneFourteen(Survivor survivor, Zombie zombie) {
        System.out.println("You climb in and cower on the backseat, but remember too late that the window is broken!\n" +
                "The car is surrounded and a " + zombie.getName() + " lurches through at you!");
        fightZombieTrapped(survivor, zombie);
        System.out.println("The zombies are fighting to be the first in to feast on your body");
        fightZombieTrapped(survivor, zombie);
        System.out.println("The front window gives way, zombies pile into the car.\n" +
                "You should have run while you still could...");
        zombieLoop(survivor, zombie);
    }

    public static void sceneFifteen(Survivor survivor, Zombie zombie) {
        System.out.println("You venture down the road and find a boat house with sheets of plywood. Do you: \n" +
                "1. Take these back or \n" +
                "2. Search for something better?");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while(!input.equals("1") && !input.equals("2")) {
            System.out.println("Invalid command");
            input = in.nextLine();
        }
        if (input.equals("1")) {
            sceneEighteen(survivor, zombie);
        }
        else if (input.equals("2")) {
            sceneSixteen(survivor, zombie);
        }
    }

    public static void sceneSixteen(Survivor survivor, Zombie zombie) {
        System.out.println("You come across a horde...\n" +
                "Is the lead zombie Bob who bullied you at school!? Do you \n" +
                "1. Take revenge on Bob and his buddies or \n" +
                "2. Flee?");
    }

    public static void sceneSeventeen(Survivor survivor, Zombie zombie) {
        System.out.println("One of them has flanked you! \n" +
                "You can't run!");
        fightZombieRushed(survivor, zombie);
//                "Force a fight here"
    }

    public static void sceneEighteen(Survivor survivor, Zombie zombie) {

    }

    public static void sceneNineteen(Survivor survivor, Zombie zombie) {
        System.out.println("Follow the bank\n" +
                "along and see a\n" +
                "bridge with \n" +
                "blockade climb it \n" +
                "or return back? ");
    }

    public static void sceneTwenty(Survivor survivor, Zombie zombie) {
        System.out.println("You run off down the bank and trip over some debris" +
//                "add zombie here"
                "carry on find a bridge and cross it or river?, \n" +
                "covered in cars, barrier");
    }

}
