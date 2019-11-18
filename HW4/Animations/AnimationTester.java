package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 This program implements an animation that moves
 a car shape.
 */
public class AnimationTester
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();

        final MoveableShape shape
                = new CarShape(0, 0, CAR_WIDTH);
        final MoveableShape newShape
                = new CarShape(0, 0, CAR_WIDTH);
        final MoveableShape thirdShape
                = new CarShape(0, 0, CAR_WIDTH);
        final MoveableShape fourthShape
                = new CarShape(0, 0, CAR_WIDTH);

        ShapeIcon icon = new ShapeIcon(shape,
                ICON_WIDTH, ICON_HEIGHT);

        ShapeIcon newIcon = new ShapeIcon(newShape,
                ICON_WIDTH, ICON_HEIGHT);
        ShapeIcon thirdIcon = new ShapeIcon(thirdShape,
                ICON_WIDTH, ICON_HEIGHT);
        ShapeIcon fourthIcon = new ShapeIcon(fourthShape,
                ICON_WIDTH, ICON_HEIGHT);

        final JLabel label = new JLabel(icon);
        frame.setLayout(new FlowLayout());
        final JLabel newLabel = new JLabel(newIcon);
        frame.setLayout(new FlowLayout());
        final JLabel thirdLabel = new JLabel(thirdIcon);
        final JLabel fourthLabel = new JLabel(fourthIcon);
        frame.setLayout(new FlowLayout());
        frame.add(label);
        frame.add(newLabel);
        frame.add(thirdLabel);
        frame.add(fourthLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.setVisible(true);

        final int DELAY = 100;
        // Milliseconds between timer ticks
        Timer t = new Timer(DELAY, event ->
        {
            shape.move();
            label.repaint();
        });
        t.start();

        final int newDelay = 50;
        // Milliseconds between timer ticks
        Timer newT = new Timer(newDelay, event ->
        {
            newShape.move();
            newLabel.repaint();
        });
        newT.start();

        final int thirdDelay = 25;
        // Milliseconds between timer ticks
        Timer thirdT = new Timer(thirdDelay, event ->
        {
            thirdShape.move();
            thirdLabel.repaint();
        });
        thirdT.start();

        final int fourthDelay = 12;
        // Milliseconds between timer ticks
        Timer fourthT = new Timer(fourthDelay, event ->
        {
            fourthShape.move();
            fourthLabel.repaint();
        });
        fourthT.start();
    }

    private static final int ICON_WIDTH = 400;
    private static final int ICON_HEIGHT = 100;
    private static final int CAR_WIDTH = 100;
}
