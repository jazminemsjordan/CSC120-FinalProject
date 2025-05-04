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
     * @param longdesc place description
     */
    public Place(String name, boolean accessible, String longDesc) {
        this.name = name;
        this.accessible = accessible;
        this.longDesc = longDesc;
        this.directions = new Hashtable<String, Place>();
        this.fancyDirections = new Hashtable<String, String>();
        this.hidingSpots = new ArrayList<HidingSpot>();
    }

    public String getName() {
        return this.name;
    }

    public boolean isAccessible() {
        return this.accessible;
    }

    public String getLongDesc() {
        return this.longDesc;
    }

    public void printDirections() {
        String directionsList = this.fancyDirections.toString();
        directionsList = directionsList.replace("{", "");
        directionsList = directionsList.replace("}", "");
        directionsList = directionsList.replace("=", ": ");
        String[] formattedList = directionsList.split(", ");
        for (int i = 0; i < formattedList.length; i++) {
            System.out.println(formattedList[i]);
        }
    }

    public void setDirections(String s1, Place p1) {
        this.directions.put(s1, p1);
        this.fancyDirections.put(s1, p1.getName());
    }

    public Hashtable<String, Place> getDirections() {
        return this.directions;
    }

    public void addHidingSpots(HidingSpot h1, HidingSpot h2, HidingSpot h3) {
        this.hidingSpots.add(h1);
        this.hidingSpots.add(h2);
        this.hidingSpots.add(h3);
    }

    public ArrayList<HidingSpot> getHidingSpots() {
        return this.hidingSpots;
    }

    public void printHidingSpots() {
        for (int i = 0; i < 3; i++) {
            HidingSpot h = this.hidingSpots.get(i);
            System.out.println("     - " + h.getName() + ": " + h.getDesc());
        }
    }
}