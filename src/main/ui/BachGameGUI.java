package ui;

import javax.swing.*;
import model.Cast;
import model.Contestant;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// https://stackoverflow.com/questions/20098124/displaying-an-image-in-a-jframe


public class BachGameGUI extends JFrame {
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 1000;
    private static final Color PINK = new Color(255,192,203);
    private JDesktopPane desktop;

    public BachGameGUI() {

        desktop = new JDesktopPane();
        desktop.addMouseListener(new DesktopFocusAction());
        desktop.setBackground(Color.PINK);
        ImageIcon image = new ImageIcon("./data/images/imageLogo.png");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setVisible(true);
        imageLabel.setBounds(5, 5, 20, 20);
        desktop.add(imageLabel);
        desktop.setLayout(new FlowLayout());


        setContentPane(desktop);
        setBackground(PINK);
        setTitle("BachApp");
        setSize(WIDTH, HEIGHT);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        setVisible(true);

    }

    private class DesktopFocusAction extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            BachGameGUI.this.requestFocusInWindow();
        }
    }

    private void centreOnScreen() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((width - getWidth()) / 2, (height - getHeight()) / 2);
    }

}
