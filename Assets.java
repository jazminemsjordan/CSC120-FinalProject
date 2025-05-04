import java.util.ArrayList;
public class Assets {
    // essentially a campus map for items and snacks
    // main creates all items and sets use cases
    static ArrayList<Item> masterItems = new ArrayList<Item>();
    static ArrayList<Snack> masterSnacks = new ArrayList<Snack>(); 
    static ArrayList<HidingSpot> masterHidingSpots = new ArrayList<HidingSpot>();

    public static void initializeObjects() {
        //create snacks
        Snack spaghetti = new Snack("Spaghetti", "prop spaghetti", true, CampusMap.mendenhallCourtyard, 20);
        Snack sushi = new Snack("Sushi Roll", "compass sushi", true, CampusMap.neilsonLawn, 15);
        Snack donut = new Snack("Maple Bar", "mountain day donut", true, CampusMap.chapinLawn, 12);
        Snack sandwich = new Snack("Grilled Cheese", "grilled cheese sandwich", true, CampusMap.capenGarden, 10);
        Snack bagel = new Snack("Bagel", "sleepy quad student bagel", true, CampusMap.greatQuadrangle, 10);
        Snack chicken = new Snack("Drumstick", "chicken drumstick", true, CampusMap.greatQuadrangle, 10);
        Snack cookie = new Snack("Chocolate Chip Cookie", "chapin cookies", true, CampusMap.chapinLawn, 10);
        Snack granola = new Snack("Protein Bar", "soccer player granola bar", true, CampusMap.athleticField, 10);
        Snack plum = new Snack("Wild Plum", "wild fruit tree", true, CampusMap.paradiseWoods, 8);
        Snack berry = new Snack("Wild Raspberries", "a couple wild raspberries", true, CampusMap.paradiseWoods, 7);
        Snack apple = new Snack("Apple Core", "garbage can apple core", true, CampusMap.burtonLawn, 5);
        Snack peanut = new Snack("Peanut", "tossed peanut from theater student", true, CampusMap.mendenhallCourtyard, 3);
        // add snacks to master list
        masterSnacks.add(spaghetti);
        masterSnacks.add(sushi);
        masterSnacks.add(donut);
        masterSnacks.add(sandwich);
        masterSnacks.add(bagel);
        masterSnacks.add(chicken);
        masterSnacks.add(cookie);
        masterSnacks.add(granola);
        masterSnacks.add(plum);
        masterSnacks.add(berry);
        masterSnacks.add(apple);
        masterSnacks.add(peanut);
        // create hiding spots
        HidingSpot chapin1 = new HidingSpot("Chapin hiding spot 1", "", CampusMap.chapinLawn, 1.25);
        HidingSpot chapin2 = new HidingSpot("Chapin hiding spot 2", "", CampusMap.chapinLawn, 1.0);
        HidingSpot chapin3 = new HidingSpot("Chapin hiding spot 3", "", CampusMap.chapinLawn, 1.0);
        HidingSpot capen1 = new HidingSpot("Capen hiding spot 1", "under gazebo", CampusMap.capenGarden, 1.5);
        HidingSpot capen2 = new HidingSpot("Capen hiding spot 2", "porch", CampusMap.capenGarden, 1.5);
        HidingSpot capen3 = new HidingSpot("Capen hiding spot 3", "", CampusMap.capenGarden, 1.25);
        HidingSpot burton1 = new HidingSpot("Burton hiding spot 1", "", CampusMap.burtonLawn, 1.5);
        HidingSpot burton2 = new HidingSpot("Burton hiding spot 2", "", CampusMap.burtonLawn, 1.0);
        HidingSpot burton3 = new HidingSpot("Burton hiding spot 3", "", CampusMap.burtonLawn, 1.0);
        HidingSpot neilson1 = new HidingSpot("Neilson hiding spot 1", "", CampusMap.neilsonLawn, 1.25);
        HidingSpot neilson2 = new HidingSpot("Neilson hiding spot 2", "", CampusMap.neilsonLawn, 1.0);
        HidingSpot neilson3 = new HidingSpot("Neilson hiding spot 3", "", CampusMap.neilsonLawn, 0.75);
        HidingSpot mendenhall1 = new HidingSpot("Mendenhall hiding spot 1", "", CampusMap.mendenhallCourtyard, 1.5);
        HidingSpot mendenhall2 = new HidingSpot("Mendenhll hiding spot 2", "", CampusMap.mendenhallCourtyard, 1.25);
        HidingSpot mendenhall3 = new HidingSpot("Mendenhall hiding spot 3", "", CampusMap.mendenhallCourtyard, 1.0);
        HidingSpot quad1 = new HidingSpot("Quad hiding spot 1", "", CampusMap.greatQuadrangle, 1.0);
        HidingSpot quad2 = new HidingSpot("Quad hiding spot 2", "", CampusMap.greatQuadrangle, 0.75);
        HidingSpot quad3 = new HidingSpot("Quad hiding spot 3", "", CampusMap.greatQuadrangle, 0.75);
        HidingSpot athletic1 = new HidingSpot("Field hiding spot 1", "", CampusMap.athleticField, 1.25);
        HidingSpot athletic2 = new HidingSpot("Field hiding spot 2", "", CampusMap.athleticField, 0.75);
        HidingSpot athletic3 = new HidingSpot("Field hiding spot 3", "", CampusMap.athleticField, 0.75);
        HidingSpot paradise1 = new HidingSpot("Woods hiding spot 1", "", CampusMap.paradiseWoods, 1.5);
        HidingSpot paradise2 = new HidingSpot("Woods hiding spot 2", "", CampusMap.paradiseWoods, 1.5);
        HidingSpot paradise3 = new HidingSpot("Woods hiding spot 3", "", CampusMap.paradiseWoods, 1.25);
        // add hiding spots to master list
        masterHidingSpots.add(chapin1);
        masterHidingSpots.add(chapin2);
        masterHidingSpots.add(chapin3);
        masterHidingSpots.add(capen1);
        masterHidingSpots.add(capen2);
        masterHidingSpots.add(capen3);
        masterHidingSpots.add(burton1);
        masterHidingSpots.add(burton2);
        masterHidingSpots.add(burton3);
        masterHidingSpots.add(neilson1);
        masterHidingSpots.add(neilson2);
        masterHidingSpots.add(neilson3);
        masterHidingSpots.add(mendenhall1);
        masterHidingSpots.add(mendenhall2);
        masterHidingSpots.add(mendenhall3);
        masterHidingSpots.add(quad1);
        masterHidingSpots.add(quad2);
        masterHidingSpots.add(quad3);
        masterHidingSpots.add(athletic1);
        masterHidingSpots.add(athletic2);
        masterHidingSpots.add(athletic3);
        masterHidingSpots.add(paradise1);
        masterHidingSpots.add(paradise2);
        masterHidingSpots.add(paradise3);
        }
}
