package ru.eremin_dmitrii.lesson8;

import sun.util.resources.ms.CalendarData_ms_MY;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CalculatorPanel extends JPanel   {
private double result;
private String equation = "";
private String action;
    public CalculatorPanel() {
        setLayout(new BorderLayout());
        JButton label = new JButton("0");
        label.setEnabled(false);
        label.setFont(label.getFont().deriveFont(25f));
        add(label, BorderLayout.NORTH);
        JPanel panel = new JPanel(new GridLayout(5,3));
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton("" + i);
            btn.setFont(label.getFont().deriveFont(20f));
            btn.addActionListener(e -> {
            equation += btn.getText();
            label.setText(equation);
            });
            panel.add(btn);
        }

        JButton btnClear = new JButton("C");
        btnClear.setFont(label.getFont().deriveFont(25f));
        btnClear.addActionListener(e -> {
                equation = "0";
                label.setText(equation);
        });

        JButton btnSum = new JButton("+");
        btnSum.setFont(label.getFont().deriveFont(25f));
        btnSum.addActionListener(e -> {
            result= Double.parseDouble(label.getText());
            action = "+";
            label.setText("+");
            equation = "";
        });

        JButton btnMultiply = new JButton("*");
        btnMultiply.setFont(label.getFont().deriveFont(25f));
        btnMultiply.addActionListener(e -> {
            result= Double.parseDouble(label.getText());
            action = "*";
            label.setText("*");
            equation = "";
        });

        JButton btnSplit = new JButton("/");
        btnSplit.setFont(label.getFont().deriveFont(25f));
        btnSplit.addActionListener(e -> {
            result= Double.parseDouble(label.getText());
            action = "/";
            label.setText("/");
            equation = "";
        });

        JButton btnMinus = new JButton("-");
        btnMinus.setFont(label.getFont().deriveFont(25f));
        btnMinus.addActionListener(e -> {
            result= Double.parseDouble(label.getText());
            action = "-";
            label.setText("-");
            equation = "";
        });


        JButton btnEqual = new JButton("=");
        btnEqual.setFont(label.getFont().deriveFont(25f));
        btnEqual.addActionListener(e -> {
            double userInputTwo = Double.parseDouble(label.getText());
             if (action.equals("+")) result += userInputTwo;
             if (action.equals("-")) result -= userInputTwo;
             if (action.equals("*")) result *= userInputTwo;
             if (action.equals("/")) result /= userInputTwo;
             equation = String.valueOf(result);
             label.setText(equation);
        });

        panel.add(btnSum);
        panel.add(btnMinus);
        panel.add(btnMultiply);
        panel.add(btnSplit);
        panel.add(btnClear);
        panel.add(btnEqual);
        add(panel, BorderLayout.CENTER);
    }
}


