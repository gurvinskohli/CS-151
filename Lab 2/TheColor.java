package com.company;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TheColor {

    JButton greenButton, redButton, blueButton;
    Frame paintGUI;

    ActionListener actionListener = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == greenButton) {
                paintGUI.greenColor();
            } else if (e.getSource() == redButton) {
                paintGUI.redColor();
            } else if (e.getSource() == blueButton) {
                paintGUI.blueColor();
            }
        }
    };

    public static void main(String[] args) {
        new TheColor().show();
    }

    public void show() {
        JFrame frame = new JFrame("Color");
        Container content = frame.getContentPane();

        content.setLayout(new BorderLayout());

        paintGUI = new Frame();

        content.add(paintGUI, BorderLayout.CENTER);

        JPanel controls = new JPanel();
        greenButton = new JButton("green");
        greenButton.addActionListener(actionListener);
        redButton = new JButton("red");
        redButton.addActionListener(actionListener);
        blueButton = new JButton("blue");
        blueButton.addActionListener(actionListener);

        controls.add(greenButton);
        controls.add(redButton);
        controls.add(blueButton);

        content.add(controls, BorderLayout.SOUTH);

        frame.setSize(400, 400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}

