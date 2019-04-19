package com.psousa.mvc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {

    private JTextField txtNumber1 = new JTextField(30);
    private JTextField txtNumber2 = new JTextField(30);
    private JComboBox operations = new JComboBox();


    public CalculatorController(JTextField txtNumber1, JTextField txtNumber2, JComboBox operations) {
        this.txtNumber1 = txtNumber1;
        this.txtNumber2 = txtNumber2;
        this.operations = operations;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Integer result = 0;
        Integer num1 = this.txtNumber1.getText() == null ? 0 : Integer.parseInt(this.txtNumber1.getText());
        Integer num2 = this.txtNumber2.getText() == null ? 0 : Integer.parseInt(this.txtNumber2.getText());

        String operation = this.operations.getSelectedItem().toString();

        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                System.out.println("Operation Invalid!!");
        }

        JOptionPane.showMessageDialog(null, result.toString());
    }
}
