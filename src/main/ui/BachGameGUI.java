package ui;

import model.BachGame;
import ui.screens.CastScreen;
import ui.screens.ContestantScreen;
import ui.screens.AboutScreen;

import javax.swing.*;

import java.awt.*;

// https://stackoverflow.com/questions/20098124/displaying-an-image-in-a-jframe


public class BachGameGUI extends JFrame {
    public static final int ABOUT_INDEX = 0;
    public static final int CONT_INDEX = 1;
    public static final int CAST_INDEX = 2;
    public static final int QUIT_INDEX = 3;
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 1000;
    private static final Color PINK = new Color(255,192,203);

    private JTabbedPane topBar;
    private BachGame bachGame;

    QuitButton quitButton = new QuitButton();

    public BachGameGUI() {
        super("BachApp");
        this.setSize(WIDTH, HEIGHT);
        this.setBackground(PINK);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        bachGame = new BachGame();
        topBar = new JTabbedPane();
        topBar.setTabPlacement(JTabbedPane.TOP);
        loadTabs();
        add(topBar);
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
        topBar.add(aboutScreen, ABOUT_INDEX);
        topBar.setTitleAt(ABOUT_INDEX, "ABOUT");
        topBar.add(contestantScreen, CONT_INDEX);
        topBar.setTitleAt(CONT_INDEX, "CONTESTANTS");
        topBar.add(castScreen, CAST_INDEX);
        topBar.setTitleAt(CAST_INDEX, "EDIT CAST");
        topBar.add(quitButton, QUIT_INDEX);
        topBar.setTitleAt(QUIT_INDEX, "QUIT");
    }

    //EFFECTS: returns sidebar of this UI
    public JTabbedPane getTabbedPane() {
        return topBar;
    }

}
