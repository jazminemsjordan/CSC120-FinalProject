import java.util.ArrayList;
public class Assets {
    // essentially a campus map for items and snacks
    // main creates all items and sets use cases
    static ArrayList<Item> masterItems = new ArrayList<Item>();
    static ArrayList<Snack> masterSnacks = new ArrayList<Snack>(); 
    static ArrayList<HidingSpot> masterHidingSpots = new ArrayList<HidingSpot>();

    /*
     * Method to create all games objects and add them to their respective lists
     */
    public static void initializeObjects() {
        //create snacks
        Snack spaghetti = new Snack("Spaghetti", "A large, messy plate of spaghetti. How are you able to transport it so easily? Who knows!", false, CampusMap.mendenhallCourtyard, 20);
        Snack sushi = new Snack("Sushi Roll", "A delicious Compass Cafe sushi roll. These are highly prized by students.", true, CampusMap.neilsonLawn, 15);
        Snack donut = new Snack("Maple Bar", "A sugary maple bar. A great way to start the day!", true, CampusMap.chapinLawn, 12);
        Snack sandwich = new Snack("Grilled Cheese", "Half of a grilled cheese sandwich you stole from some unsuspecting student's picnic.", true, CampusMap.capenGarden, 10);
        Snack bagel = new Snack("Bagel", "This plain bagel was easily stolen from a sleepy student. You snooze, you lose!", true, CampusMap.greatQuadrangle, 10);
        Snack chicken = new Snack("Drumstick", "A crispy chicken drumstick, courtesy of Grubhub Delivery.", false, CampusMap.greatQuadrangle, 10);
        Snack cookie = new Snack("Chocolate Chip Cookie", "You're not exactly sure how this cookie got on the roof, but it's yours now.", false, CampusMap.chapinLawn, 10);
        Snack granola = new Snack("Protein Bar", "A crunchy, nutty granola bar, packed with protein.", true, CampusMap.athleticField, 10);
        Snack plum = new Snack("Wild Plum", "A small plum you picked from a wild tree.", true, CampusMap.paradiseWoods, 8);
        Snack berry = new Snack("Wild Raspberries", "A small handful of raspberries. Not very filling, but tasty.", false, CampusMap.paradiseWoods, 7);
        Snack apple = new Snack("Apple Core", "You took this apple core from the garbage. Not exactly gourmet, but a squirrel's gotta eat!", true, CampusMap.burtonLawn, 5);
        Snack peanut = new Snack("Peanut", "A stingy student gave you one single peanut. Better than nothing, you suppose.", true, CampusMap.mendenhallCourtyard, 3);
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
        // create items
        Item whistle = new Item("Whistle", "A small whistle. You could use these to call for some squirrel friends.", CampusMap.athleticField, true, CampusMap.paradiseWoods);
        Item knife = new Item("Pocket Knife", "A tiny pocket knife, perfect for small squirrel paws. Careful, it's sharp!", CampusMap.paradiseWoods, true, CampusMap.greatQuadrangle);
        Item file = new Item("Nail File", "A little nail file. Could you use this on your claws?", CampusMap.neilsonLawn, true, CampusMap.chapinLawn);
        Item screwdriver = new Item("Screwdriver", "A small screwdriver. You could get into some real mischief with this!", CampusMap.capenGarden, true, CampusMap.mendenhallCourtyard);
        Item helmet = new Item("Hard Hat", "A miniature hard hat, perfectly sized for a squirrel. Safety first!", CampusMap.mendenhallCourtyard, true, CampusMap.burtonLawn);
        // add items to master list
        masterItems.add(whistle);
        masterItems.add(knife);
        masterItems.add(file);
        masterItems.add(screwdriver);
        masterItems.add(helmet);
        // create hiding spots
        HidingSpot chapin1 = new HidingSpot("Chapin Hiding Spot 1", "among the bushes near Chapin House", CampusMap.chapinLawn, 1.25);
        HidingSpot chapin2 = new HidingSpot("Chapin Hiding Spot 2", "by the bike rack by the campus center", CampusMap.chapinLawn, 1.0);
        HidingSpot chapin3 = new HidingSpot("Chapin Hiding Spot 3", "under a plastic chair on the lawn", CampusMap.chapinLawn, 1.0);
        HidingSpot capen1 = new HidingSpot("Capen Hiding Spot 1", "behind the watchful owl statue", CampusMap.capenGarden, 1.5);
        HidingSpot capen2 = new HidingSpot("Capen Hiding Spot 2", "below the porch stairs", CampusMap.capenGarden, 1.5);
        HidingSpot capen3 = new HidingSpot("Capen Hiding Spot 3", "inside the garden gazebo", CampusMap.capenGarden, 1.25);
        HidingSpot burton1 = new HidingSpot("Burton Hiding Spot 1", "in the Sabin-Reed rock garden", CampusMap.burtonLawn, 1.5);
        HidingSpot burton2 = new HidingSpot("Burton Hiding Spot 2", "in the flowerbed outside Burton Hall", CampusMap.burtonLawn, 1.0);
        HidingSpot burton3 = new HidingSpot("Burton Hiding Spot 3", "beside the big tree in the center of the lawn", CampusMap.burtonLawn, 1.0);
        HidingSpot neilson1 = new HidingSpot("Neilson Hiding Spot 1", "on one of the Seelyee balconies", CampusMap.neilsonLawn, 1.25);
        HidingSpot neilson2 = new HidingSpot("Neilson Hiding Spot 2", "in the construction rubble", CampusMap.neilsonLawn, 1.0);
        HidingSpot neilson3 = new HidingSpot("Neilson Hiding Spot 3", "on the squirrel picnic table on the lawn", CampusMap.neilsonLawn, 0.75);
        HidingSpot mendenhall1 = new HidingSpot("Mendenhall Hiding Spot 1", "in the ivy covered trench beside Sage Hall", CampusMap.mendenhallCourtyard, 1.5);
        HidingSpot mendenhall2 = new HidingSpot("Mendenhall Hiding Spot 2", "buried under the cherry tree", CampusMap.mendenhallCourtyard, 1.25);
        HidingSpot mendenhall3 = new HidingSpot("Mendenhall Hiding Spot 3", "on the roof of performing arts library", CampusMap.mendenhallCourtyard, 1.0);
        HidingSpot quad1 = new HidingSpot("Quad Hiding Spot 1", "buried in the Comstock-Haynes courtyard", CampusMap.greatQuadrangle, 1.0);
        HidingSpot quad2 = new HidingSpot("Quad Hiding Spot 2", "under an outdoor dining table", CampusMap.greatQuadrangle, 0.75);
        HidingSpot quad3 = new HidingSpot("Quad Hiding Spot 3", "in the very center of the quadrangle", CampusMap.greatQuadrangle, 0.75);
        HidingSpot athletic1 = new HidingSpot("Field Hiding Spot 1", "buried in the track and field long jump pit", CampusMap.athleticField, 1.25);
        HidingSpot athletic2 = new HidingSpot("Field Hiding Spot 2", "under the bleachers at the softball field", CampusMap.athleticField, 0.75);
        HidingSpot athletic3 = new HidingSpot("Field Hiding Spot 3", "high in the rafters of the field house", CampusMap.athleticField, 0.75);
        HidingSpot paradise1 = new HidingSpot("Woods Hiding Spot 1", "protected by prickly blackberry bushes", CampusMap.paradiseWoods, 1.5);
        HidingSpot paradise2 = new HidingSpot("Woods Hiding Spot 2", "inside a hollowed, fallen tree", CampusMap.paradiseWoods, 1.5);
        HidingSpot paradise3 = new HidingSpot("Woods Hiding Spot 3", "in the reeds by the edge of the pond", CampusMap.paradiseWoods, 1.25);
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
