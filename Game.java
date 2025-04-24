import java.util.Hashtable;

public class Game {

    static boolean end = false;
    static int turns = 0;

    /* only one game, share everything */
    public Game() {
    }

    public static void tallyPoints() {
    }

    public static void printTurns() {
        System.out.println("You finished the game in: " + turns + " commands.");
    }

    public static void main() {
        System.out.println("Initializing game...");
        CampusMap.initializePlaces();
        Assets.initializeObjects();
        System.out.println("Success!");
        while (end = false) {
            CommandReader.readCommand();
            turns += 1;
        }
        tallyPoints();
        printTurns();
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
