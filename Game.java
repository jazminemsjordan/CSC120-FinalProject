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
        System.out.println("It's a beautiful fall Mountain Day at Smith College. Birds are singing, the sun is shining, students are frolicking on the lawn and eating donuts, and ");
        System.out.println("you, a dastardly campus squirrel, are here to take advantage of the chaos of cancelled classes. Your objective? Collect as much food as possible ");
        System.out.println("throughout campus and stash it to prepare yourself for the unforgiving Massachusetts winter. You will be given points based on how many food ");
        System.out.println("items you collect, their value (bigger, better snacks are worth more), and how well you hide your goodies from other thieving squirrels. Beware! ");
        System.out.println("These point values are hidden until the game is over; you'll have to use your best judgement to make choices. When you've finished your squirrely ");
        System.out.println("escapades, return to your nest in Chapin. I'll tally up your points and reveal how well prepared you are for winter!");
        System.out.println();
        System.out.println("TIPS:");
        System.out.println("    - use the hiding spot descriptions to decide which places are the best to hide something");
        System.out.println("    - save your best hiding spots for the best food");
        System.out.println("    - don't hide all your snacks in the same place");
        System.out.println("    - type 'help' to get a list of commands");
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
        }
        if (Player.hiddenSnacks.size() == 12 && totalPoints < 90) {
            System.out.println("Well, I'll be. You did... well, points for effort, I guess? I'll be honest, I've never seen something like this before.");
            System.out.println("You diligently collected every single snack there is to find, but your hiding spot choices were so awful, most of your food was stolen.");
            System.out.println("However, while you might not be the most intelligent squirrel (why did you hide those there??), your work ethic is admirable.");
            System.out.println("The admissions office is deeply moved by your efforts to succeed, and you become the first squirrel admitted to Smith College.");
            System.out.println("After eight grueling semesters of studying, you proudly graduate with a degree in Squirrel Psychology.");
            System.out.println("With your newfound wisdom, you have a bright future ahead of you. Hopefully with better hidden snacks.");
            System.out.println("Secret Ending 8/8");
        }
         else if (totalPoints > 200) {
            System.out.println("Fantastic job! You collected all the snacks and hid them perfectly.");
            System.out.println("You become the most famous squirrel on campus due to your snack stashing prowess. Everyone wants to hear your sage advice for preparing for the winter.");
            System.out.println("Ending 1/8");
        } else if (totalPoints > 180) {
            System.out.println("Great job! You're more than well prepared for the upcoming winter.");
            System.out.println("You have so much food left over you share them with all your squirrel friends.");
            System.out.println("Ending 2/8");
        } else if (totalPoints > 150) {
            System.out.println("Good job! You're well prepared for the upcoming winter.");
            System.out.println("You have a wonderful winter stuffing yourself with treats.");
            System.out.println("Ending 3/8");
        } else if (totalPoints > 120) {
            System.out.println("Not bad! You could have done better, but you've got enough food.");
            System.out.println("Your winter is quiet, comfortable, and uneventful.");
            System.out.println("Ending 4/8");
        } else if (totalPoints > 60) {
            System.out.println("Oof! Maybe you just don't have enough snacks, or you didn't hide them well, but you're not very well prepared for winter.");
            System.out.println("You survive okay, but it's a tough for you. You resolve to do better next year.");
            System.out.println("Ending 5/8");
        } else if (totalPoints > 0.01) {
            System.out.println("Uh-oh! You're completely unprepared! You have barely any food.");
            System.out.println("It's a long, hungry winter for you, and you come out the other side a much thinner, battle worn squirrel. Better luck next year!");
            System.out.println("Ending 6/8");
        } else {
            System.out.println("How did you not collect ANYTHING for the upcoming winter? Not a single peanut! Did you not even try?");
            System.out.println("Because of your careless actions, an innocent squirrel (you) starved to death over the winter. I hope you're happy.");
            System.out.println("Ending 7/8");
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
        Player.initializeCommands();
        System.out.println("Success!");
        printIntroduction();
        while (end == false) {
            try {
                CommandReader.readCommand();
                System.out.println("--------------------------------------------");
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
