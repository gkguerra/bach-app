package ui;

import jdk.nashorn.internal.scripts.JO;
import model.BachGame;
import model.Contestant;
import ui.screens.CastScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://stackoverflow.com/questions/16390503/java-swing-getting-input-from-a-jtextfield
// https://www.geeksforgeeks.org/java-swing-jtextarea/

public class StartJFrame extends JFrame {

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 1000;
    private static final Color PINK = new Color(255,192,203);
    private static String JSON_STORE;

    private BachGame bachGame;

    JButton signUpButton = new JButton("SIGN UP");
    JButton logInButton = new JButton("LOG IN");
    JButton enterNameButton = new JButton("ENTER");

    JPanel namePanel = new JPanel();

    private ActionListener signUpAction = new SignUpAction();
    private ActionListener logInAction = new LogInAction();

    public StartJFrame() {
        super("BachApp");
        this.setSize(WIDTH, HEIGHT);
        this.getContentPane().setBackground(PINK);
        this.add(namePanel);
        bachGame = new BachGame();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        setVisible(true);
        GridLayout layout = new GridLayout(3,3);
        setLayout(layout);
        addEnterButtons();
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
            System.out.println("Pressed login");
            JTextArea enterName = new JTextArea("Please enter your account name here:",1, 1);
            namePanel.add(enterName);
            namePanel.add(enterNameButton);
            JOptionPane total = new JOptionPane();
            total.add(namePanel);
        }
    }

    private class SignUpAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JTextArea enterName = new JTextArea("Please enter your name here:",1,1);
            namePanel.add(enterName, BorderLayout.SOUTH);
        }
    }


}
