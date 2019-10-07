package com.company;

import java.awt.BorderLayout;

import java.awt.Image;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.File;

import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

public class ZoomApp extends JFrame implements ActionListener {


    private JLabel label;

    private Image picture;

    private JButton zoomIn, zoomOut;

    private String name = "/Users/gurvinkohli/IdeaProjects/Homework Q4/src/imgbin-cartoon-animation-cars-cartoon-G89CrASFYvQrpaHwFDSgdRzcs.jpg";


    private int width = 400, height = 400;


    public ZoomApp() {


        label = new JLabel("", JLabel.CENTER);

        zoomIn = new JButton("Zoom in");

        zoomOut = new JButton("Zoom out");


        JPanel buttons = new JPanel();

        buttons.add(zoomIn);

        buttons.add(zoomOut);


        loadImage();


        setLayout(new BorderLayout());

        add(label, BorderLayout.CENTER);

        add(buttons, BorderLayout.PAGE_END);

        setSize(600, 600);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);


        zoomIn.addActionListener(this);

        zoomOut.addActionListener(this);

    }


    private void loadImage() {

        try {


            picture = ImageIO.read(new File(name));


            picture = picture.getScaledInstance(width, height,

                    Image.SCALE_SMOOTH);

            label.setIcon(new ImageIcon(picture));

            label.repaint();

        } catch (IOException e) {


            JOptionPane.showMessageDialog(this, name + " not found"

                    + "\nMake sure you have the file in root "

                    + "directory of your project");

            System.exit(0); //exiting

        }

    }

    public static void main(String[] args) {

        new ZoomApp();

    }

    @Override

    public void actionPerformed(ActionEvent e) {


        if (e.getSource().equals(zoomIn)) {


            width += 20;

            height += 20;


            loadImage();

        } else {


            width -= 20;

            height -= 20;


            if (width <= 0) {

                width = 1;

            }

            if (height <= 0) {

                height = 1;

            }

            loadImage();

        }

    }

}
