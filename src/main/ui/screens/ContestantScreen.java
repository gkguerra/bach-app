package ui.screens;

import model.Contestant;
import ui.BachGameGUI;

import javax.swing.*;
import java.awt.*;

public class ContestantScreen extends Screen {
    private static final String INIT_GREETING = "Here are all the contestants competing for Michelle's heart!";
    private JLabel greeting;

    Contestant c1 = new Contestant("Alec", "North Charleston", 2, 0, "Eligible");
    Contestant c2 = new Contestant("Brandon", "Portland", 0, 0, "Eligible");
    Contestant c3 = new Contestant("Bryan", "Chicago", 2, 3, "Eligible");
    Contestant c4 = new Contestant("Casey", "Miami Beach", 2, 1, "Eligible");
    Contestant c5 = new Contestant("Chris", "Halifax", 2, 3, "Eligible");
    Contestant c6 = new Contestant("Clayton", "Columbia", 2, 1, "Eligible");
    Contestant c7 = new Contestant("Daniel", "Austin", 2, 3, "Eligible");
    Contestant c8 = new Contestant("Edward", "Los Angeles", 2, 1, "Eligible");

    public ContestantScreen(BachGameGUI controller) {
        super(controller);

        placeGreeting();
        displayContestants();
    }

    //EFFECTS: creates greeting at top of console
    private void placeGreeting() {
        greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        greeting.setSize(WIDTH, HEIGHT / 3);
        this.add(greeting);
    }

    private void displayContestants() {
        GridLayout layout = new GridLayout(3,3);
        setLayout(layout);
        this.add(new JButton("Alec"));
        this.add(new JButton("Brandon"));
        this.add(new JButton("Bryan"));
        this.add(new JButton("Casey"));
        this.add(new JButton("Chris"));
        this.add(new JButton("Clayton"));
        this.add(new JButton("Daniel"));
        this.add(new JButton("Edward"));
    }
}
