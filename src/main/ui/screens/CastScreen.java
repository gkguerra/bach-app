package ui.screens;

import model.Cast;
import model.Contestant;
import ui.BachGameJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://stackoverflow.com/questions/11428573/write-a-string-on-a-jpanel-centered/11428834
// https://stackoverflow.com/questions/4123230/add-jbuttons-to-jpanel

public class CastScreen extends Screen {

    private static final String GREETING = "Here are all the current members of your cast:";
    private JLabel message;
    private ActionListener addAction = new AddAction();
    JButton addButton = new JButton(("Add"));

    Contestant c1 = new Contestant("Alec", "North Charleston", 2, 0, "Eligible");
    Contestant c2 = new Contestant("Brandon", "Portland", 0, 0, "Eligible");
    Contestant c3 = new Contestant("Bryan", "Chicago", 2, 3, "Eligible");
    Contestant c4 = new Contestant("Casey", "Miami Beach", 2, 1, "Eligible");
    Contestant c5 = new Contestant("Chris", "Halifax", 2, 3, "Eligible");
    Contestant c6 = new Contestant("Clayton", "Columbia", 2, 1, "Eligible");
    Contestant c7 = new Contestant("Daniel", "Austin", 2, 3, "Eligible");
    Contestant c8 = new Contestant("Edward", "Los Angeles", 2, 1, "Eligible");

    Contestant[] contestants = {c1, c2, c3, c4, c5, c6, c7, c8};
    JComboBox cb = new JComboBox((contestants));

    JPanel castPanel = new JPanel();
    JLabel castLabel = new JLabel("Your cast is: ");

    public CastScreen(BachGameJFrame controller) {
        super(controller);

        GridLayout layout = new GridLayout(5,5);
        setLayout(layout);

        placeMessage();
        placeButtons();
        placeCastPanel();
    }

    //EFFECTS: creates greeting at top of console
    private void placeMessage() {
        message = new JLabel(GREETING, JLabel.CENTER);
        message.setSize(WIDTH, HEIGHT / 3);
        this.add(message);
    }

    private void placeButtons() {
        this.add(cb);
        this.add(addButton);
        addButton.addActionListener(addAction);
    }

    private void placeCastPanel() {
        castPanel.add(castLabel);
        this.add(castPanel);
    }


    //LEARN HOW TO CAST
    // https://stackoverflow.com/questions/24057273/how-to-access-an-objects-parent-object-in-java
    // https://examples.javacodegeeks.com/desktop-java/swing/java-swing-tutorial-beginners/
    private class AddAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Cast masterCast = BachGameJFrame.getMasterCast();
            String contestantText;
            String oldText;
            String newText;
            String rejectText;
            Contestant addThisContestant = (Contestant) cb.getSelectedItem();
            oldText = castLabel.getText();
            contestantText = masterCast.getAllCastNames();

            castLabel.setText(oldText + contestantText);

            if (masterCast.size() < 3 && !masterCast.contains(addThisContestant)) {
                masterCast.addContestant(addThisContestant);
                newText = oldText + " " + addThisContestant.getName();
                castLabel.setText(newText);
            } else {
                rejectText = "Contestant not added. You have either already added them or your cast is full!";
                castLabel.setText(rejectText);
                // ADD BACK BUTTON OR BUILD A POP-UP TO DISPLAY THIS MESSAGE THAT CAN BE CLOSED
            }

            castPanel.repaint();
        }
    }


}
