package ui;

import model.BachGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    // PROGRAM
    private static String JSON_STORE;
    private BachGame bachGame;

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
        bachGame = new BachGame();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        setVisible(true);
        GridLayout layout = new GridLayout(3,1);
        setLayout(layout);
        addWelcomeMessage();
        addEnterButtons();

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

    private class SubmitAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userName = e.getActionCommand();
            JSON_STORE = "./data" + userName + ".json";
        }
    }

    private class LogInAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            createPopUp("Please enter your account name here:");
            new MainJFrame();
            StartJFrame.this.dispose();
        }
    }

    private class SignUpAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            createPopUp("Please enter your name here:");
            new MainJFrame();
            StartJFrame.this.dispose();
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
        JSON_STORE = "./data/" + userNameEntered + ".json";
    }


}
