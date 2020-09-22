package ru.eremin_dmitrii.lesson8;

import javax.swing.*;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Calc");
        CalculatorPanel panel = new CalculatorPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(650,200);
        add(panel);
    }
}
