package com.ims.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StaticUiController {

    public static void InitialiseUI() {


        UiController uiController = new UiController();

        JFrame frame = new JFrame("DATA MANGLER 9000");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Set layout to null for absolute positioning

        // Create a text box
        JTextField textField = new JTextField();
        textField.setBounds(50, 30, 200, 30); // Set position and size


        // Create a button
        JButton button = new JButton("Print to Console");
        button.setBounds(75, 70, 150, 30);

        // Add action listener to the button
        button.addActionListener(new

                                         ActionListener() {
                                             @Override
                                             public void actionPerformed(ActionEvent e) {
                                                 // Print the text from the text field to the console
                                                 System.out.println(textField.getText());
                                                 uiController.handleQuery(textField.getText());
                                             }
                                         });

        // Add components to the frame
        frame.add(textField);
        frame.add(button);

        // Set frame visibility
        frame.setVisible(true);
    }
}

