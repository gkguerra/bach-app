package ui.screens;

import model.Cast;
import model.Contestant;
import ui.BachGameGUI;

import javax.swing.*;
import java.awt.*;

public class CastScreen extends Screen {

    private static final String GREETING = "Here are all the current members of your cast:";
    private JLabel message;
    private JLabel emptyMessage;
    Cast cast;

    public CastScreen(BachGameGUI controller) {
        super(controller);

        GridLayout layout = new GridLayout(3,1);
        setLayout(layout);

        placeMessage();
        placeCast();
        placeButtons();
    }

    //EFFECTS: creates greeting at top of console
    private void placeMessage() {
        message = new JLabel(GREETING, JLabel.CENTER);
        message.setSize(WIDTH, HEIGHT / 3);
        this.add(message);
    }

    private void placeCast() {
        if (cast == null) {
            emptyMessage = new JLabel("Your cast is empty - add some contestants to your cast below!");
            this.add(emptyMessage);
        } else {
            for (Contestant c : cast.getContestants()) {
                new JLabel(c.getName());
                this.add(message);
            }
        }
    }

    private void placeButtons() {

        JButton addButton = new JButton(("Add"));
        JButton removeButton = new JButton(("Remove"));

        this.add(addButton);
        this.add(removeButton);

        removeButton.addActionListener(e -> {
            getController().getBachGame();
        });
    }
}

