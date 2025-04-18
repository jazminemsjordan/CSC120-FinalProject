import java.util.ArrayList;
public class CampusMap {

    static ArrayList<Place> places = new ArrayList<Place>();
    // creating places
    static Place chapinLawn = new Place("Chapin Lawn", true, "description");
    static Place capenGarden = new Place("Capen Garden", true, "description");
    static Place burtonLawn = new Place("Burton Lawn", true, "description");
    static Place neilsonLawn = new Place("Neilson Lawn", false, "description");
    static Place mendenhallCourtyard = new Place("Mendenhall Courtyard", true, "description");
    static Place greatQuadrangle = new Place("Great Quadrangle", true, "description");
    static Place athleticField = new Place("Athletic Field", true, "description");
    static Place paradiseWoods = new Place("Paradise Woods", true, "description");

    /* Empty constructor */
    // I will only have one map, initialized at the beginning of the program, so a lot of static stuff
    public CampusMap() {
    }

    public void printDirectory() {
        for (int i = 0; i < places.size(); i ++) {
            System.out.println((i+1) + ". " + places.get(i).getName());
        }
    }

    public static void initializeDirections() { 
        // setting place directions
        chapinLawn.setDirections("north", capenGarden);
        chapinLawn.setDirections("south", burtonLawn);
        chapinLawn.setDirections("west", greatQuadrangle);
        capenGarden.setDirections("south", chapinLawn);
        burtonLawn.setDirections("north", chapinLawn);
        burtonLawn.setDirections("east", neilsonLawn);
        burtonLawn.setDirections("south", mendenhallCourtyard);
        burtonLawn.setDirections("west", paradiseWoods);
        neilsonLawn.setDirections("west", burtonLawn);
        mendenhallCourtyard.setDirections("north", burtonLawn);
        mendenhallCourtyard.setDirections("west", athleticField);
        greatQuadrangle.setDirections("east", chapinLawn);
        greatQuadrangle.setDirections("south", paradiseWoods);
        athleticField.setDirections("north", paradiseWoods);
        athleticField.setDirections("east", mendenhallCourtyard);
        paradiseWoods.setDirections("north", greatQuadrangle);
        paradiseWoods.setDirections("east", burtonLawn);
        paradiseWoods.setDirections("south", athleticField);
        // adding places to map
        places.add(chapinLawn);
        places.add(capenGarden);
        places.add(burtonLawn);
        places.add(neilsonLawn);
        places.add(mendenhallCourtyard);
        places.add(greatQuadrangle);
        places.add(athleticField);
        places.add(paradiseWoods);
    }
}