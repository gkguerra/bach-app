package ui;

import model.Contestant;
import java.util.ArrayList;
import java.util.Scanner;

// this console interface was written with help from the Teller project presented in class

public class BachGameConsole {
    private final Scanner userInput;
    private final ArrayList<Contestant> cast;
    String selection = "";
    Contestant c1 = new Contestant("Chad Smith", "Florida", 2, 0, "Eligible");
    Contestant c2 = new Contestant("Jack Bob", "Atlanta", 0, 0, "Eligible");
    Contestant c3 = new Contestant("Andrew Mah", "California", 2, 3, "Eligible");
    Contestant c4 = new Contestant("Jason Chase", "Chicago", 2, 1, "Eligible");

    public BachGameConsole() {
        cast = new ArrayList<>();
        userInput = new Scanner(System.in);
        runBachGame();
    }

    private void runBachGame() {
        boolean control = true;
        while (control) {
            displayHome();
            selection = userInput.next();
            if (selection.equals("1")) {
                displayContestants();
            }

            if (selection.equals("2")) {
                System.out.println("Here is a list of all the members of your team");
                displayCast();
                changeTeam();
            }

            if (selection.equals("3")) {
                control = false;
            }
        }

        System.out.println("Thank you for playing, the app will now close.");

    }

    private void displayHome() {
        System.out.println("Enter 1 to view all contestants.");
        System.out.println("Enter 2 to view your cast.");
        System.out.println("Enter 3 to quit.");

    }

    private void displayContestants() {
        System.out.println("Here is a list of all contestants.");
        System.out.println("\tChad Smith");
        System.out.println("\tJack Bob");
        System.out.println("\tAndrew Mah");
        System.out.println("\tJason Chase");
    }

    private void displayCast() {
        System.out.println(cast);
    }

    private void changeTeam() {
        actionChosen();
        if (selection.equals("a")) {
            addContestant();
        }

        if (selection.equals("r")) {
            removeContestant();
        }
    }

    private void actionChosen() {
        System.out.println("Enter a to add to your team, r to remove from your team");
        selection = userInput.next();
    }

    private void addContestant() {
        System.out.println("Which contestant would you like to add? Enter their first name.");
        displayContestants();
        selection = userInput.next();

        if (selection.equals("Chad")) {
            cast.add(c1);
            System.out.println("Here is your new cast list.");
            displayCast();
        }

        if (selection.equals("Jack")) {
            cast.add(c2);
            System.out.println("Here is your new cast list.");
            displayCast();
        }

        if (selection.equals("Andrew")) {
            cast.add(c3);
            System.out.println("Here is your new cast list.");
            displayCast();
        }

        if (selection.equals("Jason")) {
            cast.add(c4);
            System.out.println("Here is your new cast list.");
            displayCast();
        }
    }

    private void removeContestant() {
        System.out.println("Which contestant would you like to remove? Enter their first name");
        displayCast();
        selection = userInput.next();
        if (selection.equals("Chad")) {
            cast.remove(c1);
            System.out.println("Here is your new cast list.");
            displayCast();
        }
        if (selection.equals("Jack")) {
            cast.remove(c2);
        }
        if (selection.equals("Andrew")) {
            cast.remove(c3);
        }
        if (selection.equals("Jason")) {
            cast.remove(c4);
        }
    }
}