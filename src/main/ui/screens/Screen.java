package ui.screens;

import ui.StartJFrame;

import javax.swing.*;
import java.awt.*;

public abstract class Screen extends JPanel {

    private final StartJFrame controller;

    //REQUIRES: SmartHomeUI controller that holds this tab
    public Screen(StartJFrame controller) {
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
    public StartJFrame getController() {
        return controller;
    }
}
