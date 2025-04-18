import java.util.Hashtable;
import java.util.ArrayList;


public class Place {
    private String name;
    private boolean accessible;
    private String longDesc;
    private Hashtable<String, Place> directions;
    private Hashtable<String, String> fancyDirections;
    private ArrayList<String> hidingSpots;

    /**
     * Constructor for place
     * @param name name of place
     */
    public Place(String name, boolean accessible, String longDesc) {
        this.name = name;
        this.accessible = accessible;
        this.longDesc = longDesc;
        this.directions = new Hashtable<String, Place>();
        this.fancyDirections = new Hashtable<String, String>();
        this.hidingSpots = new ArrayList<String>();
    }

    public String getName() {
        return this.name;
    }

    public String getLongDesc() {
        return this.longDesc;
    }

    public void getDirections() {
        String directionsList = this.fancyDirections.toString();
        directionsList = directionsList.replace("{", "");
        directionsList = directionsList.replace("}", "");
        directionsList = directionsList.replace("=", ": ");
        String[] formattedList = directionsList.split(", ");
        for (int i = formattedList.length - 1; i > -1; i--) {
            System.out.println(formattedList[i]);
        }
    }

    public void setDirections(String s1, Place p1) {
        this.directions.put(s1, p1);
        this.fancyDirections.put(s1, p1.getName());
    }

    public void go(String direction) {
        if (directions.containsKey(direction)) {
            Place target = directions.get(direction);
            if (target.accessible == true) {
                Player.playerLocation = target;
                System.out.println("You are now at: " + target.name);
                if (Player.verbose == true) {
                    System.out.println(target.longDesc);
                }
            }
        } else {
            throw new RuntimeException("You don't see anywhere to go that way.");            
        }
    }
}