/*
package ui;

import model.BachGame;
import model.Cast;
import ui.screens.CastScreen;
import ui.screens.ContestantScreen;
import ui.screens.AboutScreen;

import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// https://stackoverflow.com/questions/20098124/displaying-an-image-in-a-jframe
// https://stackoverflow.com/questions/15198549/popup-for-jframe-close-button

public class MainJFrame extends JFrame {
    public static final int ABOUT_INDEX = 0;
    public static final int CONT_INDEX = 1;
    public static final int CAST_INDEX = 2;
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 1000;
    private static final Color PINK = new Color(255,192,203);
    private Cast cast;

    private JTabbedPane topBar;
    private BachGame bachGame;

    ImageIcon logo = new ImageIcon("data/images/rose.jpeg");

    public MainJFrame() {
        super();
        this.setSize(WIDTH, HEIGHT);
        this.getContentPane().setBackground(PINK);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        centreOnScreen();
        bachGame = new BachGame();
        topBar = new JTabbedPane();
        topBar.setTabPlacement(JTabbedPane.TOP);
        addWindowListener(new SaveOrQuit());
        loadTabs();
        add(topBar);
        setVisible(true);
    }

    private void centreOnScreen() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((width - getWidth()) / 2, (height - getHeight()) / 2);
    }

//    //EFFECTS: returns BachGame object controlled by this UI
//    public BachGame getBachGame() {
//        return bachGame;
//    }

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
    }

    //EFFECTS: returns sidebar of this UI
    public JTabbedPane getTabbedPane() {
        return topBar;
    }

    private class SaveOrQuit extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            int option = JOptionPane.showOptionDialog(MainJFrame.this,
                    "Would you like to save the state of your account?", "BachApp",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, logo, null,
                    null);
            if (option == JOptionPane.YES_OPTION) {
                // SAVE STUFF
            } else if (option == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        }
    }



}
*/
