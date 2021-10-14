package ui;

import model.Contestant;

import java.util.ArrayList;
import java.util.Scanner;

public class BachGameConsole {
    private Scanner scanner;
    private ArrayList<Contestant> cast;

    public BachGameConsole() {
        cast = new ArrayList<>();
        scanner = new Scanner(System.in);
        start();
    }

    private void start() {
        String selection = "";
        int numContestantsCast = 0;

        while (true) {
            System.out.println("Hello, welcome to BachGames. Please select what you would like to do, "
                    + "and enter the corresponding number into the console."
                    + "1. View contestants" + "2. View your team" + "3. Quit");
            selection = scanner.nextLine();
            System.out.println("You selected:" + selection);

            if (selection.equals("1")) {
                System.out.println("Here is a list of contestant names. Enter the corresponding number for more info.");
            }

            if (selection.equals("2")) {
                System.out.println("On your team, you currently have this many contestants:" + numContestantsCast);
                System.out.println("Would you like to add a contestant to your team? (Yes/No)");

                if (selection.equals("Yes")) {
                    System.out.println("Here is a list of contestant names. Enter their number to add them.");
                } else {
                    System.out.println("Here is your current team");
                }
            }

            if (selection.equals("3")) {
                break;
            }
        }
    }
}