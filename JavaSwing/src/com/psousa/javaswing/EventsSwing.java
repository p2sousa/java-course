package com.psousa.javaswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventsSwing {

    private static JFrame mainFrame;
    private  static JPanel mainPanel;
    private static JButton btnAction;

    public EventsSwing() {
        showGui();
    }

    public static void main(String[] args) {
        EventsSwing main = new EventsSwing();
    }

    private void showGui() {
        mainFrame = new JFrame();
        mainFrame.setBounds(100, 100, 450, 300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        mainFrame.add(mainPanel);

        btnAction = new JButton("Click Here");
        btnAction.setActionCommand("Action");

        btnAction.addActionListener(new BtnHandler());
        mainPanel.add(btnAction);
    }

    private class BtnHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "Action":
                    JOptionPane.showMessageDialog(null, "My first event");
                    break;
                default:
                    System.out.println("Invalid Action");
            }
        }
    }
}
