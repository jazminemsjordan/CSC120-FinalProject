import java.util.ArrayList;
import com.google.common.graph.*;

public class CampusMap {

    static ArrayList<Place> places = new ArrayList<Place>();

    /* Empty constructor */
    // I will only have one map, initialized at the beginning of the program, so a lot of static stuff
    public CampusMap() {
    }

    public void printDirectory() {
        for (int i = 0; i < places.size(); i ++) {
            System.out.println((i+1) + ". " + places.get(i).getName());
        }
    }

    public static void initializePlaces() { 
        //setting up places
        Place chapinLawn = new Place("Chapin Lawn", true, "description");
        Place capenGarden = new Place("Capen Garden", true, "description");
        Place burtonLawn = new Place("Burton Lawn", true, "description");
        Place neilsonLawn = new Place("Neilson Lawn", false, "description");
        Place mendenhallCourtyard = new Place("Mendenhall Courtyard", true, "description");
        Place greatQuadrangle = new Place("Great Quadrangle", true, "description");
        Place athleticField = new Place("Athletic Field", true, "description");
        Place paradiseWoods = new Place("Paradise Woods", true, "description");
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