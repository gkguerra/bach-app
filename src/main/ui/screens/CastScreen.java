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
// https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
// https://www.tutorialspoint.com/swingexamples/add_border_to_panel.htm

public class CastScreen extends Screen {

    private static final Color PINK = new Color(255,192,203);
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

        placeHeader();
        placeComboBox();
        placeViewButton();
        placeAddButton();
        placeRemoveButton();
        placeCastPanel();
    }

    private void placeHeader() {
        GridBagConstraints constraints = new GridBagConstraints();
        JLabel top = new JLabel(editCast, JLabel.CENTER);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.gridy = 0;
        constraints.ipady = -10;
        constraints.weighty = 0;
        setBackground(PINK);
        this.add(top, constraints);
    }

    private void placeComboBox() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridwidth = 1;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.ipady = 100;
        constraints.weighty = 0.16;
        this.add(cb, constraints);
    }

    private void placeViewButton() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy = 2;
        constraints.weightx = 0.5;
        constraints.ipady = 40;
        constraints.weighty = 0.16;
        viewButton.addActionListener(viewAction);
        this.add(viewButton, constraints);
    }

    private void placeAddButton() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.5;
        constraints.gridheight = 1;
        constraints.gridy = 2;
        constraints.ipady = 40;
        constraints.weighty = 0.16;
        addButton.addActionListener(addAction);
        this.add(addButton, constraints);
    }

    private void placeRemoveButton() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy = 2;
        constraints.ipady = 40;
        constraints.weightx = 0.5;
        constraints.weighty = 0.16;
        removeButton.addActionListener(removeAction);
        this.add(removeButton, constraints);
    }

    private void placeCastPanel() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.ipady = 50;
        constraints.weighty = 0.16;
        constraints.anchor = GridBagConstraints.CENTER;
        castPanel.setBackground(PINK);
        castPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        castPanel.add(castLabel, CENTER_ALIGNMENT);
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
                        + " is not in your cast or is set and could not be removed!");
            }
            castPanel.repaint();
        }
    }


}
