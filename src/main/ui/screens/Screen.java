package ui.screens;

import ui.BachGameGUI;

import javax.swing.*;
import java.awt.*;

public abstract class Screen extends JPanel {

    private final BachGameGUI controller;

    //REQUIRES: SmartHomeUI controller that holds this tab
    public Screen(BachGameGUI controller) {
        this.controller = controller;
    }

    //EFFECTS: creates and returns row with button included
    public JPanel formatButtonRow(JButton b) {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(b);

        return p;
    }

    //EFFECTS: returns the BachGameUI controller for this tab
    public BachGameGUI getController() {
        return controller;
    }
}
