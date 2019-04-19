package com.psousa.javaswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Components {

    private static JFrame mainFrame;
    private static JPanel mainPanel;
    private static JButton btnAction;
    private static JTextField inputAction;

    public Components() {
        showGui();
    }

    public static void main(String[] args) {
        Components main = new Components();
    }

    private void showGui() {
        mainFrame = new JFrame();
        mainFrame.setBounds(100, 100, 450, 300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(2, 0));


        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        mainFrame.add(mainPanel);

        btnAction = new JButton("Click Here");
        btnAction.setActionCommand("Action");

        inputAction = new JTextField(20);

        btnAction.addActionListener(new Components.BtnHandler());
        mainPanel.add(inputAction);
        mainPanel.add(btnAction);

        mainFrame.setVisible(true);
    }

    private class BtnHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "Action":
                    JOptionPane.showMessageDialog(null, inputAction.getText());
                    break;
                default:
                    System.out.println("Invalid Action");
            }
        }
    }
}
