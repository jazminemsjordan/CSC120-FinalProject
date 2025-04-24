import java.util.ArrayList;
import java.util.Hashtable;

public class Player {

    static protected ArrayList<Snack> foodInventory;
    static protected ArrayList<Item> itemInventory;
    static protected Hashtable<Snack, HidingSpot> hiddenSnacks;
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

    public static void use(Item i) {
        if (itemInventory.contains(i)) {
            if (playerLocation == i.getUseCase()) {
                itemInventory.remove(i);
                i.use();
            } else {
                throw new RuntimeException("You can't use that here.");
        }
        } else {
            throw new RuntimeException("You don't have one of those.");
        }
    }

    public static void hide(Snack s, HidingSpot h) {
        if (foodInventory.contains(s)) {
            ArrayList<HidingSpot> localHidingSpots = playerLocation.getHidingSpots();
            if (localHidingSpots.contains(h)) {
                if (!hiddenSnacks.contains(h)) {
                    hiddenSnacks.put(s, h);
                    foodInventory.remove(s);
                    System.out.println("Snack succesfully hidden!");
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

    public void grab() {

    }

    public void look() {
        System.out.println(playerLocation.getLongDesc());
    }
}
