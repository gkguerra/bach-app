package ui;

import model.Cast;
import model.Contestant;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

// https://www.codebyamir.com/blog/sort-list-of-objects-by-field-java
// https://stackoverflow.com/questions/11160952/goto-next-iteration-in-for-loop-in-java
// https://howtodoinjava.com/java/io/java-filefilter-example/

// This class references code from this TellerApp repository.
// Link: https://github.students.cs.ubc.ca/CPSC210/TellerApp.git

// This class references code from this JsonSerializationDemo repository.
// Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// The BachGameConsole class.
// Contains a scanner called userInput which reads input from the user in the console, an array list of contestants
// (a cast) and the initial selection, an empty string. There are four contestants instantiated currently.

public class BachGameConsole {
    private static String JSON_STORE;
    private final Scanner userInput;
    private Cast cast;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    String selection = "";
    Contestant c1 = new Contestant("Chad Smith", "Florida", 2, 0, "Eligible");
    Contestant c2 = new Contestant("Jack Bob", "Atlanta", 0, 0, "Eligible");
    Contestant c3 = new Contestant("Andrew Mah", "California", 2, 3, "Eligible");
    Contestant c4 = new Contestant("Jason Chase", "Chicago", 2, 1, "Eligible");

    // EFFECTS: Starts the console.
    public BachGameConsole() throws FileNotFoundException {
        userInput = new Scanner(System.in);
        System.out.println("WELCOME TO BachApp! The world's #1 (and only) reality TV Fantasy Football Game!");
        startBachGame();
    }

    private void startBachGame() {
        System.out.println("Enter 1 to create a new account or 2 to log in to an existing account.");
        selection = userInput.next();
        if (selection.equals("1")) {
            System.out.println("What is your name?");
            selection = userInput.next();
            cast = new Cast(selection, 1234);
            System.out.println("Hi " + cast.getCastName() + "! Your account has been created.");
            JSON_STORE = "./data/" + cast.getCastName() + ".json";
            jsonWriter = new JsonWriter(JSON_STORE);
            jsonReader = new JsonReader(JSON_STORE);
            runBachGame();
        } else if (selection.equals("2")) {
            System.out.println("What is the name of your account?");
            selection = userInput.next();
            JSON_STORE = "./data/" + selection + ".json";
            jsonWriter = new JsonWriter(JSON_STORE);
            jsonReader = new JsonReader(JSON_STORE);
            loadCast();
        }
    }

    // REQUIRES: A valid input from the user.
    // MODIFIES: The console.
    // EFFECTS: Runs the main menu, selection, and shut down process. The "framework" of the application.
    private void runBachGame() {
        boolean control = true;

        while (control) {
            displayHome();
            selection = userInput.next();

            if (selection.equals("4")) {
                System.out.println("Would you like to save your cast? (yes/no)");
                selection = userInput.next();
                if (selection.equals("yes")) {
                    saveCast();
                    System.out.println("Your cast has been saved!");
                    control = false;
                }

            } else {
                processSelection(selection);
            }
        }
        System.out.println("Thank you for playing, the app will now close.");
    }

    public void processSelection(String selection) {
        if (selection.equals("1")) {
            displayContestants();
        } else if (selection.equals("2")) {
            System.out.println("Here is a list of all the members of your cast!");
            displayCast();
            changeTeam();
        } else if (selection.equals("3")) {
            System.out.println("Here is the leaderboard! Look for your name!");
            displayLeaderboard();
        } else {
            System.out.println("Selection is not valid.");
        }
    }


    // MODIFIES: The text display on the console.
    // EFFECTS: Displays the text for the home menu on the console.
    private void displayHome() {
        System.out.println("HOME MENU:");
        System.out.println("\tEnter 1 to view all contestants.");
        System.out.println("\tEnter 2 to view or change your cast.");
        System.out.println("\tEnter 3 to view leaderboard.");
        System.out.println("\tEnter 4 to quit.");

    }

    // MODIFIES: The text display on the console.
    // EFFECTS: Displays the list of ALL contestants on the console.
    private void displayContestants() {
        System.out.println("Here is a list of all contestants.");
        System.out.println("\tChad Smith");
        System.out.println("\tJack Bob");
        System.out.println("\tAndrew Mah");
        System.out.println("\tJason Chase");
    }

    // REQUIRES: A valid input from the user.
    // MODIFIES: The console.
    // EFFECTS: Displays the text for the home menu on the application.
    private void changeTeam() {
        System.out.println("Enter 1 to add to your team, 2 to remove from your team, or 3 to return to the main menu.");
        selection = userInput.next();

        if (selection.equals("1")) {
            addContestant();
        }

        if (selection.equals("2")) {
            removeContestant();
        }
    }

    // REQUIRES: A valid input from the user.
    // MODIFIES: A user's cast.
    // EFFECTS: Shows all the contestants on the console and then adds the selected contestant.
    private void addContestant() {
        System.out.println("Which contestant would you like to add? Enter their first name or enter 3 to quit.");
        displayContestants();
        selection = userInput.next();

        if (selection.equals("Chad")) {
            easyAdd(c1);
        }

        if (selection.equals("Jack")) {
            easyAdd(c2);
        }

        if (selection.equals("Andrew")) {
            easyAdd(c3);
        }

        if (selection.equals("Jason")) {
            easyAdd(c4);
        }
    }

    // REQUIRES: A contestant c.
    // MODIFIES: The cast list.
    // EFFECTS: Adds the contestant to the cast list, and displays the users new cast.
    private void easyAdd(Contestant c) {
        if (cast.size() >= 3) {
            System.out.println("You already have three contestants on your cast. Please remove one before adding.");
        }

        if (cast.contains(c)) {
            System.out.println("You already have this contestant on your cast. Please choose a different one.");
        }

        if ((cast.size() < 3) && (!cast.contains(c))) {
            cast.addContestant(c);
            System.out.println("Here is your new cast list.");
            displayCast();
        }
    }

    // REQUIRES: A valid input from the user.
    // MODIFIES: A user's cast.
    // EFFECTS: Shows all the contestants on the console and then removes the selected contestant.
    private void removeContestant() {
        System.out.println("Which contestant would you like to remove? Enter their first name");
        displayCast();
        selection = userInput.next();
        if (selection.equals("Chad")) {
            easyRemove(c1);
        }
        if (selection.equals("Jack")) {
            easyRemove(c2);
        }
        if (selection.equals("Andrew")) {
            easyRemove(c3);
        }
        if (selection.equals("Jason")) {
            easyRemove(c4);
        }
    }

    // REQUIRES: A contestant c.
    // MODIFIES: The cast list.
    // EFFECTS: Removes the contestant to the cast list, and displays the users new cast.
    private void easyRemove(Contestant c) {
        cast.remove(c);
        System.out.println("Here is your new cast list.");
        displayCast();
    }

    // MODIFIES: The text display on the console.
    // EFFECTS: Displays a user's cast.
    private void displayCast() {
        for (Contestant c : cast.getContestants()) {
            System.out.println(c.getName());
        }
    }

    // EFFECTS: Loads a Cast from JSON, throws an IOException if it cannot read the file
    private void loadCast() {
        try {
            cast = jsonReader.read();
            System.out.println("Loaded your cast from " + JSON_STORE);
            runBachGame();
        } catch (IOException e) {
            System.out.println("Unable to read from file " + JSON_STORE);
        }
    }

    // EFFECTS: Saves the Cast to JSON, throws FileNotFoundException if it cannot write to the file
    private void saveCast() {
        try {
            jsonWriter.open();
            jsonWriter.write(cast);
            jsonWriter.close();
            System.out.println("Saved to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file " + JSON_STORE);
        }
    }

    // This method references code from this StackOverflow Post.
    // Link: https://stackoverflow.com/questions/5694385/getting-the-filenames-of-all-files-in-a-folder
    // ADD SIGNATURE and TESTS
    private void displayLeaderboard() {
        File folder = new File("./data");
        File[] listOfFiles = folder.listFiles();
        List<Cast> listOfCasts = new ArrayList<>();
        List<String> listOfCastRows = new ArrayList<>();

        for (File f : listOfFiles) {
            jsonReader = new JsonReader("./data/" + f.getName());
            if (f.getName().contains("test") || f.getName().contains("image")) {
                continue;
            } else {
                try {
                    listOfCasts.add(jsonReader.read());
                } catch (IOException e) {
                    System.out.println("IO Exception thrown.");
                }
            }
        }

        listOfCasts.sort(Comparator.comparing(Cast::calculateCastScore));
        System.out.println(listOfCasts);
    }

}
