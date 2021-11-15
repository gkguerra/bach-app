package ui.screens;

import ui.BachGameGUI;

import javax.swing.*;
import java.awt.*;

public class AboutScreen extends Screen {

    private JLabel description;
    private static final String aboutDescription = "The Bachelorette is a reality tv dating show in which 30 "
            + " eligible male bachelors compete to find love with a chosen bachelorette. Each week, the "
            + " bachelorette goes on dates with the bachelors and eliminates those she does not have a connection with "
            + " through a rose ceremony. Men progressing to the next week of the show get a rose, men who do not get a "
            + " rose are sent home. This continues until two men remain, and the bachelorette accepts a marriage "
            + " proposal from one of them. There is romance, drama, love, and lots of laughs!";


    public AboutScreen(BachGameGUI controller) {
        super(controller);

        GridLayout layout = new GridLayout(1,1);
        setLayout(layout);

        layText();
    }

    // https://stackoverflow.com/questions/26420428/how-to-word-wrap-text-in-jlabel
    //EFFECTS: creates greeting at top of console
    private void layText() {
        // description = new JLabel(aboutDescription, SwingConstants.CENTER);
        // description.setSize(WIDTH, HEIGHT / 3);

        JTextArea description = new JTextArea(20, 20);
        description.setText(aboutDescription);
        description.setWrapStyleWord(true);
        description.setLineWrap(true);
        this.add(description);
    }

}
