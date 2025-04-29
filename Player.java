import java.util.ArrayList;
import java.util.Hashtable;

public class Player {

    static protected ArrayList<Snack> foodInventory = new ArrayList<Snack>();
    static protected ArrayList<Item> itemInventory = new ArrayList<Item>();
    static protected Hashtable<Snack, HidingSpot> hiddenSnacks = new Hashtable<Snack, HidingSpot>();
    static protected Place playerLocation = CampusMap.places.get(0);
    static protected boolean verbose = false;

    
    /* Empty constructor */
    // I will only have one player, initialized at the beginning of the program, so a lot of static stuff
    public Player() {
    }

    public static Place getPlayerLocation() {
        return playerLocation;
    }

    public static void setPlayerLocation(Place p) {
        playerLocation = p;

    }
    
    /**
     * Method to change player location
     * @param direction compass direction (NESW) to move in
     */
    public static void go(String direction) {
        Hashtable<String, Place> directions = playerLocation.getDirections();
        if (directions.containsKey(direction)) {
            Place target = directions.get(direction);
            if (target.isAccessible() == true) {
                Player.playerLocation = target;
                System.out.println("You are now at: " + target.getName());
                if (Player.verbose == true) {
                    System.out.println(target.getLongDesc());
                }
            } else {
                throw new RuntimeException("You can't go that way right now, but there might be a way to access it.");
            }
        } else {
            throw new RuntimeException("You don't see anywhere to go that way.");            
        }
    }

    /**
     * Method to use item
     * @param i Item to be used
     */
    public static void use(Item i) {
        if (itemInventory.contains(i)) {
            if (playerLocation == i.getUseAt()) {
                itemInventory.remove(i);
                i.use();
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
     */
    public static void hide(Snack s, HidingSpot h) {
        if (foodInventory.contains(s)) {
            ArrayList<HidingSpot> localHidingSpots = playerLocation.getHidingSpots();
            if (localHidingSpots.contains(h)) {
                if (!hiddenSnacks.contains(h)) {
                    hiddenSnacks.put(s, h);
                    foodInventory.remove(s);
                    System.out.println(s.getName() + "succesfully hidden!");
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
     */
    public void takeSnack(Snack s) {
        if (foodInventory.contains(s)) {
            throw new RuntimeException("You already have this snack!");
        } else if (hiddenSnacks.containsKey(s)) {
            hiddenSnacks.remove(s);
            foodInventory.add(s);
            System.out.println("Success! Added " + s.getName() + "to inventory.");
        } else {
            foodInventory.add(s);
            System.out.println("Success! Added " + s.getName() + "to inventory.");
        }
    }

    /**
     * Method to add an item to player inventory
     * @param i item to take
     */
    public void takeItem(Item i) {

    }
}
