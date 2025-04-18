import java.util.ArrayList;

public class Player {


    static protected ArrayList<Snack> foodInventory;
    static protected ArrayList<Item> itemInventory;
    static protected Place playerLocation = CampusMap.chapinLawn;
    static protected boolean verbose = false;

    
    /* Empty constructor */
    // I will only have one player, initialized at the beginning of the program, so a lot of static stuff
    public Player() {
    }

    public Place getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(Place p) {
        playerLocation = p;

    }

    public void use(Item i) {
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

    public void look() {
        System.out.println(playerLocation.getLongDesc());
    }
}
