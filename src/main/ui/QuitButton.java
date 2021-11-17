package ui;

import model.Contestant;
import ui.screens.CastScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitButton extends JButton {

    private ActionListener quitAction = new QuitAction();

    public QuitButton() {
        JButton quitButton = new JButton("QUIT");
        quitButton.addActionListener(quitAction);
    }

    private class QuitAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }



//    private class AddAction implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            String oldText;
//            String newText;
//            Contestant addThisContestant = (Contestant) cb.getSelectedItem();
//            oldText = castLabel.getText();
//
//            if (cast.size() < 3 && !cast.contains(addThisContestant)) {
//                cast.addContestant(addThisContestant);
//                System.out.println(addThisContestant); // TO TEST OUTPUT
//                newText = oldText + " " + addThisContestant.getName();
//            } else {
//                newText = "This contestant cannot be added. You have either already added them or your cast is full!";
//                // ADD BACK BUTTON
//            }
//
//            castLabel.setText(newText);
//            castPanel.repaint();
//        }
//    }

}
