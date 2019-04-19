package com.psousa.javaswing;

import javax.swing.*;
import java.awt.*;

public class Hello {

    private JFrame frame;
    private JLabel lblHello;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Hello window = new Hello();
                     window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Hello() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        lblHello = new JLabel("",SwingConstants.CENTER);
        lblHello.setText("Hello World From Java Swing");

        frame.setBounds(100, 100, 450, 300);

        frame.add(lblHello);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("First Frame");
    }
}
