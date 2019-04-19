package com.psousa.javaswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {

    private static JFrame mainFrame;
    private static JPanel mainPanel;
    private static JButton btnCalc;
    private static JTextField txtNumber1;
    private static JTextField txtNumber2;
    private static  JComboBox operations;

    public Calculator() {
        prepareGui();
    }

    public static void main(String[] args) {
        Calculator main = new Calculator();
    }

    private void prepareGui() {
        mainFrame = new JFrame();
        mainFrame.setBounds(100, 100, 400, 250);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(4, 0));

        btnCalc = new JButton("Calculate");
        btnCalc.setActionCommand("Calc");

        txtNumber1 = new JTextField(30);
        txtNumber2 = new JTextField(30);
        operations = new JComboBox();

        operations.addItem("+");
        operations.addItem("-");
        operations.addItem("*");
        operations.addItem("/");

        btnCalc.addActionListener(new Calculator.BtnHandler());
        mainFrame.add(txtNumber1);
        mainFrame.add(operations);
        mainFrame.add(txtNumber2);
        mainFrame.add(btnCalc);

        mainFrame.setVisible(true);
    }

    private class BtnHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "Calc":
                    if (txtNumber1.getText() == null ||
                        txtNumber2.getText() == null ||
                        operations.getSelectedItem() == null
                    ) {
                        System.out.println("OPTIONS NULL");
                        break;
                    }

                    Integer result = 0;
                    Integer number1 = Integer.parseInt(txtNumber1.getText());
                    Integer number2 = Integer.parseInt(txtNumber2.getText());
                    String operation = operations.getSelectedItem().toString();

                    if (operation == "+") {
                        result = number1 + number2;
                    } else if (operation == "-") {
                        result = number1 - number2;
                    } else if (operation == "*") {
                        result = number1 * number2;
                    } else if (operation == "/") {
                        result = number1 / number2;
                    }

                    String message = txtNumber1.getText();
                    message += " " + operations.getSelectedItem().toString();
                    message += " " + txtNumber2.getText();
                    message += " = " + result.toString();

                    JOptionPane.showMessageDialog(null, message);

                    break;
                default:
                    System.out.println("Invalid Action");
            }
        }
    }


}
