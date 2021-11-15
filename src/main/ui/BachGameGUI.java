package ui;

import model.BachGame;
import model.Contestant;
import ui.screens.CastScreen;
import ui.screens.ContestantScreen;
import ui.screens.AboutScreen;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// https://stackoverflow.com/questions/20098124/displaying-an-image-in-a-jframe


public class BachGameGUI extends JFrame {
    public static final int ABOUT_INDEX = 0;
    public static final int CONT_INDEX = 1;
    public static final int CAST_INDEX = 2;
    public static final int LEAD_INDEX = 3;

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 1000;

    private static final Color PINK = new Color(255,192,203);

    private JTabbedPane sidebar;
    private BachGame bachGame;

    public BachGameGUI() {
        super("BachApp");
        setSize(WIDTH, HEIGHT);
        setBackground(PINK);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();

        bachGame = new BachGame();

        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);

        loadTabs();
        add(sidebar);

        setVisible(true);
    }

    private void centreOnScreen() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((width - getWidth()) / 2, (height - getHeight()) / 2);
    }

    //EFFECTS: returns BachGame object controlled by this UI
    public BachGame getBachGame() {
        return bachGame;
    }

    public void loadTabs() {
        JPanel aboutScreen = new AboutScreen(this);
        JPanel contestantScreen = new ContestantScreen(this);
        JPanel castScreen = new CastScreen(this);
        sidebar.add(aboutScreen, ABOUT_INDEX);
        sidebar.setTitleAt(ABOUT_INDEX, "About the Bachelorette");
        sidebar.add(contestantScreen, CONT_INDEX);
        sidebar.setTitleAt(CONT_INDEX, "Contestants");
        sidebar.add(castScreen, CAST_INDEX);
        sidebar.setTitleAt(CAST_INDEX, "Edit Cast");
    }

    //EFFECTS: returns sidebar of this UI
    public JTabbedPane getTabbedPane() {
        return sidebar;
    }

}
