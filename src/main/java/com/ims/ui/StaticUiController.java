package com.ims.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;


public class StaticUiController {

    public static void InitialiseUI() throws IOException {


        UiController uiController = new UiController();

        JFrame frame = new JFrame("DATA MANGLER 9000");
        frame.setSize(300, 300);
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


        // Create the BIG RED BUTTON
        // C:\Users\Admin\QA\QA-Exercise-Hard\Advanced-Task-QA\src\images
        //ImageIcon icon = new ImageIcon("src/images/missileSwitch.png"); // Load the image


        JButton imageButton = new JButton(new ImageIcon(StaticUiController.class.getResource("/missileSwitch.png")));
        imageButton.setBounds(100, 110, 100, 50); // Set position and size

        // Add action listener to the image button (optional)
        imageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Boom");
            }
        });



        // Add components to the frame
        frame.add(textField);
        frame.add(button);
        frame.add(imageButton);

        // Set frame visibility
        frame.setVisible(true);
    }
}

