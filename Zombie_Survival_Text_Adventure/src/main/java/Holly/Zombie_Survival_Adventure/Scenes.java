package Holly.Zombie_Survival_Adventure;

import Holly.Zombie_Survival_Adventure.models.Survivor;
import Holly.Zombie_Survival_Adventure.models.Zombie;
import Holly.Zombie_Survival_Adventure.models.loot.Food;
import Holly.Zombie_Survival_Adventure.models.loot.Gun;

import java.util.Scanner;

public class Scenes {

    public static void sceneOne(Survivor survivor, Zombie zombie) {
        GameLogic.zombieAppears(survivor, zombie);
        GameLogic.fightZombieRushedOrWanderer(survivor, zombie);
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
            GameLogic.fightZombie(survivor, zombie);
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
        GameLogic.inventoryAnnouncement(survivor);
        System.out.println("------------------------------");
        System.out.println("You step out of the tent and a " + zombie.getName() + " lurches at you!");
        GameLogic.fightZombie(survivor, zombie);
        sceneSeven(survivor, zombie);
    }

    public static void sceneFive(Survivor survivor, Zombie zombie) {
        System.out.println("You trip over a legless " + zombie.getName() + "!");
        GameLogic.fightZombieRushedOrWanderer(survivor, zombie);
        sceneSeven(survivor, zombie);

    }

    public static void sceneSix(Survivor survivor, Zombie zombie) {
        System.out.println("The " + zombie.getName() + " has a back pack on, must have been someone else seeking shelter in the woods. \n" +
                "You search it and come up empty. Sucks to be you... \n" +
                "Wait, was that a branch snapping behind you?");
        GameLogic.fightZombie(survivor, zombie);
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
            GameLogic.fightZombie(survivor, zombie);
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
            GameLogic.fightZombie(survivor, zombie);
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
        GameLogic.zombieAppears(survivor, zombie);
        GameLogic.fightZombieTrapped(survivor, zombie);
        System.out.println("You are not the only person who has been here, there are ashes from a fire on the ground. \n" +
                "Empty cans and crisp packets are strewn around. \n" +
                "The windows look like they have been smashed from the inside... \n" +
                "Desperate for sleep and shelter, you spend the night.");
        GameLogic.sleep(survivor);
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
        GameLogic.inventoryAnnouncement(survivor);
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
            GameLogic.sleep(survivor);
            sceneElevenA(survivor, zombie);
        }
    }

    public static void sceneTwelve(Survivor survivor, Zombie zombie) {
        System.out.println("You wade past the corpses, nudging a few out of your way...\n" +
                "The last one moves, it's still alive!");
        GameLogic.fightZombie(survivor, zombie);
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
        GameLogic.inventoryAnnouncement(survivor);
        System.out.println("You put your new items away, but as you step away a hand grabs you from under the car. \n" +
                "The cop whose car you've damaged is re-animated and hungry for revenge!");
        GameLogic.fightZombieTrapped(survivor, zombie);
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
        GameLogic.fightZombieTrapped(survivor, zombie);
        System.out.println("The zombies are fighting to be the first in to feast on your body");
        GameLogic.fightZombieTrapped(survivor, zombie);
        System.out.println("The front window gives way, zombies pile into the car.\n" +
                "You should have run while you still could...");
        GameLogic.zombieLoop(survivor, zombie);
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
        GameLogic.fightZombieRushed(survivor, zombie);
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
