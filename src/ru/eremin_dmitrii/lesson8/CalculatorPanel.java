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

JButton label = new JButton("0");
JPanel panel = new JPanel(new GridLayout(5, 4));

public void addButton (String name) {
JButton button = new JButton(name);
button.setFont(label.getFont().deriveFont(20f));
button.addActionListener(e -> {
    equation += button.getText();
        label.setText(equation);
    });
    panel.add(button);
}

public void addButton (String name, String act) {
JButton button = new JButton(name);
button.setFont(label.getFont().deriveFont(25f));
button.addActionListener(e -> {
    result = Double.parseDouble(label.getText());
    action = act;
    label.setText(act);
    equation = "";
});
    panel.add(button);
}

    public CalculatorPanel() {
        setLayout(new BorderLayout());
        label.setEnabled(false);
        label.setFont(label.getFont().deriveFont(25f));
        add(label, BorderLayout.NORTH);

        addButton("7");
        addButton("8");
        addButton("9");
        addButton("+","+");
        addButton("4");
        addButton("5");
        addButton("6");
        addButton("-","-");
        addButton("1");
        addButton("2");
        addButton("3");
        addButton("*","*");
        addButton(".");
        addButton("0");

        JButton btnClear = new JButton("C");
        btnClear.setFont(label.getFont().deriveFont(25f));
        btnClear.addActionListener(e -> {
            equation = "0";
            label.setText(equation);
        });
        panel.add(btnClear);

        addButton("/","/");

        JButton btnRoot = new JButton("\u221A");
        btnRoot.setFont(label.getFont().deriveFont(25f));
        btnRoot.addActionListener(e -> {
            result = Double.parseDouble(label.getText());
            result = Math.sqrt(result);
            equation = String.valueOf(result);
            label.setText(equation);
        });
        panel.add(btnRoot);

        JButton btnSqr = new JButton("^2");
        btnSqr.setFont(label.getFont().deriveFont(25f));
        btnSqr.addActionListener(e -> {
            result = Double.parseDouble(label.getText());
            result = Math.pow(result, 2);
            equation = String.valueOf(result);
            label.setText(equation);
        });
        panel.add(btnSqr);

        JButton btnPow = new JButton("+/-");
        btnPow.setFont(label.getFont().deriveFont(15f));
        btnPow.addActionListener(e -> {
            result = Double.parseDouble(label.getText());
            result *= -1;
            equation = String.valueOf(result);
            label.setText(equation);
        });
        panel.add(btnPow);


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

        panel.add(btnEqual);

        add(panel, BorderLayout.CENTER);
    }
}


