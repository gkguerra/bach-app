package ui.screens;

import model.Cast;
import model.Contestant;
import ui.BachGameJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

// https://stackoverflow.com/questions/11428573/write-a-string-on-a-jpanel-centered/11428834
// https://stackoverflow.com/questions/4123230/add-jbuttons-to-jpanel

public class CastScreen extends Screen {

    private static final String GREETING = "Here are all the current members of your cast:";
    private JLabel message;
    private ActionListener addAction = new AddAction();
    private RemoveAction removeAction = new RemoveAction();
    private ViewAction viewAction = new ViewAction();
    JButton addButton = new JButton(("ADD"));
    JButton removeButton = new JButton(("REMOVE"));
    JButton viewButton = new JButton(("VIEW CAST"));

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
    JLabel castLabel = new JLabel();
    ImageIcon editCast = new ImageIcon("data/images/editcast.png");

    public CastScreen(BachGameJFrame controller) {
        super(controller);

        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        headerConstraints();
        comboBoxConstraints();
        addButtonConstraints();
        viewButtonConstraints();
        removeButtonConstraints();

        placeCastPanel();
    }

    private void removeButtonConstraints() {
        GridBagConstraints constraints5 = new GridBagConstraints();
        constraints5.fill = GridBagConstraints.HORIZONTAL;
        constraints5.gridx = 2;
        constraints5.gridwidth = 1;
        constraints5.gridheight = 1;
        constraints5.gridy = 2;
        constraints5.ipady = 40;
        constraints5.weightx = 0.5;
        removeButton.addActionListener(removeAction);
        this.add(removeButton, constraints5);
    }

    private void viewButtonConstraints() {
        GridBagConstraints constraints4 = new GridBagConstraints();
        constraints4.fill = GridBagConstraints.HORIZONTAL;
        constraints4.gridx = 0;
        constraints4.gridwidth = 1;
        constraints4.gridheight = 1;
        constraints4.gridy = 2;
        constraints4.weightx = 0.5;
        constraints4.ipady = 40;
        viewButton.addActionListener(viewAction);
        this.add(viewButton, constraints4);
    }

    private void addButtonConstraints() {
        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.fill = GridBagConstraints.HORIZONTAL;
        constraints3.gridx = 1;
        constraints3.gridwidth = 1;
        constraints3.weightx = 0.5;
        constraints3.gridheight = 1;
        constraints3.gridy = 2;
        constraints3.ipady = 40;
        addButton.addActionListener(addAction);
        this.add(addButton, constraints3);
    }

    private void comboBoxConstraints() {
        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.fill = GridBagConstraints.HORIZONTAL;
        constraints2.gridx = 0;
        constraints2.gridwidth = 3;
        constraints2.gridy = 1;
        constraints2.gridheight = 1;
        this.add(cb, constraints2);
    }

    private void headerConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        message = new JLabel(editCast, JLabel.CENTER);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.gridy = 0;
        this.add(message, constraints);
    }

    private void placeCastPanel() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.ipady = 50;
        constraints.anchor = GridBagConstraints.CENTER;
        castPanel.add(castLabel);
        this.add(castPanel, constraints);
    }


    //LEARN HOW TO CAST
    // https://stackoverflow.com/questions/24057273/how-to-access-an-objects-parent-object-in-java
    // https://examples.javacodegeeks.com/desktop-java/swing/java-swing-tutorial-beginners/
    private class AddAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Cast masterCast = BachGameJFrame.getMasterCast();
            String newText;
            String rejectText;
            Contestant addThisContestant = (Contestant) cb.getSelectedItem();

            if (masterCast.size() < 3 && !masterCast.contains(addThisContestant)) {
                masterCast.addContestant(addThisContestant);
                newText = addThisContestant.getName() + " has been added to your cast!";
                castLabel.setText(newText);
            } else {
                rejectText = "Contestant not added. You have either already added them or your cast is full!";
                castLabel.setText(rejectText);
                // ADD BACK BUTTON OR BUILD A POP-UP TO DISPLAY THIS MESSAGE THAT CAN BE CLOSED
            }

            castPanel.repaint();
        }
    }

    private class ViewAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Cast masterCast = BachGameJFrame.getMasterCast();
            if (masterCast.getContestants() != null) {
                castLabel.setText(masterCast.getAllCastNames());
            } else {
                castLabel.setText("Your cast is currently empty. Add some contestants now!");
            }

            castPanel.repaint();
        }
    }

    private class RemoveAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Cast masterCast = BachGameJFrame.getMasterCast();
            Contestant removeThisContestant = (Contestant) cb.getSelectedItem();

            if (masterCast.contains(removeThisContestant)) {
                masterCast.remove(removeThisContestant);
                castLabel.setText(removeThisContestant.getName() + " has been removed from your cast!");
            } else {
                castLabel.setText(removeThisContestant.getName()
                        + " is not in your cast and therefore could not be removed!");
            }

            castPanel.repaint();
        }
    }


}
