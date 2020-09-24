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

        JPanel panel = new JPanel(new GridLayout(5,4));

        for (int i = 7; i <= 9; i++) {
            JButton btn = new JButton("" + i);
            btn.setFont(label.getFont().deriveFont(20f));
            btn.addActionListener(e -> {
                equation += btn.getText();
                label.setText(equation);
            });
            panel.add(btn);
        }


        JButton btnSum = new JButton("+");
        btnSum.setFont(label.getFont().deriveFont(25f));
        btnSum.addActionListener(e -> {
            result = Double.parseDouble(label.getText());
            action = "+";
            label.setText("+");
            equation = "";
        });
        panel.add(btnSum);

        for (int i = 4; i <= 6; i++) {
            JButton btn = new JButton("" + i);
            btn.setFont(label.getFont().deriveFont(20f));
            btn.addActionListener(e -> {
                equation += btn.getText();
                label.setText(equation);
            });
            panel.add(btn);
        }

        JButton btnMinus = new JButton("-");
        btnMinus.setFont(label.getFont().deriveFont(25f));
        btnMinus.addActionListener(e -> {
            result= Double.parseDouble(label.getText());
            action = "-";
            label.setText("-");
            equation = "";
        });
        panel.add(btnMinus);


        for (int i = 1; i <= 3; i++) {
            JButton btn = new JButton("" + i);
            btn.setFont(label.getFont().deriveFont(20f));
            btn.addActionListener(e -> {
                equation += btn.getText();
                label.setText(equation);
            });
            panel.add(btn);
        }


        JButton btnMultiply = new JButton("*");
        btnMultiply.setFont(label.getFont().deriveFont(25f));
        btnMultiply.addActionListener(e -> {
            result= Double.parseDouble(label.getText());
            action = "*";
            label.setText("*");
            equation = "";
        });
        panel.add(btnMultiply);

        JButton btnDouble = new JButton(".");
        btnDouble.setFont(label.getFont().deriveFont(25f));
        btnDouble.addActionListener(e -> {
            equation += btnDouble.getText();
            label.setText(equation);
        });
        panel.add(btnDouble);

        JButton btn = new JButton("0");
        btn.setFont(label.getFont().deriveFont(20f));
        btn.addActionListener(e -> {
            equation += btn.getText();
            label.setText(equation);
        });
        panel.add(btn);

        JButton btnClear = new JButton("C");
        btnClear.setFont(label.getFont().deriveFont(25f));
        btnClear.addActionListener(e -> {
            equation = "0";
            label.setText(equation);
        });

        JButton btnRoot = new JButton("\u221A");
        btnRoot.setFont(label.getFont().deriveFont(25f));
        btnRoot.addActionListener(e -> {
            result = Double.parseDouble(label.getText());
            result = Math.sqrt(result);
            equation = String.valueOf(result);
            label.setText(equation);
        });
        panel.add(btnRoot);

        JButton btnSplit = new JButton("/");
        btnSplit.setFont(label.getFont().deriveFont(25f));
        btnSplit.addActionListener(e -> {
            result= Double.parseDouble(label.getText());
            action = "/";
            label.setText("/");
            equation = "";
        });
        panel.add(btnSplit);

        JButton btnSqr = new JButton("^2");
        btnSqr.setFont(label.getFont().deriveFont(25f));
        btnSqr.addActionListener(e -> {
            result = Double.parseDouble(label.getText());
            result = Math.pow(result, 2);
            equation = String.valueOf(result);
            label.setText(equation);
        });



        JButton btnPow = new JButton("+/-");
        btnPow.setFont(label.getFont().deriveFont(15f));
        btnPow.addActionListener(e -> {
            result = Double.parseDouble(label.getText());
            result *= -1;
            equation = String.valueOf(result);
            label.setText(equation);
        });



        JButton btnEqual = new JButton("=");
        btnEqual.setFont(label.getFont().deriveFont(25f));
        btnEqual.addActionListener(e -> {
            double userInputTwo = Double.parseDouble(label.getText());
            switch (action) {
                case "+":
                    result += userInputTwo;
                    break;
                case "-":
                    result -= userInputTwo;
                    break;
                case "*":
                    result *= userInputTwo;
                    break;
                case "/":
                    result /= userInputTwo;
                    break;
            }
             equation = String.valueOf(result);
             label.setText(equation);
        });

        panel.add(btnClear);
        panel.add(btnSqr);
        panel.add(btnPow);
        panel.add(btnEqual);

        add(panel, BorderLayout.CENTER);
    }
}


