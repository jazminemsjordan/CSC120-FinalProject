import java.util.ArrayList;

public class CampusMap {

    static ArrayList<Place> places = new ArrayList<Place>();
    
    //setting up places
    static Place chapinLawn = new Place("Chapin Lawn", true, "Students frolic on the beautiful lawn outside Chapin house.");
    static Place capenGarden = new Place("Capen Garden", true, "The garden is quiet and peaceful, mostly empty of students.");
    static Place burtonLawn = new Place("Burton Lawn", true, "This lawn outside the science buildings is mostly empty during mountain day.");
    static Place neilsonLawn = new Place("Neilson Lawn", false, "Outside the library, students sit reading on the lawn.");
    static Place mendenhallCourtyard = new Place("Mendenhall Courtyard", true, "description");
    static Place greatQuadrangle = new Place("Great Quadrangle", true, "The quad is packed with students, as usual.");
    static Place athleticField = new Place("Athletic Field", true, "The athletic field is completely deserted: guess the athletes are out celebrating Mountain Day.");
    static Place paradiseWoods = new Place("Paradise Woods", true, "The woods by the pond are serene.");

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
        //setting place hiding spots
        chapinLawn.addHidingSpots(Assets.masterHidingSpots.get(0), Assets.masterHidingSpots.get(1), Assets.masterHidingSpots.get(2));
        capenGarden.addHidingSpots(Assets.masterHidingSpots.get(3), Assets.masterHidingSpots.get(4), Assets.masterHidingSpots.get(5));
        burtonLawn.addHidingSpots(Assets.masterHidingSpots.get(6), Assets.masterHidingSpots.get(7), Assets.masterHidingSpots.get(8));
        neilsonLawn.addHidingSpots(Assets.masterHidingSpots.get(9), Assets.masterHidingSpots.get(10), Assets.masterHidingSpots.get(11));
        mendenhallCourtyard.addHidingSpots(Assets.masterHidingSpots.get(12), Assets.masterHidingSpots.get(13), Assets.masterHidingSpots.get(14));
        greatQuadrangle.addHidingSpots(Assets.masterHidingSpots.get(15), Assets.masterHidingSpots.get(16), Assets.masterHidingSpots.get(17));
        athleticField.addHidingSpots(Assets.masterHidingSpots.get(18), Assets.masterHidingSpots.get(19), Assets.masterHidingSpots.get(20));
        paradiseWoods.addHidingSpots(Assets.masterHidingSpots.get(21), Assets.masterHidingSpots.get(22), Assets.masterHidingSpots.get(23));
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