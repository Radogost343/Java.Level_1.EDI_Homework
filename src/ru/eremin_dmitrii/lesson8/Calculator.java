package ru.eremin_dmitrii.lesson8;

import javax.swing.*;

public class Calculator {
    public static void main (String[] args) {
    CalculatorFrame frame = new CalculatorFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setSize(300,300);
    frame.setResizable(true);
    }
}

