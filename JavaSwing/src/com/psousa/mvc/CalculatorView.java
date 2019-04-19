package com.psousa.mvc;

import javax.swing.*;
import java.awt.*;

public class CalculatorView {

    private JFrame mainFrame;
    private JButton btnCalc;
    private JTextField txtNumber1;
    private JTextField txtNumber2;
    private JComboBox operations;

    public CalculatorView() {
        prepareGui();
    }

    private void prepareGui() {
        mainFrame = new JFrame();
        mainFrame.setBounds(100, 100, 400, 250);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(4, 0));

        btnCalc = new JButton("Calculate");
        txtNumber1 = new JTextField(30);
        txtNumber2 = new JTextField(30);
        operations = new JComboBox();

        operations.addItem("+");
        operations.addItem("-");
        operations.addItem("*");
        operations.addItem("/");

        btnCalc.addActionListener(new CalculatorController(txtNumber1, txtNumber2, operations));
        mainFrame.add(txtNumber1);
        mainFrame.add(operations);
        mainFrame.add(txtNumber2);
        mainFrame.add(btnCalc);

        mainFrame.setVisible(true);
    }
}
