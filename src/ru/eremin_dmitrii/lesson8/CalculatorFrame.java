package ru.eremin_dmitrii.lesson8;

import javax.swing.*;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Calc");
        CalculatorPanel panel = new CalculatorPanel();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(650,200);
        setSize(300,300);
        add(panel);
    }
}
