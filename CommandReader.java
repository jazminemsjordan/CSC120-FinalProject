import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class CommandReader {

    // using arrays to store possible command for user friendliness
    public static String[] goInput = {"go", "g", "move", "walk", "travel", "head"};
    public static String[] directionalInput = {"north", "n", "east", "e", "south", "s", "west", "w"};
    public static String[] takeInput = {"take", "grab", "get"};
    public static String[] lookInput = {"look", "check", "examine"};
    public CommandReader() {
    }

    public static void readCommand() {
        //get command from user input
        Scanner s = new Scanner(System.in);
        String userInput = s.nextLine();
        // split commands by word into a list
        String[] splitUserInput = userInput.split(" ");
        ArrayList<String> command= new ArrayList<String>(Arrays.asList(splitUserInput));
        // remove filler words
        for (int i = 0; i < command.size(); i++) {
            String c = command.get(i);
            if (c == "at" || c == "the" || c == "to") {
                command.remove(i);
            }
        }
        // divide into first command and parameters
        String baseCommand = command.get(0);
        ArrayList<String> parameters = new ArrayList<String>();
        for (int i = 1; i < command.size(); i++) {
            parameters.add(command.get(i));
        }
        // beginning command reading
        if (Arrays.asList(goInput).contains(baseCommand) || Arrays.asList(directionalInput).contains(baseCommand)) {
            String param;
            if (Arrays.asList(directionalInput).contains(baseCommand)) {
                param = baseCommand;
            } else if (Arrays.asList(goInput).contains(baseCommand)) {
                param = parameters.get(0);
            } else {
                throw new RuntimeException("Something is wrong!");
            }
            param = param.substring(0, 0);
            if (param == "n") {
                Player.go("north");
            } else if (param == "e") {
                Player.go("east");
            } else if (param == "s") {
                Player.go("south");
            } else if (param == "w") {
                Player.go("west");
            } else {
                throw new RuntimeException("I don't know where you're trying to go!");
            }

        }
    }

}
