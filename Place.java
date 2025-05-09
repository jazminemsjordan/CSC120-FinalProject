import java.util.Hashtable;
import java.util.ArrayList;


public class Place {
    private String name;
    private boolean accessible;
    private String longDesc;
    private Hashtable<String, Place> directions;
    private Hashtable<String, String> fancyDirections;
    private ArrayList<HidingSpot> hidingSpots;

    /**
     * Constructor for place
     * @param name name of place
     * @param accessible whether the place can be entered immediately
     * @param longdesc full place description
     */
    public Place(String name, boolean accessible, String longDesc) {
        this.name = name;
        this.accessible = accessible;
        this.longDesc = longDesc;
        this.directions = new Hashtable<String, Place>();
        this.fancyDirections = new Hashtable<String, String>();
        this.hidingSpots = new ArrayList<HidingSpot>();
    }

    /**
     * Accessor for name attribute
     * @return the string name of the place
     */
    public String getName() {
        return this.name;
    }

    /**
     * Accessor for accessible attribute
     * @return the boolean value of whether the place can be accessed
     */
    public boolean isAccessible() {
        return this.accessible;
    }

    /**
     * Manipulator for accesible attribute
     */
    public void setAccessible(boolean b) {
        this.accessible = b;
    }

    /**
     * Accessor for longDesc attribute
     * @return the string name of the hiding spot
     */
    public String getLongDesc() {
        return this.longDesc;
    }

    /**
     * Method to print the directions and places you can go from this location 
     */
    public void printDirections() {
        String directionsList = this.fancyDirections.toString();
        directionsList = directionsList.replace("{", "");
        directionsList = directionsList.replace("}", "");
        directionsList = directionsList.replace("=", ": ");
        String[] formattedList = directionsList.split(", ");
        for (int i = 0; i < formattedList.length; i++) {
            System.out.println("    - " + formattedList[i]);
        }
    }

    /**
     * Method to add a direction/place that can be accessed from this location
     * @param s1 the string compass direction (north, east, south, west) the player can move in
     * @param p1 the place the player arrives at when following that direction
     */
    public void setDirections(String s1, Place p1) {
        this.directions.put(s1, p1);
        this.fancyDirections.put(s1, p1.getName());
    }

    /**
     * Accessor for the directions attribute
     * @return a hashtable of corresponding directions and places
     */
    public Hashtable<String, Place> getDirections() {
        return this.directions;
    }

    /**
     * Method to add hiding spots to a place
     * @param h1 the first hiding spot
     * @param h2 the second hiding spot
     * @param h3 the third hiding spot
     */
    public void addHidingSpots(HidingSpot h1, HidingSpot h2, HidingSpot h3) {
        this.hidingSpots.add(h1);
        this.hidingSpots.add(h2);
        this.hidingSpots.add(h3);
    }

    /**
     * Accessor for hidingspots attribute
     * @return the ArrayList of hiding spots at this place
     */
    public ArrayList<HidingSpot> getHidingSpots() {
        return this.hidingSpots;
    }

    /**
     * Method to format and print the hiding spots at this place
     */
    public void printHidingSpots() {
        for (int i = 0; i < 3; i++) {
            HidingSpot h = this.hidingSpots.get(i);
            System.out.println("    - " + h.getName() + ": " + h.getDesc());
        }
    }
}