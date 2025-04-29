import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class CommandReader {

    // using arrays to store possible commands for user friendliness
    public static String[] goInput = {"go", "g", "move", "walk", "travel", "head"};
    public static String[] directionalInput = {"north", "n", "east", "e", "south", "s", "west", "w"};
    public static String[] takeInput = {"take", "grab", "get"};
    public static String[] lookInput = {"look", "check", "examine"};
    public static String[] snackInput = {};
    public static String[] itemInput = {};
    public static Scanner inputScanner = new Scanner(System.in);

    /*
     * Empty constructor
     */
    public CommandReader() {
    }

    public static void readCommand() {
        //get command from user input
        String userInput = inputScanner.nextLine();
        // split commands by word into a list
        String[] splitUserInput = userInput.split(" ");
        ArrayList<String> command= new ArrayList<String>(Arrays.asList(splitUserInput));
        // remove filler words
        for (int i = 0; i < command.size(); i++) {
            String c = command.get(i);
            if (c == "at" || c == "the" || c == "to") {
                command.remove(i);
            }
        }
        // divide into first command and parameters
        String baseCommand = command.get(0);
        ArrayList<String> parameters = new ArrayList<String>();
        for (int i = 1; i < command.size(); i++) {
            parameters.add(command.get(i));
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
            if (Arrays.asList(snackInput).contains(parameters.get(0))) {
                //set snack to null, change based on parameter
                Snack s = null;
                if (parameters.contains("spaghetti")) {
                    s = Assets.masterSnacks.get(0);
                } else if (parameters.contains("sushi")) {
                    s = Assets.masterSnacks.get(1);
                } else if (parameters.contains("donut") || parameters.contains("maple")) {
                    s = Assets.masterSnacks.get(2);
                } else if (parameters.contains("sandwich") || parameters.contains("cheese")) {
                    s = Assets.masterSnacks.get(3);
                } else if (parameters.contains("bagel")) {
                    s = Assets.masterSnacks.get(4);
                } else if (parameters.contains("chicken") || parameters.contains("drumstick")) {
                    s = Assets.masterSnacks.get(5);
                } else if (parameters.contains("cookie")) {
                    s = Assets.masterSnacks.get(6);
                } else if (parameters.contains("granola") || parameters.contains("protein")) {
                    s = Assets.masterSnacks.get(7);
                } else if (parameters.contains("plum")) {
                    s = Assets.masterSnacks.get(8);
                } else if (parameters.contains("raspberry") || parameters.contains("berry")) {
                    s = Assets.masterSnacks.get(9);
                } else if (parameters.contains("apple")) {
                    s = Assets.masterSnacks.get(10);
                } else if (parameters.contains("peanut")) {
                    s = Assets.masterSnacks.get(11);
                }
                // s should always be changed with snackInput, so exception thrown is a code based error
                if (s == null) {
                    throw new RuntimeException("This is an error!");
                } else {
                    // if player has s, give its description, otherwise give user an error
                    if (Player.foodInventory.contains(s)) {
                        System.out.println(s.getDesc());
                    } else {
                        throw new RuntimeException("Are you sure you have that on you? You can't look at an object you don't have!");
                    }
                }
            // check if player is looking at item
            } else if (Arrays.asList(itemInput).contains(parameters.get(0))) {
                // to be edited: item check works the same as 

            } else {
                // if you aren't looking at anything in specific, look at location 
                // for each if else loop: one description is always read for each location
                // other descriptions depend on if you've unlocked and taken the snacks/items located there
                if (Player.getPlayerLocation() == CampusMap.chapinLawn) {
                    System.out.println(CampusMap.chapinLawn.getLongDesc());
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(2)) && !Player.foodInventory.contains(Assets.masterSnacks.get(2))) {
                        System.out.println("there is a donut");
                    } 
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(6)) && !Player.foodInventory.contains(Assets.masterSnacks.get(6))) {
                        if (Assets.masterSnacks.get(6).getUnlocked() == true) {
                            System.out.println("there is a cookie you can reach");
                        } else {
                            System.out.println("you see a cookie but you can't reach it");
                        }
                    }
                } else if (Player.getPlayerLocation() == CampusMap.capenGarden) {
                    System.out.println(CampusMap.capenGarden.getLongDesc());
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(3)) && !Player.foodInventory.contains(Assets.masterSnacks.get(3))) {
                        System.out.println("you see a grilled cheese");
                    }
                } else if (Player.getPlayerLocation() == CampusMap.burtonLawn) {
                    System.out.println(CampusMap.burtonLawn.getLongDesc());
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(10)) && !Player.foodInventory.contains(Assets.masterSnacks.get(10))) {
                        System.out.println("there's an apple core in the trash");
                    }
                } else if (Player.getPlayerLocation() == CampusMap.neilsonLawn) {
                    System.out.println(CampusMap.neilsonLawn.getLongDesc());
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(1)) && !Player.foodInventory.contains(Assets.masterSnacks.get(1))) {
                        System.out.println("there is a sushi roll in sight");
                    }
                } else if (Player.getPlayerLocation() == CampusMap.mendenhallCourtyard) {
                    System.out.println(CampusMap.mendenhallCourtyard.getLongDesc());
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(11)) && !Player.foodInventory.contains(Assets.masterSnacks.get(11))) {
                        System.out.println("a theater student tosses a peanut your way");
                    } 
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(0)) && !Player.foodInventory.contains(Assets.masterSnacks.get(0))) {
                        if (Assets.masterSnacks.get(0).getUnlocked() == true) {
                            System.out.println("there's a plate of spaghetti behind the closed window");
                        } else {
                            System.out.println("the window is open, leaving spaghetti ripe for the taking.");
                        }
                    }
                } else if (Player.getPlayerLocation() == CampusMap.greatQuadrangle) {
                    System.out.println(CampusMap.greatQuadrangle.getLongDesc());
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(4)) && !Player.foodInventory.contains(Assets.masterSnacks.get(4))) {
                        System.out.println("A sleepy student walks by with a bagel. You could probably grab it from their hand pretty easily.");
                    } 
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(5)) && !Player.foodInventory.contains(Assets.masterSnacks.get(5))) {
                        if (Assets.masterSnacks.get(5).getUnlocked() == true) {
                            System.out.println("You've gotten into the bag and can now steal a chicken drumstick.");
                        } else {
                            System.out.println("There's a grubhub bag on the stairs, but your teeth aren't quite sharp enough to chew through.");
                        }
                    }
                } else if (Player.getPlayerLocation() == CampusMap.athleticField) {
                    System.out.println(CampusMap.athleticField.getLongDesc());
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(7)) && !Player.foodInventory.contains(Assets.masterSnacks.get(7))) {
                        System.out.println("A student left a protein bar on the bench. Still wrapped! Perfect for winter.");
                    }
                } else if (Player.getPlayerLocation() == CampusMap.paradiseWoods) {
                    System.out.println("");
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(8)) && !Player.foodInventory.contains(Assets.masterSnacks.get(8))) {
                        System.out.println("A ripe plum hangs from a tree. You could climb up and grab it.");
                    } 
                    if (!Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(9)) && !Player.foodInventory.contains(Assets.masterSnacks.get(9))) {
                        if (Assets.masterSnacks.get(9).getUnlocked() == true) {
                            System.out.println("The raspberry brambles are too thick to get through alone. If only you had some way to call for reinforcements...");
                        } else {
                            System.out.println("There's a large hole in the center of the brambles where you can crawl through to a cluster of juicy raspberries.");
                        }
                    }
                }
            }
        }
    }
}
