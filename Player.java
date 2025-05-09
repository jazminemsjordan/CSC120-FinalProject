import java.util.ArrayList;
import java.util.Hashtable;

public class Player {

    static protected ArrayList<Snack> foodInventory = new ArrayList<Snack>();
    static protected ArrayList<Item> itemInventory = new ArrayList<Item>();
    static protected Hashtable<Snack, HidingSpot> hiddenSnacks = new Hashtable<Snack, HidingSpot>();
    static protected Place playerLocation = CampusMap.places.get(0);
    static protected Hashtable<String, String> commands = new Hashtable<String, String>();
    static protected ArrayList<String> commandsList = new ArrayList<String>();
    
    /* Empty constructor */
    // I will only have one player, initialized at the beginning of the program, so a lot of static stuff
    public Player() {
    }

    /**
     * Accessor for player location attribute
     * @return the Place the player is at
     */
    public static Place getPlayerLocation() {
        return playerLocation;
    }

    /**
     * Manipulator for player location attribute
     * @param p the Place the player should be moved to
     */
    public static void setPlayerLocation(Place p) {
        playerLocation = p;
    }

    /**
     * Method to print the help guide for all available commands
     */
    public static void printCommands() {
        for (int i = 0; i < commandsList.size(); i++) {
            String s = commandsList.get(i);
            getCommandHelp(s);
        }
    }

    /**
     * Method to print the help guide for a single command
     * @param s the string command the player needs help with
     */
    public static void getCommandHelp(String s) {
        System.out.println(commands.get(s));
    }

    /**
     * Method to create and intialize the help guide with commands and instructions
     */
    public static void initializeCommands() {
        commands.put("help", "'help' prints all commands; 'help [command] to get help for a specific command");
        commands.put("go", "'go [direction]' to try and move in a compass direction (north, east, south, or west)");
        commands.put("hide", "'hide [snack] in [number]' to hide a snack in one of three hiding spots in your current location");
        commands.put("take", "'take [item]' or 'take [snack]' to add an object to your inventory");
        commands.put("look", "'look' on its own examines your surroundings, or you can 'look at [item]', 'look at [hiding place number]', or 'look at [snack]' to examine something specific up close. You can only examine objects in your inventory and hiding spots in your current location.");
        commands.put("use", "'use [item]' with this command; all items can only be used once, and will be removed from your inventory after a successful use.");
        commands.put("sleep", "'sleep' at Chapin Lawn to return to your nest, end the day, and tally your score");
        commands.put("inventory", "'inventory' gives you a list of all items in your inventory");
        commandsList.add("help");
        commandsList.add("go");
        commandsList.add("hide");
        commandsList.add("take");
        commandsList.add("look");
        commandsList.add("use");
        commandsList.add("sleep");
        commandsList.add("inventory");
    }


    /**
     * Method to format and print the contents of the player's inventory
     */
    public static void printInventory() {
        String inv = "";
        if (foodInventory.size() > 0 || itemInventory.size() > 0) {
            if (foodInventory.size() > 0) {
                for (int i = 0; i < foodInventory.size(); i++) {
                    if (i == 0) {
                        inv = inv + foodInventory.get(i).getName();
                    } else {
                        inv = inv + ", " + foodInventory.get(i).getName();
                    }
                }
            }
            if (itemInventory.size() > 0) {
                for (int i = 0; i < itemInventory.size(); i++) {
                    if (i == itemInventory.size()) {
                        inv = inv + itemInventory.get(i).getName();
                    } else {
                        inv = inv + ", " + itemInventory.get(i).getName();
                    }
                }
            }
        } else {
            inv = "Your inventory is empty. Go gather some items and snacks!";
        }
        System.out.println(inv);
    }
    
    /**
     * Method to change player location by moving
     * @param direction compass direction (NESW) to move in
     * @throws RuntimeException if the player cannot move that direction for any reason
     */
    public static void go(String direction) {
        Hashtable<String, Place> directions = playerLocation.getDirections();
        if (directions.containsKey(direction)) {
            Place target = directions.get(direction);
            if (target.isAccessible() == true) {
                Player.playerLocation = target;
                System.out.println("You are now at: " + target.getName());
            } else {
                throw new RuntimeException("There's construction going on that blocks the way to Neilson Lawn. There's a large sign reading: 'no entry without PPE.' You don't want to get hurt!");
            }
        } else {
            throw new RuntimeException("You don't see anywhere to go that way.");            
        }
    }

    /**
     * Method to use item
     * @param i Item to be used
     * @throws RuntimeException if the item is not in the player's inventory or if the player isn't in the right place to use it
     */
    public static void use(Item i) {
        if (itemInventory.contains(i)) {
            if (playerLocation == i.getUseAt()) {
                itemInventory.remove(i);
                i.lock();
                // results of item being used
                if (i == Assets.masterItems.get(0)) {
                    Assets.masterSnacks.get(9).setUnlocked(true);
                    System.out.println("You blow the whistle, and a flurry of squirrels descend upon the raspberry bushes. When the haze clears, they've hollowed out an entrance to the center. Inside lie a handle of juicy raspberries.");
                } else if (i == Assets.masterItems.get(1)) {
                    Assets.masterSnacks.get(5).setUnlocked(true);
                    System.out.println("Now armed as a squirrel with a knife, that plastic bag is no match for you.");
                } else if (i == Assets.masterItems.get(2)) {
                    Assets.masterSnacks.get(6).setUnlocked(true);
                    System.out.println("You file your claws to a perfect point. These should be able to get purchase on the building's surface.");
                } else if (i == Assets.masterItems.get(3)) {
                    Assets.masterSnacks.get(0).setUnlocked(true);
                    System.out.println("With dextrous squirrel paws, you unscrew the screen from the window, and it clatters to the ground.");
                } else if (i == Assets.masterItems.get(4)) {
                    CampusMap.neilsonLawn.setAccessible(true);
                    System.out.println("You carefully put on the hard hat. Now equipped with proper PPE, you can now cross from Burton Lawn to Neilson Lawn.");
                }
            } else {
                throw new RuntimeException("You can't use that here.");
            }
        } else {
            throw new RuntimeException("You don't have one of those.");
        }
    }

    /**
     * Method to hide a snack for the winter
     * @param s Snack to hide
     * @param h HidingSpot to hide the snack in
     * @throws RuntimeException if the snack or hiding spot does not exist, or if something is already hidden there
     */
    public static void hide(Snack s, HidingSpot h) {
        if (foodInventory.contains(s)) {
            ArrayList<HidingSpot> localHidingSpots = playerLocation.getHidingSpots();
            if (localHidingSpots.contains(h)) {
                if (!hiddenSnacks.contains(h)) {
                    hiddenSnacks.put(s, h);
                    foodInventory.remove(s);
                    System.out.println(s.getName() + " succesfully hidden!");
                } else {
                    throw new RuntimeException("You already have something hidden in this spot.");
                }
            } else {
                throw new RuntimeException("You don't see a place like that to hide things.");
            }
        } else {
            throw new RuntimeException("You don't have that snack on you.");
        }
    }

    /**
     * Method to add a snack to player inventory
     * @param s Snack to take
     * @throws RuntimeException if the snack cannot be added to inventory
     */
    public static void takeSnack(Snack s) {
        if (foodInventory.contains(s)) {
            throw new RuntimeException("You already have this snack!");
        } else if (hiddenSnacks.containsKey(s)) {
            // check hiding spot
            HidingSpot h = s.getStashedAt();
            Place p = h.getPlace();
            if (Player.getPlayerLocation() == p) {
                hiddenSnacks.remove(s);
                foodInventory.add(s);
                System.out.println("Success! Retrieved from hiding spot. Added " + s.getName() + " to inventory.");
            } else {
                throw new RuntimeException("You can't retrieve snacks from across the map! Go to where you hid it first.");
            }
        } else if (s.getUnlocked() == false) {
            throw new RuntimeException("This snack is blocked somehow. You'll need an item to get to it.");
        } else if (Player.getPlayerLocation() == s.getFoundAt()) {
            foodInventory.add(s);
            System.out.println("Success! Added " + s.getName() + " to inventory.");
        } else {
            System.out.println("You can't collect a snack from across the map! You have to find it first.");
        }
    }

    /**
     * Method to add an item to player inventory
     * @param i item to take
     * @throws RuntimeException if the item cannot be added to inventory
     */
    public static void takeItem(Item i) {
        if (itemInventory.contains(i)) {
            throw new RuntimeException("You already have this item!");
        } else if (i.getUnlocked() == false) {
            throw new RuntimeException("You already used this item!");
        } else if (i.getFoundAt() == Player.getPlayerLocation()) {
            itemInventory.add(i);
            System.out.println("Success! Added " + i.getName() + " to inventory.");
        } else {
            throw new RuntimeException("You don't see one of those in this location.");
        }
    }
}
