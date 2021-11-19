package ui.screens;

import ui.BachGameJFrame;

import javax.swing.*;

// This class references code from the LongFormProblemStartersRepository.
// Link: https://github.students.cs.ubc.ca/CPSC210/LongFormProblemStarters.git

public abstract class Screen extends JPanel {

    private final BachGameJFrame controller;

    //REQUIRES: BachGameJFrame controller that holds this screen
    public Screen(BachGameJFrame controller) {
        this.controller = controller;
    }

}
