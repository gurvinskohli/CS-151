package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JComponent;

public class Frame extends JComponent {

    private Image image;

    private Graphics2D g2d;

    public Frame() {
        setDoubleBuffered(false);
    }

    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            g2d = (Graphics2D) image.getGraphics();
            g2d.clearRect(0, 0, getSize().width, getSize().height);
            redColor();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void redColor() {
        g2d.clearRect(0, 0, getSize().width, getSize().height);
        g2d.setPaint(Color.red);
        g2d.fillArc(50, 50, 50, 50, 0, 360);
        repaint();
    }

    public void greenColor() {
        g2d.clearRect(0, 0, getSize().width, getSize().height);
        g2d.setPaint(Color.green);
        g2d.fillArc(50, 50, 50, 50, 0, 360);
        repaint();
    }

    public void blueColor() {
        g2d.clearRect(0, 0, getSize().width, getSize().height);
        g2d.setPaint(Color.blue);
        g2d.fillArc(50, 50, 50, 50, 0, 360);
        repaint();
    }

}
