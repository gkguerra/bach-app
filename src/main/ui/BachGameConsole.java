package ui;

import model.Contestant;
import java.util.ArrayList;
import java.util.Scanner;

// This class references code from this TellerApp repository.
// Link: https://github.students.cs.ubc.ca/CPSC210/TellerApp.git

// The BachGameConsole class.
// Contains a scanner called userInput which reads input from the user in the console, an array list of contestants
// (a cast) and the initial selection, an empty string. There are four contestants instantiated currently.

public class BachGameConsole {
    private final Scanner userInput;
    private final ArrayList<Contestant> cast;
    String selection = "";
    Contestant c1 = new Contestant("Chad Smith", "Florida", 2, 0, "Eligible");
    Contestant c2 = new Contestant("Jack Bob", "Atlanta", 0, 0, "Eligible");
    Contestant c3 = new Contestant("Andrew Mah", "California", 2, 3, "Eligible");
    Contestant c4 = new Contestant("Jason Chase", "Chicago", 2, 1, "Eligible");

    // EFFECTS: Starts the console.
    public BachGameConsole() {
        cast = new ArrayList<>();
        userInput = new Scanner(System.in);
        System.out.println("WELCOME TO BachGame! The world's #1 (and only) reality TV Fantasy Football Game!");
        runBachGame();
    }

    // REQUIRES: A valid input from the user.
    // MODIFIES: The console.
    // EFFECTS: Runs the main menu, selection, and shut down process. The "framework" of the application.
    private void runBachGame() {
        boolean control = true;
        while (control) {
            displayHome();
            selection = userInput.next();
            if (selection.equals("1")) {
                displayContestants();
            }

            if (selection.equals("2")) {
                System.out.println("Here is a list of all the members of your cast!");
                displayCast();
                changeTeam();
            }

            if (selection.equals("3")) {
                control = false;
            }
        }

        System.out.println("Thank you for playing, the app will now close.");

    }

    // MODIFIES: The text display on the console.
    // EFFECTS: Displays the text for the home menu on the console.
    private void displayHome() {
        System.out.println("HOME MENU:");
        System.out.println("\tEnter 1 to view all contestants.");
        System.out.println("\tEnter 2 to view or change your cast.");
        System.out.println("\tEnter 3 to quit.");

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
        System.out.println("Enter 1 to add to your team, 2 to remove from your team, or 3 to quit");
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
            cast.add(c);
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
        System.out.println(cast);
    }
}
