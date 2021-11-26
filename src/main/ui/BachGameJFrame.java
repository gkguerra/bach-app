package ui;

import model.BachGame;
import model.Cast;
import model.EventLog;
import model.Event;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.screens.AboutScreen;
import ui.screens.CastScreen;
import ui.screens.ContestantScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

// This class and methods within this class references code and information from the following sources:
// https://stackoverflow.com/questions/16390503/java-swing-getting-input-from-a-jtextfield
// https://www.geeksforgeeks.org/java-swing-jtextarea/
// https://stackoverflow.com/questions/30369197/switch-between-multiple-jframes
// https://github.students.cs.ubc.ca/CPSC210/LongFormProblemStarters.git

// This is the main GUI frame for BachApp.
public class BachGameJFrame extends JFrame {

    // DESIGN
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 1000;
    private static final Color PINK = new Color(255,192,203);
    JPanel castScreen2 = new CastScreen(this);

    // TABBED PANE
    public static final int ABOUT_INDEX = 0;
    public static final int CONT_INDEX = 1;
    public static final int CAST_INDEX = 2;
    private JTabbedPane topBar;

    // PROGRAM
    private static String JSON_STORE;
    private static Cast masterCast;
    private BachGame bachGame;
    private EventLog eventLog;

    // JSON
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // ACTION LISTENERS
    private ActionListener signUpAction = new SignUpAction();
    private ActionListener logInAction = new LogInAction();

    // MAKE GRAPHIC COMPONENTS
    ImageIcon logo = new ImageIcon("data/images/rose.jpeg");
    JButton signUpButton = new JButton("SIGN UP");
    JButton logInButton = new JButton("LOG IN");
    JButton enterNameButton = new JButton("ENTER");
    ImageIcon bachLogo = new ImageIcon("data/images/bachlogo.png");
    private JLabel image;

    // EFFECTS: Constructs the application window with the appropriate components.
    public BachGameJFrame() {
        super("BachApp");
        this.setSize(WIDTH, HEIGHT);
        this.getContentPane().setBackground(PINK);
        this.addWindowListener(new BachGameJFrame.SaveOrQuit());
        bachGame = new BachGame();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        setVisible(true);
        GridLayout layout = new GridLayout(3,1);
        setLayout(layout);
        addImage();
        addEnterButtons();
    }

    // MODIFIES: This.
    // EFFECTS: Adds the header image to the BachGameJFrame.
    private void addImage() {
        image = new JLabel(bachLogo, JLabel.CENTER);
        image.setSize(WIDTH, HEIGHT / 3);
        this.add(image);
    }

    // MODIFIES: This.
    // EFFECTS: Switches the components of the BachGameJFrame to reflect that the user has logged in.
    private void switchToMain() {
        this.getContentPane().remove(signUpButton);
        this.getContentPane().remove(logInButton);
        this.repaint();
        this.remove(image);
        this.repaint();
        GridLayout layout = new GridLayout(1,1);
        setLayout(layout);
        topBar = new JTabbedPane();
        topBar.setTabPlacement(JTabbedPane.TOP);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.add(topBar);
        this.loadScreens();
    }

    // MODIFIES: This.
    // EFFECTS: Loads the three different screens into the screen bar at the top.
    public void loadScreens() {
        JPanel aboutScreen = new AboutScreen(this);
        JPanel contestantScreen = new ContestantScreen(this);
        topBar.add(aboutScreen, ABOUT_INDEX);
        topBar.setTitleAt(ABOUT_INDEX, "ABOUT");
        topBar.add(contestantScreen, CONT_INDEX);
        topBar.setTitleAt(CONT_INDEX, "CONTESTANTS");
        topBar.add(castScreen2, CAST_INDEX);
        topBar.setTitleAt(CAST_INDEX, "EDIT CAST");
    }

    // MODIFIES: This.
    // EFFECTS: User to saves or doesn't save their data when quitting the application and the event log is printed.
    private class SaveOrQuit extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            int option = JOptionPane.showOptionDialog(BachGameJFrame.this,
                    "Would you like to save the state of your account?", "BachApp",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, logo, null,
                    null);
            if (option == JOptionPane.YES_OPTION) {
                saveCast();
                printEvents();
                System.exit(0);
            } else if (option == JOptionPane.NO_OPTION) {
                printEvents();
                System.exit(0);
            }
        }
    }

    // MODIFIES: This.
    // EFFECTS: Centres the GUI on the computer screen.
    private void centreOnScreen() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((width - getWidth()) / 2, (height - getHeight()) / 2);
    }

    // MODIFIES: This.
    // EFFECT: Adds the log-in and sign-up buttons to the BachGameJFrame.
    public void addEnterButtons() {
        logInButton.setSize(WIDTH, HEIGHT / 3);
        this.add(logInButton);
        logInButton.addActionListener(logInAction);
        signUpButton.setSize(WIDTH, HEIGHT / 3);
        this.add(signUpButton);
        signUpButton.addActionListener(signUpAction);
    }

    // MODIFIES: This.
    // EFFECTS: When login is pressed, prompts user to enter their name and loads the JSON file for their account.
    private class LogInAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JTextArea enterName = new JTextArea("Please enter your account name here:",1, 1);
            JOptionPane total = new JOptionPane("BachGameJFrame.this", JOptionPane.QUESTION_MESSAGE,
                    JOptionPane.YES_OPTION);
            JPanel namePanel = new JPanel();
            namePanel.add(enterName, BorderLayout.SOUTH);
            namePanel.add(enterNameButton);
            total.add(namePanel);
            total.setIcon(logo);
            total.setBackground(PINK);
            String userNameEntered = total.showInputDialog(BachGameJFrame.this,
                    "Please enter your name here:");

            if (userNameEntered != null) {
                BachGameJFrame.this.JSON_STORE = "./data/" + userNameEntered + ".json";
                jsonWriter = new JsonWriter(JSON_STORE);
                jsonReader = new JsonReader(JSON_STORE);
                loadCast();
                switchToMain();
            }
        }
    }

    // MODIFIES: This.
    // EFFECTS: When login is pressed, prompts user to enter their name and creates a JSON file for the new account.
    private class SignUpAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JTextArea enterName = new JTextArea("Please enter your name here:",1, 1);
            JOptionPane total = new JOptionPane();
            JPanel namePanel = new JPanel();
            namePanel.add(enterName, BorderLayout.SOUTH);
            namePanel.add(enterNameButton);
            total.add(namePanel);
            total.setIcon(logo);
            total.setBackground(PINK);
            String userNameEntered = total.showInputDialog(BachGameJFrame.this,
                    "Please enter your name here:");
            BachGameJFrame.this.JSON_STORE = "./data/" + userNameEntered + ".json";
            masterCast = new Cast(userNameEntered, 123);
            jsonWriter = new JsonWriter(JSON_STORE);
            jsonReader = new JsonReader(JSON_STORE);
            switchToMain();
        }
    }

    // EFFECTS: Saves the Cast to JSON, throws FileNotFoundException if it cannot write to the file
    private void saveCast() {
        try {
            jsonWriter.open();
            jsonWriter.write(masterCast);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            notAnAccount();
            System.out.println("Unable to write to file " + JSON_STORE);
        }
    }

    // EFFECTS: Shows a pop-up error message if user tries to load from an account that isn't created.
    private void notAnAccount() {
        JOptionPane error = new JOptionPane();
        error.showInternalMessageDialog(BachGameJFrame.this, "This is not an account.",
                "BachApp", JOptionPane.INFORMATION_MESSAGE);
    }

    // EFFECTS: Loads a Cast from JSON, throws an IOException if it cannot read the file
    private void loadCast() {
        try {
            masterCast = jsonReader.read();
        } catch (IOException e) {
            System.out.println("Unable to read from file " + JSON_STORE);
        }
    }

    // EFFECTS: Returns the masterCast from this class.
    public static Cast getMasterCast() {
        return masterCast;
    }

    public void printEvents() {
        for (Event e: EventLog.getInstance()) {
            System.out.println(e);
        }
    }

}
