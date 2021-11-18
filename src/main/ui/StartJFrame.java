package ui;

import model.BachGame;
import model.Cast;
import ui.screens.AboutScreen;
import ui.screens.CastScreen;
import ui.screens.ContestantScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// https://stackoverflow.com/questions/16390503/java-swing-getting-input-from-a-jtextfield
// https://www.geeksforgeeks.org/java-swing-jtextarea/
// https://stackoverflow.com/questions/30369197/switch-between-multiple-jframes

public class StartJFrame extends JFrame {

    // DESIGN
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 1000;
    private static final Color PINK = new Color(255,192,203);
    private static final String GREETING = "Welcome to BachApp!";
    private JLabel message;

    // TABBED PANE
    public static final int ABOUT_INDEX = 0;
    public static final int CONT_INDEX = 1;
    public static final int CAST_INDEX = 2;
    private JTabbedPane topBar;

    // PROGRAM
    private static String JSON_STORE;
    private BachGame bachGame;
    private Cast cast;

    // ACTION LISTENERS
    private ActionListener signUpAction = new SignUpAction();
    private ActionListener logInAction = new LogInAction();

    // MAKE GRAPHIC COMPONENTS
    ImageIcon logo = new ImageIcon("data/images/rose.jpeg");
    JButton signUpButton = new JButton("SIGN UP");
    JButton logInButton = new JButton("LOG IN");
    JButton enterNameButton = new JButton("ENTER");

    // START THE APPLICATION
    public StartJFrame() {
        super("BachApp");
        this.setSize(WIDTH, HEIGHT);
        this.getContentPane().setBackground(PINK);
        this.addWindowListener(new StartJFrame.SaveOrQuit());
        bachGame = new BachGame();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        setVisible(true);
        GridLayout layout = new GridLayout(3,1);
        setLayout(layout);
        addWelcomeMessage();
        addEnterButtons();
    }

    private void switchToMain() {
        this.getContentPane().remove(signUpButton);
        System.out.println("Removed sign up");
        this.getContentPane().remove(logInButton);
        this.repaint();
        System.out.println("Removed log on");
        this.getContentPane().remove(message);
        this.repaint();
        System.out.println("Removed message");
        GridLayout layout = new GridLayout(1,1);
        setLayout(layout);
        topBar = new JTabbedPane();
        topBar.setTabPlacement(JTabbedPane.TOP);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.add(topBar);
        this.loadTabs();
        //removeButtons();
    }

    private void removeButtons() {
        this.remove(signUpButton);
        this.remove(logInButton);
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
    }

    private class SaveOrQuit extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            int option = JOptionPane.showOptionDialog(StartJFrame.this,
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

    private void addWelcomeMessage() {
        message = new JLabel(GREETING, JLabel.CENTER);
        message.setSize(WIDTH, HEIGHT / 3);
        this.add(message);
    }

    private void centreOnScreen() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((width - getWidth()) / 2, (height - getHeight()) / 2);
    }

    public void addEnterButtons() {
        this.add(logInButton);
        logInButton.addActionListener(logInAction);
        this.add(signUpButton);
        signUpButton.addActionListener(signUpAction);
    }

    private class LogInAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            createPopUp("Please enter your account name here:");
            switchToMain();
        }
    }

    private class SignUpAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            createPopUp("Please enter your name here:");
            switchToMain();
        }
    }

    public void createPopUp(String message) {
        JTextArea enterName = new JTextArea(message,1, 1);
        JOptionPane total = new JOptionPane();
        JPanel namePanel = new JPanel();
        namePanel.add(enterName, BorderLayout.SOUTH);
        namePanel.add(enterNameButton);
        total.add(namePanel);
        total.setIcon(logo);
        total.setBackground(PINK);
        String userNameEntered = total.showInputDialog(StartJFrame.this, "Please enter your name here:");
        StartJFrame.this.JSON_STORE = "./data/" + userNameEntered + ".json";
        //new MainJFrame();
    }


}
