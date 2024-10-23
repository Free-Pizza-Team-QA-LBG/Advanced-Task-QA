package com.ims.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;


public class StaticUiController {

    public static void InitialiseUI() throws IOException {


        UiController uiController = new UiController();

        JFrame frame = new JFrame("DATA MANGLER 9000");
        frame.setSize(300, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Set layout to null for absolute positioning

        // Create a text box
        ArrayList<JTextField> textFieldArray = new ArrayList<>();
        JTextField textField;
        for (int i = 0; i < 6; i++) {
            textField = new JTextField();
            textField.setBounds(50, 30 + i*40, 200, 30);
            textFieldArray.add(textField);
        }


        // Create a button
        JButton button = new JButton("Print to Console");
        button.setBounds(75, 310, 150, 30);

        // Add action listener to the button
        button.addActionListener(new

            ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     // Print the text from the text field to the console
                     System.out.println(textFieldArray.get(0).getText());
                     uiController.handleQuery(textArrayToString(textFieldArray));
                 }
             });


        // Create the BIG RED BUTTON
        // C:\Users\Admin\QA\QA-Exercise-Hard\Advanced-Task-QA\src\images
        //ImageIcon icon = new ImageIcon("src/images/missileSwitch.png"); // Load the image


        JButton imageButton = new JButton(new ImageIcon(StaticUiController.class.getResource("/missileSwitch.png")));
        imageButton.setBounds(100, 350, 100, 50); // Set position and size

        // Add action listener to the image button (optional)
        imageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Boom");
            }
        });



        // Add components to the frame
        for (int i = 0; i < 6; i++) {
            frame.add(textFieldArray.get(i));
        }
        frame.add(button);
        frame.add(imageButton);

        // Set frame visibility
        frame.setVisible(true);
    }

    private static ArrayList<String> textArrayToString(ArrayList<JTextField> textArray) {

        ArrayList<String> stringArray = new ArrayList<>();
        for (int i = 0; i < textArray.size(); i++) {
            stringArray.add(textArray.get(i).getText());
        }

        return stringArray;

    }
}

