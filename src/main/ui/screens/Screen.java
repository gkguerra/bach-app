package ui.screens;

import ui.MainJFrame;

import javax.swing.*;
import java.awt.*;

public abstract class Screen extends JPanel {

    private final MainJFrame controller;

    //REQUIRES: SmartHomeUI controller that holds this tab
    public Screen(MainJFrame controller) {
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
    public MainJFrame getController() {
        return controller;
    }
}
