package ui.screens;

import ui.BachGameJFrame;

import javax.swing.*;
import java.awt.*;

// This class and methods within this class references code and information from the following sources:
// https://stackoverflow.com/questions/26420428/how-to-word-wrap-text-in-jlabel
// Link: https://github.students.cs.ubc.ca/CPSC210/LongFormProblemStarters.git

// This class AboutScreen extends screen, it displays a description of the Bachelorette game
public class AboutScreen extends Screen {

    private static final String aboutDescription = "The Bachelorette is a reality tv dating show in which 30 "
            + " eligible male bachelors compete to find love with a chosen bachelorette. Each week, the "
            + " bachelorette goes on dates with the bachelors and eliminates those she does not have a connection with "
            + " through a rose ceremony. Men progressing to the next week of the show get a rose, men who do not get a "
            + " rose are sent home. This continues until two men remain, and the bachelorette accepts a marriage "
            + " proposal from one of them. There is romance, drama, love, and lots of laughs!";

    // EFFECTS: Constructs an AboutScreen with the BachGameJFrame as a controller
    public AboutScreen(BachGameJFrame controller) {
        super(controller);

        GridLayout layout = new GridLayout(1,1);
        setLayout(layout);

        layText();
    }

    //EFFECTS: Creates the description
    private void layText() {
        JTextArea description = new JTextArea(20, 20);
        description.setEditable(false);
        description.setText(aboutDescription);
        description.setWrapStyleWord(true);
        description.setLineWrap(true);
        this.add(description);
    }

}
