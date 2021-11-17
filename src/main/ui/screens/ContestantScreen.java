package ui.screens;

import model.Contestant;
import ui.BachGameGUI;

import javax.swing.*;
import java.awt.*;

public class ContestantScreen extends Screen {
    private static final String INIT_GREETING = "Here are all the contestants competing for Michelle's heart!";
    private JLabel greeting;

    ImageIcon alec = new ImageIcon("data/images/alec.jpeg");
    ImageIcon brandon = new ImageIcon("data/images/brandon.png");
    ImageIcon bryan = new ImageIcon("data/images/bryan.jpeg");
    ImageIcon casey = new ImageIcon("data/images/casey.jpeg");
    ImageIcon chris = new ImageIcon("data/images/chris.jpeg");
    ImageIcon clayton = new ImageIcon("data/images/clayton.jpeg");
    ImageIcon daniel = new ImageIcon("data/images/daniel.jpeg");
    ImageIcon edward = new ImageIcon("data/images/edward.jpeg");

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
        this.add(new JButton("Alec", alec));
        this.add(new JButton("Brandon", brandon));
        this.add(new JButton("Bryan", bryan));
        this.add(new JButton("Casey", casey));
        this.add(new JButton("Chris", chris));
        this.add(new JButton("Clayton", clayton));
        this.add(new JButton("Daniel", daniel));
        this.add(new JButton("Edward", edward));
    }
}
