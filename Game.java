import java.util.ArrayList;

public class Game {

    static boolean end = false;
    static int turns = 0;
    static double totalPoints = 0;
    static ArrayList<Place> placesHidden = new ArrayList<Place>();

    /* only one game, share everything */
    public Game() {
    }

    /**
     * Method to print the game introduction
     */
    public static void printIntroduction() {
        
    }

    /** 
     * Method to calculate final score and print ending
     */
    public static void tallyPoints() {
        double basePoints = 0;
        for (int i = 0; i < 12; i++) {
            // check if each snack in the list is hidden or not 
            if (Player.hiddenSnacks.containsKey(Assets.masterSnacks.get(i))) {
                // if it is hidden, retrieve it and get the hiding spot and values
                Snack s = Assets.masterSnacks.get(i);
                int sValue = s.getSnackValue();
                HidingSpot h = s.getStashedAt();
                double hValue = h.getValue();
                // point calculations
                double totalValue = hValue * sValue;
                basePoints += totalValue;
                // get the place associated with the hiding spot
                Place p = h.getPlace();
                // if the place is not already on the list, add it
                if (!placesHidden.contains(p)) {
                    placesHidden.add(p);
                }
            }
        }
        int diversityValue = placesHidden.size();
        if (diversityValue < 4) {
            totalPoints = basePoints * 0.7;
        } else if (diversityValue == 4) {
            totalPoints = basePoints * 0.8;
        } else if (diversityValue == 5) {
            totalPoints = basePoints * 0.9;
        } else if (diversityValue == 6) {
            totalPoints = basePoints * 1.0;
        } else if (diversityValue == 7) {
            totalPoints = basePoints * 1.1;
        } else if (diversityValue == 8) {
            totalPoints = basePoints * 1.2;
        } else if (diversityValue > 8) {
            throw new RuntimeException("Something is wrong.");
        }
    }

    /**
     * Method to print the number of turns taken to finish game
     */
    public static void printTurns() {
        System.out.println("You finished the game in: " + turns + " commands.");
    }

    /**
     * Main method, runs game loop
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Initializing game...");
        Assets.initializeObjects();
        CampusMap.initializePlaces();
        System.out.println("Success!");
        while (end == false) {
            try {
                CommandReader.readCommand();
                turns += 1;
            } catch(RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        CommandReader.inputScanner.close();
        tallyPoints();
        printTurns();
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
