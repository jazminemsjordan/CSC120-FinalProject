import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class CommandReader {

    // using arrays to store possible commands for user friendliness
    public static String[] goInput = {"go", "g", "move", "walk", "travel", "head"};
    public static String[] directionalInput = {"north", "n", "east", "e", "south", "s", "west", "w"};
    public static String[] takeInput = {"take", "grab", "get"};
    public static String[] lookInput = {"look", "check", "examine", "consider"};
    public static String[] snackInput = {"spaghetti", "donut", "maple", "chicken", "drumstick", "sushi", "sandwich", "cheese", "bagel", "cookie", "granola", "protein", "bar", "plum", "raspberries", "berries", "berry", "apple", "peanut"};
    public static String[] itemInput = {"file", "screwdriver", "knife", "pocketknife", "whistle", "hat", "helmet"};
    public static String[] hideInput = {"hide", "stash", "bury"};
    public static String[] hidingSpotInput = {"1", "2", "3", "one", "two", "three"};
    public static String[] endInput = {"end", "done", "sleep", "finish"};
    public static Scanner inputScanner = new Scanner(System.in);
    public static Scanner confirmationScanner = new Scanner(System.in);

    /*
     * Empty constructor for static class
     */
    public CommandReader() {
    }

    /**
     * Method to read the user input as a command and call the corresponding method
     * @throws RuntimeException with a string message if there is any error in the process of running a command 
     */
    public static void readCommand() {
        //get command from user input
        String userInput = inputScanner.nextLine();
        System.out.println("--------------------------------------------");
        // split commands by word into a list
        String[] splitUserInput = userInput.split(" ");
        ArrayList<String> command= new ArrayList<String>(Arrays.asList(splitUserInput));
        // remove filler words
        for (int i = 0; i < command.size(); i++) {
            String c = command.get(i);
            if (c.equals("at") || c.equals("the") || c.equals("at") || c.equals("in")) {
                command.remove(i);
            }
        }
        // divide into main command and parameters
        String baseCommand = command.get(0);
        ArrayList<String> parameters = new ArrayList<String>();
        for (int i = 1; i < command.size(); i++) {
            parameters.add(command.get(i));
        }
        if (parameters.size() == 0) {
            parameters.add("NULL");
        }
        // checking for snacks and items 
        boolean snackCommand = false;
        boolean itemCommand = false;
        Snack snack = null;
        Item item = null;
        int count = 0;
        for (int i = 0; i < parameters.size(); i++) {
            if (Arrays.asList(snackInput).contains(parameters.get(i))) {
                snackCommand = true;
                count++;
            }
        }
        for (int i = 0; i < parameters.size(); i++) {
            if (Arrays.asList(itemInput).contains(parameters.get(i))) {
                itemCommand = true;
                count++;
            }
        }
        // overwhelmed input, can't choose
        if (snackCommand == true && itemCommand == true || count > 1) {
            throw new RuntimeException("Your squirrel brain can't work with that much input! Try a simpler command, with only one item or snack at a time.");
        }
        // if the command relates to snacks, set what the snack is in advance for all commands
        if (snackCommand == true) {
            if (parameters.contains("spaghetti")) {
                snack = Assets.masterSnacks.get(0);
            } else if (parameters.contains("sushi")) {
                snack = Assets.masterSnacks.get(1);
            } else if (parameters.contains("donut") || parameters.contains("maple")) {
                snack = Assets.masterSnacks.get(2);
            } else if (parameters.contains("sandwich") || parameters.contains("cheese")) {
                snack = Assets.masterSnacks.get(3);
            } else if (parameters.contains("bagel")) {
                snack = Assets.masterSnacks.get(4);
            } else if (parameters.contains("chicken") || parameters.contains("drumstick")) {
                snack = Assets.masterSnacks.get(5);
            } else if (parameters.contains("cookie")) {
                snack = Assets.masterSnacks.get(6);
            } else if (parameters.contains("granola") || parameters.contains("protein")) {
                snack = Assets.masterSnacks.get(7);
            } else if (parameters.contains("plum")) {
                snack = Assets.masterSnacks.get(8);
            } else if (parameters.contains("raspberry") || parameters.contains("berry")) {
                snack = Assets.masterSnacks.get(9);
            } else if (parameters.contains("apple")) {
                snack = Assets.masterSnacks.get(10);
            } else if (parameters.contains("peanut")) {
                snack = Assets.masterSnacks.get(11);
            }
            if (snack == null) {
                throw new RuntimeException("Error with snack detection.");
            }
        }
        // if the command relates to items, set what the item is in advance for all commands
        if (itemCommand == true) {
            if (parameters.contains("whistle")) {
                item = Assets.masterItems.get(0);
            } else if (parameters.contains("knife")) {
                item = Assets.masterItems.get(1);
            } else if (parameters.contains("file")) {
                item = Assets.masterItems.get(2);
            } else if (parameters.contains("screwdriver")) {
                item = Assets.masterItems.get(3);
            } else if (parameters.contains("helmet") || parameters.contains("hat")) {
                item = Assets.masterItems.get(4);
            }
            if (item == null) {
                throw new RuntimeException("Error with item detection.");
            }
        }
        // beginning command reading
        // go command
        if (Arrays.asList(goInput).contains(baseCommand) || Arrays.asList(directionalInput).contains(baseCommand)) {
            //set parameter based on whether player input go or just a direction
            String param;
            if (Arrays.asList(directionalInput).contains(baseCommand)) {
                param = baseCommand;
            } else if (Arrays.asList(goInput).contains(baseCommand)) {
                param = parameters.get(0);
            } else {
                throw new RuntimeException("Something is wrong!");
            }
            //cut off param to first letter and go that direction
            String direction = param.substring(0, 1);
            if (direction.equals("n")) {
                Player.go("north");
            } else if (direction.equals("e")) {
                Player.go("east");
            } else if (direction.equals("s")) {
                Player.go("south");
            } else if (direction.equals("w")) {
                Player.go("west");
            } else {
                throw new RuntimeException("I don't know where you're trying to go!");
            }
        // look at environment or object
        } else if (Arrays.asList(lookInput).contains(baseCommand)) {
            // check if player is looking at snack
            if (snackCommand == true) {
                if (Player.foodInventory.contains(snack)) {
                    System.out.println(snack.getDesc());
                } else {
                    throw new RuntimeException("Are you sure you have that on you? You can't look at a snack you don't have! Try the take command first.");
                }
            // check if player is looking at item
            } else if (itemCommand == true) {
                if (Player.itemInventory.contains(item)) {
                    System.out.println(item.getDesc());
                } else {
                    throw new RuntimeException("Are you sure you have that on you? You can't look at an item you don't have! Try the take command first.");
                }
            } else {
                // if you aren't looking at anything in specific, look at location 
                // for each if else loop: one description is always read for each location
                // other descriptions depend on if you've unlocked and taken the snacks/items located there
                if (Player.getPlayerLocation() == CampusMap.chapinLawn) {
                    System.out.println(" --- Chapin Lawn ---");
                    System.out.println(CampusMap.chapinLawn.getLongDesc());
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(2)) && !Player.foodInventory.contains(Assets.masterSnacks.get(2))) {
                        System.out.println("A donut has fallen off one of the tables onto the grass.");
                    } 
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(6)) && !Player.foodInventory.contains(Assets.masterSnacks.get(6))) {
                        if (Assets.masterSnacks.get(6).getUnlocked() == true) {
                            System.out.println("With newly prepared claws, you're ready to climb up and grab the cookie.");
                        } else {
                            System.out.println("Somehow, a cookie has ended up on the roof of the campus center, but the building is too smooth to climb with dull claws.");
                        }
                    }
                } else if (Player.getPlayerLocation() == CampusMap.capenGarden) {
                    System.out.println(" --- Capen Garden ---");
                    System.out.println(CampusMap.capenGarden.getLongDesc());
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(3)) && !Player.foodInventory.contains(Assets.masterSnacks.get(3))) {
                        System.out.println("You see a grilled cheese on a bench.");
                    }
                    if (!Player.itemInventory.contains(Assets.masterItems.get(3)) && (Assets.masterItems.get(3).getUnlocked() == true)) {
                        System.out.println("Someone dropped a screwdriver outside their dorm window.");
                    }
                } else if (Player.getPlayerLocation() == CampusMap.burtonLawn) {
                    System.out.println(" --- Burton Lawn ---");
                    System.out.println(CampusMap.burtonLawn.getLongDesc());
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(10)) && !Player.foodInventory.contains(Assets.masterSnacks.get(10))) {
                        System.out.println("There's an apple core in the trash.");
                    }
                } else if (Player.getPlayerLocation() == CampusMap.neilsonLawn) {
                    System.out.println(" --- Neilson Lawn ---");
                    System.out.println(CampusMap.neilsonLawn.getLongDesc());
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(1)) && !Player.foodInventory.contains(Assets.masterSnacks.get(1))) {
                        System.out.println("You see an unattended sushi roll on a picnic table.");
                    }
                    if (!Player.itemInventory.contains(Assets.masterItems.get(2)) && (Assets.masterItems.get(2).getUnlocked() == true)) {
                        System.out.println("There's a nail file lying on the sidewalk. Must have fallen out of a backpack.");
                    }
                } else if (Player.getPlayerLocation() == CampusMap.mendenhallCourtyard) {
                    System.out.println(" --- Mendenhall Courtyard ---");
                    System.out.println(CampusMap.mendenhallCourtyard.getLongDesc());
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(11)) && !Player.foodInventory.contains(Assets.masterSnacks.get(11))) {
                        System.out.println("A theater student tosses a peanut your way");
                    } 
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(0)) && !Player.foodInventory.contains(Assets.masterSnacks.get(0))) {
                        if (Assets.masterSnacks.get(0).getUnlocked() == true) {
                            System.out.println("The window is open, leaving a plate of spaghetti ripe for the taking.");
                        } else {
                            System.out.println("There's a plate of spaghetti behind the window, but there's a sturdy screen in the way screwed into the windowframe.");
                        }
                    }
                    if (!Player.itemInventory.contains(Assets.masterItems.get(4)) && (Assets.masterItems.get(4).getUnlocked() == true)) {
                        System.out.println("There's a very tiny hard hat, seemingly a prop for some sort of production, lying on a table.");
                    }
                } else if (Player.getPlayerLocation() == CampusMap.greatQuadrangle) {
                    System.out.println(" --- Great Quadrangle ---");
                    System.out.println(CampusMap.greatQuadrangle.getLongDesc());
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(4)) && !Player.foodInventory.contains(Assets.masterSnacks.get(4))) {
                        System.out.println("A sleepy student walks by with a bagel. You could probably grab it from their hand pretty easily.");
                    } 
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(5)) && !Player.foodInventory.contains(Assets.masterSnacks.get(5))) {
                        if (Assets.masterSnacks.get(5).getUnlocked() == true) {
                            System.out.println("You've gotten into the bag and can now steal a chicken drumstick.");
                        } else {
                            System.out.println("There's a grubhub bag on the stairs, but the plastic is shockingly thick. You'll need something sharper than your claws and teeth to open up.");
                        }
                    }
                } else if (Player.getPlayerLocation() == CampusMap.athleticField) {
                    System.out.println(" --- Athletic Field ---");
                    System.out.println(CampusMap.athleticField.getLongDesc());
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(7)) && !Player.foodInventory.contains(Assets.masterSnacks.get(7))) {
                        System.out.println("A student left a protein bar on the bench. Still wrapped! Perfect for winter.");
                    }
                    if (!Player.itemInventory.contains(Assets.masterItems.get(0)) && (Assets.masterItems.get(0).getUnlocked() == true)) {
                        System.out.println("It looks like a coach left their whistle here.");
                    }
                } else if (Player.getPlayerLocation() == CampusMap.paradiseWoods) {
                    System.out.println(" --- Paradise Woods ---");
                    System.out.println(CampusMap.paradiseWoods.getLongDesc());
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(8)) && !Player.foodInventory.contains(Assets.masterSnacks.get(8))) {
                        System.out.println("A ripe plum hangs from a tree. You could climb up and grab it.");
                    } 
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(9)) && !Player.foodInventory.contains(Assets.masterSnacks.get(9))) {
                        if (Assets.masterSnacks.get(9).getUnlocked() == true) {
                            System.out.println("There's a large hole in the center of the brambles where you can crawl through to a cluster of juicy raspberries.");
                        } else {
                            System.out.println("The raspberry brambles are too thick to get through alone. If only you had some way to call for reinforcements...");

                        }
                    }
                    if (!Player.itemInventory.contains(Assets.masterItems.get(1)) && (Assets.masterItems.get(1).getUnlocked() == true)) {
                        System.out.println("Someone dropped a pocketknife in the center of the trail.");
                    }
                }
                Place location = Player.getPlayerLocation();
                System.out.println();
                System.out.println("You see three places here you could hide things:");
                location.printHidingSpots();
                System.out.println();
                System.out.println("You can go these places from here:");
                location.printDirections();
            }
        // take command
        } else if (Arrays.asList(takeInput).contains(baseCommand)) {
            if (snackCommand == true) {
                // call to Player method
                Player.takeSnack(snack);
            } else if (itemCommand == true) {
                Player.takeItem(item);
            } else {
                throw new RuntimeException("I don't know what you're trying to take!");
            }
        // hide command
        } else if (Arrays.asList(hideInput).contains(baseCommand)) {
            boolean hidingSpotCommand = false;
            // cross check parameters with hiding place numbers for inclusivity (any number in any spot will work, as opposed to a certain index)
            for (int i = 0; i < parameters.size(); i++) {
                for (int j = 0; j < hidingSpotInput.length; j++) {
                    // for each item in parameters and hiding spot input, if one pair matches, command is true and can run
                    String s1 = parameters.get(i);
                    String s2 = Arrays.asList(hidingSpotInput).get(j);
                    if (s1.equals(s2)) {
                        hidingSpotCommand = true;
                    }
                }
            }
            // error handling for hide
            if (snackCommand == false && hidingSpotCommand == false) {
                throw new RuntimeException("I don't know what you're trying to hide or where you're trying to hide it");
            } else if (snackCommand == false && hidingSpotCommand == true) {
                throw new RuntimeException("I don't know what you're trying to hide!");
            } else if (hidingSpotCommand == false && snackCommand == true) {
                throw new RuntimeException("I don't know where you're trying to hide that!");
            // actual snack hiding if there is both a snack and a hiding spot
            } else if (hidingSpotCommand == true && hidingSpotCommand == true) {
                // setting up hiding spots
                HidingSpot h = null;
                if (Player.getPlayerLocation() == CampusMap.chapinLawn) {
                    if (parameters.contains("1") || parameters.contains("one")) {
                        h = Assets.masterHidingSpots.get(0);
                    } else if (parameters.contains("2") || parameters.contains("two")) {
                        h = Assets.masterHidingSpots.get(1);
                    } else if (parameters.contains("3") || parameters.contains("three")) {
                        h = Assets.masterHidingSpots.get(2);
                    }
                } else if (Player.getPlayerLocation() == CampusMap.capenGarden) {
                    if (parameters.contains("1") || parameters.contains("one")) {
                        h = Assets.masterHidingSpots.get(3);
                    } else if (parameters.contains("2") || parameters.contains("two")) {
                        h = Assets.masterHidingSpots.get(4);
                    } else if (parameters.contains("3") || parameters.contains("three")) {
                        h = Assets.masterHidingSpots.get(5);
                    }
                } else if (Player.getPlayerLocation() == CampusMap.burtonLawn) {
                    if (parameters.contains("1") || parameters.contains("one")) {
                        h = Assets.masterHidingSpots.get(6);
                    } else if (parameters.contains("2") || parameters.contains("two")) {
                        h = Assets.masterHidingSpots.get(7);
                    } else if (parameters.contains("3") || parameters.contains("three")) {
                        h = Assets.masterHidingSpots.get(8);
                    }
                } else if (Player.getPlayerLocation() == CampusMap.neilsonLawn) {
                    if (parameters.contains("1") || parameters.contains("one")) {
                        h = Assets.masterHidingSpots.get(9);
                    } else if (parameters.contains("2") || parameters.contains("two")) {
                        h = Assets.masterHidingSpots.get(10);
                    } else if (parameters.contains("3") || parameters.contains("three")) {
                        h = Assets.masterHidingSpots.get(11);
                    }
                } else if (Player.getPlayerLocation() == CampusMap.mendenhallCourtyard) {
                    if (parameters.contains("1") || parameters.contains("one")) {
                        h = Assets.masterHidingSpots.get(12);
                    } else if (parameters.contains("2") || parameters.contains("two")) {
                        h = Assets.masterHidingSpots.get(13);
                    } else if (parameters.contains("3") || parameters.contains("three")) {
                        h = Assets.masterHidingSpots.get(14);
                    }
                } else if (Player.getPlayerLocation() == CampusMap.greatQuadrangle) {
                    if (parameters.contains("1") || parameters.contains("one")) {
                        h = Assets.masterHidingSpots.get(15);
                    } else if (parameters.contains("2") || parameters.contains("two")) {
                        h = Assets.masterHidingSpots.get(16);
                    } else if (parameters.contains("3") || parameters.contains("three")) {
                        h = Assets.masterHidingSpots.get(17);
                    }
                } else if (Player.getPlayerLocation() == CampusMap.athleticField) {
                    if (parameters.contains("1") || parameters.contains("one")) {
                        h = Assets.masterHidingSpots.get(18);
                    } else if (parameters.contains("2") || parameters.contains("two")) {
                        h = Assets.masterHidingSpots.get(19);
                    } else if (parameters.contains("3") || parameters.contains("three")) {
                        h = Assets.masterHidingSpots.get(20);
                    }
                } else if (Player.getPlayerLocation() == CampusMap.paradiseWoods) {
                    if (parameters.contains("1") || parameters.contains("one")) {
                        h = Assets.masterHidingSpots.get(21);
                    } else if (parameters.contains("2") || parameters.contains("two")) {
                        h = Assets.masterHidingSpots.get(22);
                    } else if (parameters.contains("3") || parameters.contains("three")) {
                        h = Assets.masterHidingSpots.get(23);
                    }
                }
                // run hide command
                Player.hide(snack, h);
            }
        // use command
        } else if (baseCommand.equals("use")) {
            if (itemCommand = true) {
                Player.use(item);
            }
        } else if (Arrays.asList(endInput).contains(baseCommand)) {
            if (Player.getPlayerLocation() == CampusMap.chapinLawn) {
                System.out.println("Are you sure you're done? By going to sleep, the game will finish and your points will be tallied. Note: snacks in your inventory do not count! Make sure you've hidden everything you've found.");
                String input = confirmationScanner.nextLine();
                String confirm = input.substring(0, 1);
                if (confirm.equals("y")) {
                    Game.end = true;
                } else {
                    throw new RuntimeException("Ending cancelled! Feel free to collect more snacks or pick up and rehide anything you want to move. Return to Chapin and sleep to finish the game.");
                }
            } else {
                throw new RuntimeException("You can't end the game and sleep until you've returned to your nest at Chapin Lawn.");
            }
        // help command
        } else if (baseCommand.equals("help")) {
            if (parameters.contains("look")) {
                Player.getCommandHelp("look");
            } else if (parameters.contains("help")) {
                Player.getCommandHelp("help");
            } else if (parameters.contains("go")) {
                Player.getCommandHelp("go");
            } else if (parameters.contains("take")) {
                Player.getCommandHelp("take");
            } else if (parameters.contains("hide")) {
                Player.getCommandHelp("take");
            } else if (parameters.contains("sleep")) {
                Player.getCommandHelp("sleep");
            } else if (parameters.contains("use")) {
                Player.getCommandHelp("use");
            } else {
                Player.printCommands();
            }
        } else if (baseCommand.equals("inventory")) {
            Player.printInventory();
        } else {
            throw new RuntimeException("I don't recognize that command.");
        }
    }
}
